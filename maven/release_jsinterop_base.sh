#!/bin/bash
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
set -euo pipefail

source "$(dirname "$0")/deploy.sh"

readonly DEPLOY_TARGET='@com_google_j2cl//maven:deploy'
readonly GROUP_ID="com.google.jsinterop"
readonly MAVEN_ARTIFACT="base"
readonly BAZEL_ARTIFACT="base"
readonly JAR_FILE=${BAZEL_ROOT}/bazel-bin/java/jsinterop/base/libbase.jar
readonly SRC_JAR=${BAZEL_ROOT}/bazel-bin/java/jsinterop/base/libbase-src.jar
readonly JAVADOC_JAR=${BAZEL_ROOT}/bazel-bin/java/jsinterop/base/base-javadoc.jar
readonly POM_TEMPLATE=${BAZEL_ROOT}/maven/pom-base.xml


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

parse_arguments() {
  deploy_flag=""
  git_tag=true
  lib_version=""

  while [[ $# -gt 0 ]]; do
    case $1 in
      --version )
        shift
        lib_version=$1
        ;;
      --no-deploy )
        deploy_flag="--no-deploy"
        ;;
      --no-git-tag )
        git_tag=false
        ;;
      --help )
        usage
        exit 0
        ;;
      * )
        common::error "unexpected option $1"
        ;;
    esac
    shift
  done
}

check_prerequisites() {
  common::check_bazel
  common::check_maven
  common::check_version_set
}

build() {
  common::bazel_build //java/jsinterop/base:libbase.jar
  common::bazel_build //java/jsinterop/base:libbase-src.jar
  common::bazel_build //java/jsinterop/base:base-javadoc.jar
}


main() {
  parse_arguments "$@"
  check_prerequisites
  build

  common::deploy_to_sonatype ${deploy_flag} \
      --artifact ${MAVEN_ARTIFACT} \
      --jar-file ${JAR_FILE} \
      --src-jar ${SRC_JAR} \
      --javadoc-jar ${JAVADOC_JAR} \
      --pom-template ${POM_TEMPLATE} \
      --lib-version ${lib_version} \
      --group-id ${GROUP_ID}

  if [[ ${git_tag} == true ]]; then
    common::create_and_push_git_tag ${lib_version}
  fi
}

# Set the trap to cleanup temporary files on EXIT
trap common::cleanup_temp_files EXIT

main "$@"
