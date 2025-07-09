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

readonly MAVEN_ARTIFACT="base"
readonly BAZEL_ARTIFACT="base"
readonly BAZEL_PATH="java/jsinterop/base"


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
    echo "    --sonatype-auto-release"
    echo "        Release the artifact on sonatype automatically after upload."
    echo ""
}

parse_arguments() {
  deploy_to_sonatype=true
  git_tag=true
  lib_version=""
  sonatype_auto_release=false

  while [[ $# -gt 0 ]]; do
    case $1 in
      --version )
        shift
        lib_version=$1
        ;;
      --no-deploy )
        deploy_to_sonatype=false
        ;;
      --no-git-tag )
        git_tag=false
        ;;
      --sonatype-auto-release)
        sonatype_auto_release=true
        shift
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

main() {
  parse_arguments "$@"

  common::check_version_set
  common::check_bazel_prerequisites
  common::check_maven_prerequisites

  common::build
  common::deploy_to_sonatype

  if [[ ${git_tag} == true ]]; then
    common::create_and_push_git_tag ${lib_version}
  fi
}

# Set the trap to cleanup temporary files on EXIT
trap common::cleanup_temp_files EXIT

main "$@"
