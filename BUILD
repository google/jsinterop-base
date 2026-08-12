# Description:
#  Base classes and utilities that provide access to JavaScript language
# constructs that are not available in pure Java.

load("@rules_license//rules:license.bzl", "license")

package(
    default_applicable_licenses = [":license"],
    default_visibility = ["//visibility:public"],
    licenses = ["notice"],
)

license(
    name = "license",
    package_name = "jsinterop_base",
)

exports_files(["LICENSE"])

alias(
    name = "jsinterop-base",
    actual = "//java/jsinterop/base",
)

alias(
    name = "jsinterop-base-j2cl",
    actual = "//java/jsinterop/base:base-j2cl",
)
