# Description:
#  JsInterop helper classes

package(default_visibility = [
    "//:__subpackages__",
    "//third_party/java/elemental2:__subpackages__",
])

# Googleowns the copyright
licenses(["unencumbered"])

load("//third_party/java/j2cl:j2cl_library.bzl", "j2cl_library")

java_library(
    name = "base",
    srcs = glob(["*.java"]),
)

j2cl_library(
    name = "base-j2cl",
    srcs = glob(["*.java"]),
    native_srcs = glob(["*.native.js"]),
)
