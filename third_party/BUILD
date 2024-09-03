# Description:
#   Thirdparty dependencies indirection for bazel.

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_import")

package(
    default_visibility = ["//:__subpackages__"],
    licenses = ["notice"],
)

alias(
    name = "jspecify_annotations",
    actual = "@org_jspecify",
)

j2cl_import(
    name = "jspecify_annotations-j2cl",
    jar = "@org_jspecify//jar",
)
