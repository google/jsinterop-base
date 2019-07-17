# Description:
#   Tests jsinterop utilities

package(
    # Apache2
    licenses = ["notice"],
)

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library", "j2cl_test")

j2cl_library(
    name = "testlib",
    testonly = 1,
    srcs = glob([
        "*.java",
        "super/*.java",
    ]),
    deps = [
        "//java/com/google/common/annotations:annotations-j2cl",
        "//java/jsinterop/base:base-j2cl",
        "//third_party/java/gwt:gwt-jsinterop-annotations-j2cl",
        "//third_party/java/junit:junit-j2cl",
        "//third_party/java/truth:truth-j2cl",
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
    extra_defs = [
        "--define=jre.checks.type=DISABLED",  #TODO(b/33704796): Remove after b/33681746
        "--define=jre.checkedMode=DISABLED",
        # JsCompiler heuristics are fragile for verifying optimizability of this code. Right now
        # we are just hoping our code is *too small* and that's why we are hitting issues.
        # Ideally we should use the defaults but if the heuristic turns out to be bad for users
        # they should talk to JsCompiler team and maybe we could remove this flag again.
        "--use_size_heuristic_to_stop_optimization_loop_experimental=false",
    ],
    test_class = "jsinterop.base.AllOptimizationTests",
    runtime_deps = [":testlib"],
)
