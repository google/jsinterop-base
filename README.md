# JsInterop Base   &middot; [![Build Status](https://secure.travis-ci.org/google/jsinterop-base.png?branch=master)](http://travis-ci.org/google/jsinterop-base)

jsInterop-base contains a set of utilities that cannot be expressed with
Jsinterop itself and allows GWT and J2CL projects to write certain JavaScript
expressions with pure Java.

Build with Bazel
---------------------
If you want to build the last version on your own, follow the instructions
below:

- Install [Bazel](https://bazel.build/versions/master/docs/install.html).
- clone this repository with git: `git clone https://github.com/google/jsinterop-base.git`
- Inside the repository, have bazel build the jar files:

    $ bazel build //java/jsinterop/base:base

 - For building the source jar file:

    $ bazel build //java/jsinterop/base:libbase-src.jar

The jars are available in your `bazel-bin/java/jsinterop/base` directory.

Maven dependency
------------------
If your project use [Maven](https://maven.apache.org), add maven dependency in
your pom.xml:

    <dependency>
      <groupId>com.google.jsinterop</groupId>
      <artifactId>base</artifactId>
      <version>1.0.0-RC1</version>
    </dependency>


Download the jar file
----------------------
You can also download manually [the jar file](https://oss.sonatype.org/content/repositories/releases/com/google/jsinterop/base/1.0.0-RC1/base-1.0.0-RC1.jar).

GWT
---
If you use jsinterop-base with [GWT](http://www.gwtproject.org/), you need to
inherit the following gwt module in your gwt.xml file:

    <inherits name="jsinterop.base.Base" />

Contributing
------------
Please refer to [the contributing document](CONTRIBUTING.md).

Licensing
---------
Please refer to [the license file](LICENSE).

Disclaimer
----------
This is not an official Google product.

