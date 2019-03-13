# Description:
#  Base classes and utilities that provide access to JavaScript language
# constructs that are not available in pure Java.

package(default_visibility = ["//visibility:public"])

# Apache2
licenses(["notice"])

exports_files(["LICENSE"])

sh_binary(
    name = "deploy",
    srcs = ["deploy.sh"],
    visibility = ["//visibility:private"],
)

alias(
    name = "jsinterop-base",
    actual = "//java/jsinterop/base",
)

alias(
    name = "jsinterop-base-j2cl",
    actual = "//java/jsinterop/base:base-j2cl",
)
