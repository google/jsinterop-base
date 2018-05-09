#!/bin/bash -i
# The script generates the open source artifacts for jsinterop.base and
# upload them to sonatype.

set -e

lib_version=$1
workspace=$(pwd | sed "s,^\(.*\)google3.*$,\1google3,")

if [[ "$workspace" != *google3 ]]; then
  echo "The script should be run from google3 workspace"
  exit 1;
fi

release_to_sonatype=${workspace}/third_party/java_src/jsinterop/opensource/release_to_sonatype.sh
license_header=${workspace}/third_party/java_src/jsinterop/opensource/license.txt
group_id="com.google.jsinterop"
maven_artifact="base"

cd ${workspace}

# ask blaze to explicitly build both jar files
blaze build //third_party/java_src/jsinterop/java/jsinterop/base:libbase.jar
blaze build //third_party/java_src/jsinterop/java/jsinterop/base:libbase-src.jar

jar_file=${workspace}/blaze-bin/third_party/java_src/jsinterop/java/jsinterop/base/libbase.jar
src_jar=${workspace}/blaze-bin/third_party/java_src/jsinterop/java/jsinterop/base/libbase-src.jar
pom_template=${workspace}/third_party/java_src/jsinterop/opensource/pom-base.xml

${release_to_sonatype} ${maven_artifact} ${jar_file} ${src_jar} ${license_header} ${pom_template} ${lib_version} ${group_id}
