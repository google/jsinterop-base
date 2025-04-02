#!/bin/bash -i
# Copyright 2019 Google Inc. All Rights Reserved
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS-IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# The script generates the open source artifacts for jsinterop.base and
# uploads them to sonatype.

set -e

lib_version=$1

usage() {
    echo ""
    echo "$(basename $0): Build and deploy script for JsInterop Base."
    echo ""
    echo "$(basename $0) --version <version> [--no-deploy]"
    echo "    --help"
    echo "        Print this help output and exit."
    echo "    --version <version>"
    echo "        Maven version of the library to use for deploying to sonatype."
    echo "    --no-deploy"
    echo "        Skip the deployment part but build all artifacts."
    echo "    --no-git-tag"
    echo "        Skip the creation of git tag."
    echo ""
}

deploy_flag=""
git_tag=true

while [[ "$1" != "" ]]; do
  case $1 in
    --version )    if [ -z $2 ] || [[ $2 == "--no-deploy" ]]; then
                     echo "Error: Incorrect version value."
                     usage
                     exit 1
                   fi
                   shift
                   lib_version=$1
                   ;;
    --no-deploy )  deploy_flag="--no-deploy"
                   ;;
    --no-git-tag ) git_tag=false
                   ;;
    --help )       usage
                   exit 1
                   ;;
    * )            echo "Error: unexpected option $1"
                   usage
                   exit 1
                   ;;
  esac
  shift
done

if [[ -z "$lib_version" ]]; then
  echo "Error: --version flag is missing"
  usage
  exit 1
fi

if [ ! -f "MODULE.bazel" ]; then
  echo "Error: should be run from the root of the Bazel repository"
  exit 1
fi

bazel_root=$(pwd)

deploy_target='@com_google_j2cl//maven:deploy'
group_id="com.google.jsinterop"
maven_artifact="base"

cd ${bazel_root}

# ask bazel to explicitly build both jar files
bazel build //java/jsinterop/base:libbase.jar
bazel build //java/jsinterop/base:libbase-src.jar
bazel build //java/jsinterop/base:base-javadoc.jar

jar_file=${bazel_root}/bazel-bin/java/jsinterop/base/libbase.jar
src_jar=${bazel_root}/bazel-bin/java/jsinterop/base/libbase-src.jar
javadoc_jar=${bazel_root}/bazel-bin/java/jsinterop/base/base-javadoc.jar
pom_template=${bazel_root}/maven/pom-base.xml

# we cannot run the script directly from Bazel because it doesn't allow interactive script
runcmd="$(mktemp /tmp/bazel-run.XXXXXX)"
bazel run --script_path="$runcmd" ${deploy_target} -- ${deploy_flag} \
    --artifact ${maven_artifact} \
    --jar-file ${jar_file} \
    --src-jar ${src_jar} \
    --javadoc-jar ${javadoc_jar} \
    --pom-template ${pom_template} \
    --lib-version ${lib_version} \
    --group-id ${group_id}
"$runcmd"

rm "$runcmd"

if [[ ${git_tag} == true ]]; then
  git tag -a ${lib_version} -m "${lib_version} release"
  git push origin ${lib_version}
fi
