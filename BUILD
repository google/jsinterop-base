# Description:
#   jsinterop (http://go/jsinterop) is a mechanism providing interoperability
#   with JavaScript to GWT or J2CL applications.
#
#

package(default_visibility = [
    "//third_party/java/jsinterop:__pkg__",
    "//third_party/java/jsinterop:jsinterop_generator_beta",
    "//:__subpackages__",
])

# Google owns the copyright
licenses(["unencumbered"])

exports_files(["LICENSE"])

load("//:generator_js.bzl", "generator_js")

# An implicit dependency of all "jsinterop_generator" skylark rules.
# Expose the javascript file of the JsInterop Generator
generator_js(
    name = "JsInteropGenerator_this_should_only_be_used_through_jsinterop_generator_skylark_rule",
)
