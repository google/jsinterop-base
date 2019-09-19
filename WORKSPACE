workspace(name = "com_google_jsinterop_base")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Load j2cl repository

http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-20190918",
    url = "https://github.com/google/j2cl/archive/v20190918.zip",
    sha256 = "83c5ed81aa5036535f84d85ab2fd1faa6ef724f5f272ac489495568afac1c562",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")

load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:rules.bzl", "setup_j2cl_workspace")

setup_j2cl_workspace()

maven_jar(
    name = "org_gwtproject_gwt_dev",
    artifact = "com.google.gwt:gwt-dev:2.8.1",
)
