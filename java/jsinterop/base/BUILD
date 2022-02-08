# Description:
#  JsInterop base classes

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library")

package(
    default_visibility = [
        "//:__subpackages__",
    ],
    licenses = ["notice"],
)

java_library(
    name = "base",
    srcs = glob(["**/*.java"]),
    resources = ["Base.gwt.xml"],
    deps = [
        "@com_google_j2cl//:jsinterop-annotations",
        "@com_google_j2cl//jre/java:javaemul_internal_annotations",
    ],
)

j2cl_library(
    name = "base-j2cl",
    srcs = [":processed_j2cl_srcs"] + glob(["*.js"]),
    deps = [
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
        "@com_google_j2cl//jre/java:javaemul_internal_annotations-j2cl",
    ],
)

# Uncomments code that is commented with '// J2CL_ONLY'
genrule(
    name = "processed_j2cl_srcs",
    srcs = glob(["**/*.java"]),
    outs = ["base-j2cl.srcjar"],
    cmd = "\n".join([
        "perl -i.bak -pe 's|// J2CL_ONLY ||g' $(SRCS)",
        "$(location @bazel_tools//tools/zip:zipper) c $@ $(SRCS)",
    ]),
    tools = ["@bazel_tools//tools/zip:zipper"],
)
