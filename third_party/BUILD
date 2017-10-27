# Description:
#   Thirdparty dependencies indirection for bazel for jsinterop base.
package(default_visibility = ["//:__subpackages__"])

# Apache2
licenses(["notice"])

java_library(
    name = "gwt-jsinterop-annotations",
    exports = ["@jsinterop_annotations//jar"],
)

java_library(
    name = "gwt-dev",
    exports = ["@gwt_dev//jar"],
)

java_library(
    name = "gwt-javaemul-internal-annotations",
    exports = ["@org_gwtproject_gwt//user:gwt-javaemul-internal-annotations"],
)