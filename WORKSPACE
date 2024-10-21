workspace(name = "com_google_jsinterop_base")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")

# Load j2cl repository

http_archive(
    name = "com_google_j2cl",
    strip_prefix = "j2cl-20241021",
    url = "https://github.com/google/j2cl/archive/v20241021.zip",
)

load("@com_google_j2cl//build_defs:repository.bzl", "load_j2cl_repo_deps")

load_j2cl_repo_deps()

load("@com_google_j2cl//build_defs:workspace.bzl", "setup_j2cl_workspace")

setup_j2cl_workspace()
