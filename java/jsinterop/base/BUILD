# Description:
#  JsInterop base classes

package(default_visibility = ["//visibility:public"])

# Apache2
licenses(["notice"])

java_library(
    name = "base",
    srcs = glob(["*.java"]),
    resources = ["Base.gwt.xml"],
    deps = [
        "//third_party:gwt-dev",
        "//third_party:gwt-javaemul-internal-annotations",
        "//third_party:gwt-jsinterop-annotations",
    ],
)
