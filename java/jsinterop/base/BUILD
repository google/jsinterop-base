# Description:
#  JsInterop base classes

load("@bazel_common_javadoc//:javadoc.bzl", "javadoc_library")
load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_library")

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
    resources = ["Base.gwt.xml"],
    deps = [
        "//third_party:jspecify_annotations",
        "@com_google_j2cl//:jsinterop-annotations",
        "@com_google_j2cl//jre/java:javaemul_internal_annotations",
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
        "//third_party:jspecify_annotations",
        "@com_google_j2cl//:jsinterop-annotations",
        "@com_google_j2cl//jre/java:javaemul_internal_annotations",
    ],
)

j2cl_library(
    name = "base-j2cl",
    srcs = [":processed_j2cl_srcs"] + glob(["*.js"]),
    # Tested internally in google3
    experimental_enable_jspecify_support_do_not_enable_without_jspecify_static_checking_or_you_might_cause_an_outage = True,
    deps = [
        "//third_party:jspecify_annotations-j2cl",
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
        "@com_google_j2cl//jre/java:javaemul_internal_annotations-j2cl",
    ],
)

# Uncomments code that is commented with '// J2CL_ONLY'
genrule(
    name = "processed_j2cl_srcs",
    srcs = glob(["**/*.java"]),
    outs = ["base-j2cl.srcjar"],
    cmd = """
# Exit on any command failure, if a variable is unset, or a pipeline failure (respectively).
set -euo pipefail

tmpdir=$$(mktemp -d)
# Ensure we cleanup the tmpdir on exit
trap "rm -rf $${tmpdir}" EXIT

# Mutate the source files in a tmp file. We'll build up a mapping of <original_file>=<tmp file> that
# can be passed into zipper so that we maintain the original file paths within the zip.
declare -a file_mapping
for src in $(SRCS); do
  tmpfile=$$(mktemp "$${tmpdir}/tmp.XXXXXXXXX")
  file_mapping+=("$${src}=$${tmpfile}")
  # Replace the J2CL_ONLY comment with whitespace to ensure all character offset position references
  # remain accurate.
  sed 's|// J2CL_ONLY |             |g' $${src} > $${tmpfile}
done

# Zip everything up using the mapping we built.
$(location @bazel_tools//tools/zip:zipper) c $@ "$${file_mapping[@]}"
""",
    tools = ["@bazel_tools//tools/zip:zipper"],
)
