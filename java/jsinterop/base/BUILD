# Description:
#  JsInterop base classes

package(default_visibility = ["//visibility:public"])

# Apache2
licenses(["notice"])

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library")

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

j2cl_library(
    name = "base-j2cl",
    srcs = [":processed_j2cl_srcs"],
    _js_srcs = ["jsinterop.js"],
    native_srcs = glob(["*.native.js"]),
    deps = [
        "//third_party:gwt-javaemul-internal-annotations-j2cl",
        "//third_party:gwt-jsinterop-annotations-j2cl",
    ],
)

# Uncomments code that is commented with '//J2CL_ONLY'
genrule(
    name = "processed_j2cl_srcs",
    srcs = glob(["**/*.java"]),
    outs = ["base-j2cl.srcjar"],
    cmd = "\n".join([
        "sed -i.bak 's/\/\/J2CL_ONLY\ //g' $(SRCS)",
        "$(location //third_party:zip) c $@ $(SRCS)",
    ]),
    tools = ["//third_party:zip"],
)

