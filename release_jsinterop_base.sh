#!/bin/bash -i
# The script generates the open source artifacts for jsinterop.base and
# upload them to sonatype.

set -e

lib_version=$1

if [ -z ${lib_version} ]; then
  echo "Please specify the lib version."
  exit 1;
fi

bazel_root="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

deploy_target='//:deploy'
license_header="--no-license"
group_id="com.google.jsinterop"
maven_artifact="base"

cd ${bazel_root}

# ask bazel to explicitly build both jar files
bazel build //java/jsinterop/base:libbase.jar
bazel build //java/jsinterop/base:libbase-src.jar

jar_file=${bazel_root}/bazel-bin/java/jsinterop/base/libbase.jar
src_jar=${bazel_root}/bazel-bin/java/jsinterop/base/libbase-src.jar
pom_template=${bazel_root}/maven/pom-base.xml

# we cannot run the script directly from Bazel because it doesn't allow interactive script
runcmd="$(mktemp /tmp/bazel-run.XXXXXX)"
bazel run --script_path="$runcmd" ${deploy_target} -- ${maven_artifact} \
    ${jar_file} \
    ${src_jar} \
    ${license_header} \
    ${pom_template} \
    ${lib_version} \
    ${group_id}

"$runcmd"

rm "$runcmd"
