workspace(name = "com_google_jsinterop_base")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Load j2cl repository

http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-20241115",
    url = "https://github.com/google/j2cl/archive/v20241115.zip",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")

load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:workspace.bzl", "setup_j2cl_workspace")

setup_j2cl_workspace()


# Dependencies needed for the testing of the repository.

_MAVEN_CENTRAL_URLS = ["https://repo1.maven.org/maven2/"]

load("@com_google_j2cl//build_defs:rules.bzl", "j2cl_maven_import_external")

j2cl_maven_import_external(
    name = "org_checkerframework_checker_qual-j2cl",
    annotation_only = True,
    artifact = "org.checkerframework:checker-qual:2.5.3",
    artifact_sha256= "7be622bd25208ccfbb9b634af8bd37aef54368403a1fdce84d908078330a189d",
    server_urls = _MAVEN_CENTRAL_URLS,
)

j2cl_maven_import_external(
    name = "com_google_errorprone_error_prone_annotations-j2cl",
    annotation_only = True,
    artifact = "com.google.errorprone:error_prone_annotations:2.23.0",
    artifact_sha256= "ec6f39f068b6ff9ac323c68e28b9299f8c0a80ca512dccb1d4a70f40ac3ec054",
    server_urls = _MAVEN_CENTRAL_URLS,
)

j2cl_maven_import_external(
    name = "com_google_code_findbugs_jsr305-j2cl",
    annotation_only = True,
    artifact = "com.google.code.findbugs:jsr305:3.0.2",
    artifact_sha256 = "766ad2a0783f2687962c8ad74ceecc38a28b9f72a2d085ee438b7813e928d0c7",
    server_urls = _MAVEN_CENTRAL_URLS,
)

j2cl_maven_import_external(
    name = "com_google_j2objc_annotations-j2cl",
    annotation_only = True,
    artifact = "com.google.j2objc:j2objc-annotations:jar:1.3",
    artifact_sha256= "21af30c92267bd6122c0e0b4d20cccb6641a37eaf956c6540ec471d584e64a7b",
    server_urls = _MAVEN_CENTRAL_URLS,
)

j2cl_maven_import_external(
    name = "com_google_guava-j2cl",
    artifact = "com.google.guava:guava-gwt:32.1.1-jre",
    artifact_sha256= "a2a687fa178a141d19dadc2dc5baa56c856c2fe8772ef3929c37c24e588e3a28",
    server_urls = _MAVEN_CENTRAL_URLS,
    deps = [
        "@com_google_code_findbugs_jsr305-j2cl",
        "@com_google_errorprone_error_prone_annotations-j2cl",
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
        "@com_google_j2objc_annotations-j2cl",
        "@org_checkerframework_checker_qual-j2cl",
    ],
)

j2cl_maven_import_external(
    name = "org_jspecify-j2cl",
    annotation_only = True,
    artifact = "org.jspecify:jspecify:0.3.0",
    artifact_sha256 = "e1c7e1832b6095fcfcbe57485700c7330d53d4e57e2c5bbf9c71819b02e978be",
    server_urls = _MAVEN_CENTRAL_URLS,
)

j2cl_maven_import_external(
    name = "com_google_truth-j2cl",
    testonly = 1,
    additional_rule_attrs = {
        "javacopts": "[\"-Xep:NullArgumentForNonNullParameter:OFF\"]",
        # Tested in google3.
        "experimental_enable_jspecify_support_do_not_enable_without_jspecify_static_checking_or_you_might_cause_an_outage": "1",
    },
    artifact = "com.google.truth:truth:jar:gwt:1.4.4",
    artifact_sha256 = "3f60707e2b31ce73e5b82c65ea9c5fb5f135e875b9de9eb9f0b8f8937974a5e6",
    server_urls = _MAVEN_CENTRAL_URLS,
    deps = [
        "@com_google_errorprone_error_prone_annotations-j2cl",
        "@com_google_guava-j2cl",
        "@com_google_j2cl//:jsinterop-annotations-j2cl",
        "@org_jspecify-j2cl",
    ],
)
