workspace(name = "com_google_jsinterop_base")
load("@bazel_tools//tools/build_defs/repo:maven_rules.bzl", "maven_jar")

load("//:generate_workspace.bzl", "generated_maven_jars")
generated_maven_jars()

maven_jar(
    name = "jsinterop_annotations",
    artifact = "com.google.jsinterop:jsinterop-annotations:1.0.2",
)
maven_jar(
    name = "jsinterop_annotations_src",
    artifact = "com.google.jsinterop:jsinterop-annotations:1.0.2:jar:sources",
)

maven_jar(
    name = "com_google_truth_truth_gwt",
    artifact = "com.google.truth:truth:0.40:jar:gwt"
)

maven_jar(
    name = "org_checker_checker_compat_qual",
    artifact = "org.checkerframework:checker-compat-qual:2.5.2",
)

maven_jar(
    name = "org_w3c_css_sac",
    artifact = "org.w3c.css:sac:1.3"
)

maven_jar(
    name = "xml_apis",
    artifact = "xml-apis:xml-apis:1.4.01",
)

http_archive(
  name="org_gwtproject_gwt",
  url="https://gwt.googlesource.com/gwt/+archive/master.tar.gz",
)
