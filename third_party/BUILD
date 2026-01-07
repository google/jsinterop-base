# Description:
#   Thirdparty dependencies indirection for bazel.
load("@j2cl//build_defs:rules.bzl", "j2cl_import")

package(
    default_visibility = ["//:__subpackages__"],
    licenses = ["notice"],
)

alias(
    name = "error_prone_annotations",
    actual = "@google_bazel_common//third_party/java/error_prone:annotations",
)

j2cl_import(
    name = "error_prone_annotations-j2cl",
    jar = "error_prone_annotations",
)

alias(
    name = "jspecify_annotations",
    actual = "@maven//:org_jspecify_jspecify",
)

j2cl_import(
    name = "jspecify_annotations-j2cl",
    jar = ":jspecify_annotations",
)

alias(
    name = "truth-j2cl",
    actual = "@com_google_truth-j2cl",
)
