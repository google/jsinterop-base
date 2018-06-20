# Description:
#   Thirdparty dependencies indirection for bazel for jsinterop base.
package(default_visibility = ["//:__subpackages__"])

# Apache2
licenses(["notice"])

java_library(
    name = "gwt-jsinterop-annotations",
    exports = [
        "@jsinterop_annotations//jar",
        "@jsinterop_annotations_src//jar",
        ],
)

load("//:generate_workspace.bzl", "generated_java_libraries")
generated_java_libraries()

java_library(
    name = "org_w3c_css_sac",
    exports = ["@org_w3c_css_sac//jar"],
)

java_library(
    name = "xml-apis",
    exports = ["@xml_apis//jar"],
)

java_library(
    name = "com_google_truth_truth_gwt",
    testonly = 1,
    exports = [
        "@com_google_truth_truth_gwt//jar",
        "@com_google_truth_truth//jar",
        ],
    runtime_deps = [
        ":com_google_guava_guava_gwt",
        ":com_google_errorprone_error_prone_annotations",
        ":org-checker-checker-compat-qual"
    ]
)

java_library(
    name = "org-checker-checker-compat-qual",
    testonly = 1,
    exports = ["@org_checker_checker_compat_qual//jar"],
)

java_library(
    name = "gwt-javaemul-internal-annotations",
    exports = ["@org_gwtproject_gwt//user:gwt-javaemul-internal-annotations"],
)