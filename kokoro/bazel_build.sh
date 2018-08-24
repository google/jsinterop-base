#!/bin/bash
set -e

# the repo is cloned under git/jsinterop-base
cd git/jsinterop-base

bazel build ...
