# Description:
#  JsInterop base classes

load("@google_bazel_common//tools/javadoc:javadoc.bzl", "javadoc_library")
load("@rules_java//java:defs.bzl", "java_library")
load("@j2cl//build_defs:rules.bzl", "j2cl_library", "j2wasm_library")

package(
    default_applicable_licenses = ["//:license"],
    default_visibility = [
        "//:__subpackages__",
    ],
    licenses = ["notice"],
)

java_library(
    name = "base",
    srcs = glob(["**/*.java"]),
    # Keep compatibility with Java 11 for open source GWT.
    javacopts = ["-source 11 -target 11"],
    resources = ["Base.gwt.xml"],
    deps = [
        "//third_party:checker_framework_annotations",
        "//third_party:error_prone_annotations",
        "//third_party:jspecify_annotations",
        "@j2cl//:jsinterop-annotations",
        "@j2cl//jre/java:javaemul_internal_annotations",
    ],
)

javadoc_library(
    name = "base-javadoc",
    srcs = glob(["**/*.java"]),
    tags = [
        "manual",
        "notap",
    ],
    deps = [
        "//third_party:checker_framework_annotations",
        "//third_party:error_prone_annotations",
        "//third_party:jspecify_annotations",
        "@j2cl//:jsinterop-annotations",
        "@j2cl//jre/java:javaemul_internal_annotations",
    ],
)

j2wasm_library(
    name = "base-j2wasm",
    srcs = [
        "InternalJsUtil.impl.java.js",
        ":processed_j2wasm_srcs",
    ],
    deps = [
        "//third_party:checker_framework_annotations-j2wasm",
        "//third_party:error_prone_annotations-j2wasm",
        "//third_party:jspecify_annotations-j2wasm",
        "@j2cl//:jsinterop-annotations-j2wasm",
        "@j2cl//jre/java:javaemul_internal_annotations-j2wasm",
    ],
)

j2cl_library(
    name = "base-j2cl",
    srcs = [":processed_j2cl_srcs"] + glob(["*.js"]),
    # Tested internally in google3
    experimental_enable_jspecify_support_do_not_enable_without_jspecify_static_checking_or_you_might_cause_an_outage = True,
    deps = [
        "//third_party:checker_framework_annotations-j2cl",
        "//third_party:error_prone_annotations-j2cl",
        "//third_party:jspecify_annotations-j2cl",
        "@j2cl//:jsinterop-annotations-j2cl",
        "@j2cl//jre/java:javaemul_internal_annotations-j2cl",
    ],
)

# Uncomments code that is commented with the given markers, e.g. '// J2CL_ONLY '. The markers are
# replaced with whitespace to ensure all character offset position references remain accurate.
_PROCESS_SRCS_CMD = """
# Exit on any command failure, if a variable is unset, or a pipeline failure (respectively).
set -euo pipefail

# Build a sed expression for each marker that replaces '// <marker> ' with as many spaces.
declare -a sed_args
for marker in %s; do
  prefix="// $${marker} "
  sed_args+=(-e "s|$${prefix}|$${prefix//?/ }|g")
done

tmpdir=$$(mktemp -d)
# Ensure we cleanup the tmpdir on exit
trap "rm -rf $${tmpdir}" EXIT

# Mutate the source files in a tmp file. We'll build up a mapping of <original_file>=<tmp file> that
# can be passed into zipper so that we maintain the original file paths within the zip.
declare -a file_mapping
for src in $(SRCS); do
  tmpfile=$$(mktemp "$${tmpdir}/tmp.XXXXXXXXX")
  file_mapping+=("$${src}=$${tmpfile}")
  sed "$${sed_args[@]}" $${src} > $${tmpfile}
done

# Zip everything up using the mapping we built.
$(location @bazel_tools//tools/zip:zipper) c $@ "$${file_mapping[@]}"
"""

# Uncomments code that is commented with '// J2CL_ONLY' (used by both J2CL and J2Wasm).
genrule(
    name = "processed_j2cl_srcs",
    srcs = glob(["**/*.java"]),
    outs = ["base-j2cl.srcjar"],
    cmd = _PROCESS_SRCS_CMD % "J2CL_ONLY",
    tools = ["@bazel_tools//tools/zip:zipper"],
)

# Like processed_j2cl_srcs but also uncomments code that is commented with '// J2WASM_ONLY'.
genrule(
    name = "processed_j2wasm_srcs",
    srcs = glob(["**/*.java"]),
    outs = ["base-j2wasm.srcjar"],
    cmd = _PROCESS_SRCS_CMD % "J2CL_ONLY J2WASM_ONLY",
    tools = ["@bazel_tools//tools/zip:zipper"],
)
