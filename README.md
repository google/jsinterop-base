# JsInterop Base &middot; ![Latest Release](https://img.shields.io/github/v/release/google/jsinterop-base) &middot; [![Build Status](https://github.com/google/jsinterop-base/actions/workflows/ci.yaml/badge.svg)](https://github.com/google/jsinterop-base/actions/workflows/ci.yaml)

jsInterop-base contains a set of utilities that cannot be expressed with
Jsinterop itself and allows GWT and J2CL projects to write certain JavaScript
expressions with pure Java.

Bazel dependency
----------------

Using Bazel 8 or later, add to your \`MODULE.bazel\` file:

```starlark
bazel_dep(name = "jsinterop_base", version = "<RELEASE_VERSION>")
```

Replace `RELEASE_VERSION` with an actual
[release version](https://github.com/google/jsinterop-base/releases):

Then add `@jsinterop_base//:jsinterop-base-j2cl` to your `j2cl_library` deps.

Maven dependency
------------------
If your project uses [Maven](https://maven.apache.org), add the following maven
dependency in your `pom.xml`. Replace `RELEASE_VERSION` with an actual
[release version](https://github.com/google/jsinterop-base/releases):

    <dependency>
      <groupId>com.google.jsinterop</groupId>
      <artifactId>base</artifactId>
      <version>RELEASE_VERSION</version>
    </dependency>

GWT
---
If you use jsinterop-base with [GWT](http://www.gwtproject.org/), you need to
inherit the following gwt module in your gwt.xml file:

    <inherits name="jsinterop.base.Base" />

Build GWT compatible maven jar files
------------------------------------
If you want to build the last version on your own, follow the instructions
below:

- Install [Bazelisk](https://github.com/bazelbuild/bazelisk):

```shell
    $ npm install -g @bazel/bazelisk
    $ alias bazel=bazelisk
```
- Clone this git repository:
  ```shell
  $ git clone https://github.com/google/jsinterop-base.git
  ```
- Run the release script:
  ```shell
      $ cd jsinterop-base
      $ ./maven/release_jsinterop_base.sh --version local --no-deploy
  ```

 The script will output the directory containing the generated jar files that
 can be used with maven.

Contributing
------------
Please refer to [the contributing document](CONTRIBUTING.md).

Licensing
---------
Please refer to [the license file](LICENSE).

Disclaimer
----------
This is not an official Google product.
