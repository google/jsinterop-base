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

# This script provides common function and variables used by other scripts to
# release specific projects.
readonly BAZEL_ROOT=$(pwd)

j2cl_utils::error() {
  echo "Error: $1"
  exit 1
}

j2cl_utils::info() {
  echo "Info: $1"
}


#######################################
# Check if Bazel is installed and the script is run from the root of the Bazel
# repository.
# Globals:
#   BAZEL
#######################################
j2cl_utils::check_bazel() {
  if [ ! -f "MODULE.bazel" ]; then
    error "This script must be run from the root of the Bazel repository (where MODULE.bazel exists)."
  fi

  # Check for Bazel or Bazelisk
  if command -v bazelisk &> /dev/null; then
    BAZEL="bazelisk"
  elif command -v bazel &> /dev/null; then
    BAZEL="bazel"
  else
    error "Neither Bazel nor Bazelisk is installed or in your PATH."
  fi
}

#######################################
# Check if Maven is installed.
#######################################
j2cl_utils::check_maven() {
  if ! command -v mvn &> /dev/null; then
    error "Maven is not installed. Please install it."
  fi

  # TODO(dramaix): Do we still need this?
  if ! command -v gpg2 &> /dev/null; then
    error "gpg2 is not installed. Please install it."
  fi
}

bazel_build() {
  info "Building Bazel target: ${1}"
  "${BAZEL}" build "${1}"
}


