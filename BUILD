# Description:
#  Base classes and utilities that provide access to JavaScript language
# constructs that are not available in pure Java.

package(default_visibility = ["//visibility:public"])

# Apache2
licenses(["notice"])

exports_files(["LICENSE"])

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library")

sh_binary(
    name = "deploy",
    srcs = ["deploy.sh"],
)

alias(
    name = "jsinterop-base",
    actual = "//java/jsinterop/base",
)

alias(
    name = "jsinterop-base-j2cl",
    actual = "//java/jsinterop/base:base-j2cl",
)
