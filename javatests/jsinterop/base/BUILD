# Description:
#   JsInterop base test cases

# Apache2
licenses(["notice"])

java_test(
    name = "gwt2-tests",
    srcs = glob(["*.java"]),
    test_class = "jsinterop.base.AllTests",
    deps = [
        "//java/jsinterop/base",
        "//java/jsinterop/base:libbase-src.jar",

        "//third_party:gwt-jsinterop-annotations",
        "//third_party:com_google_gwt_gwt_dev",
        "//third_party:com_google_gwt_gwt_user",
        # generate_workspace misses these deps for gwt-dev/gwt-user
        "//third_party:org_w3c_css_sac",
        "//third_party:xml-apis",

        "//third_party:com_google_truth_truth_gwt",

        "//third_party:com_google_guava_guava",
    ],
    resources = glob(["**/*.java"]) + ["TestModule.gwt.xml"],
    jvm_flags = ["-Dgwt.args='-generateJsInteropExports'"],
)
