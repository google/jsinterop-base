# Description:
#   Tests jsinterop utilities

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library", "j2cl_test")

package(
    default_applicable_licenses = ["//:license"],
    licenses = ["notice"],
)

j2cl_library(
    name = "testlib",
    testonly = 1,
    srcs = glob([
        "*.java",
        "super/*.java",
    ]),
    deps = [
        "//java/jsinterop/base:base-j2cl",
        "//third_party:truth-j2cl",
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
        "@com_google_j2cl//:junit",
    ],
)

j2cl_test(
    name = "CheckedModeTest",
    compile = 1,
    extra_defs = ["--define=jsinterop.checks=ENABLED"],
    runtime_deps = [":testlib"],
)

j2cl_test(
    name = "AllJ2clTests",
    compile = 1,
    test_class = "jsinterop.base.AllTests",
    runtime_deps = [":testlib"],
)

j2cl_test(
    name = "AllJ2clTests_uncompiled",
    test_class = "jsinterop.base.AllTests",
    runtime_deps = [":testlib"],
)

j2cl_test(
    name = "AllJ2clOptimizationTests",
    compile = 1,
    extra_defs = ["--define=jre.checkedMode=DISABLED"],
    test_class = "jsinterop.base.AllOptimizationTests",
    runtime_deps = [":testlib"],
)
