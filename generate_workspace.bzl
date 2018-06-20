# The following dependencies were calculated from:
#
# generate_workspace -r https://repo1.maven.org/maven2/ -a com.google.gwt:gwt-user:2.8.2 -a com.google.gwt:gwt-dev:2.8.1 -a com.google.truth:truth:jar:gwt:0.40 -a com.google.guava:guava-gwt:23.6.1-jre


def generated_maven_jars():
  # com.google.guava:guava:bundle:23.4-android
  native.maven_jar(
      name = "com_google_code_findbugs_jsr305",
      artifact = "com.google.code.findbugs:jsr305:2.0.2",
      sha1 = "516c03b21d50a644d538de0f0369c620989cd8f0",
  )


  # org.eclipse.jetty:jetty-annotations:jar:9.2.13.v20150730
  native.maven_jar(
      name = "javax_annotation_javax_annotation_api",
      artifact = "javax.annotation:javax.annotation-api:1.2",
      sha1 = "479c1e06db31c432330183f5cae684163f186146",
  )


  # org.eclipse.jetty:apache-jsp:jar:9.2.13.v20150730
  # org.mortbay.jasper:apache-jsp:jar:8.0.9.M3 got requested version
  native.maven_jar(
      name = "org_eclipse_jetty_toolchain_jetty_schemas",
      artifact = "org.eclipse.jetty.toolchain:jetty-schemas:3.1.M0",
      sha1 = "6179bafb6ed2eb029862356df6713078c7874f85",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_ow2_asm_asm_util",
      artifact = "org.ow2.asm:asm-util:5.0.3",
      sha1 = "1512e5571325854b05fb1efce1db75fcced54389",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19 got requested version
  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "commons_io_commons_io",
      artifact = "commons-io:commons-io:2.4",
      sha1 = "b1b6ea3b7e4aa4f492509a4952029cd8e48019ad",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "net_sourceforge_nekohtml_nekohtml",
      artifact = "net.sourceforge.nekohtml:nekohtml:1.9.22",
      sha1 = "4f54af68ecb345f2453fb6884672ad08414154e3",
  )


  # org.eclipse.jetty:apache-jsp:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:jetty-security:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_server",
      artifact = "org.eclipse.jetty:jetty-server:9.2.13.v20150730",
      sha1 = "5be7d1da0a7abffd142de3091d160717c120b6ab",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19 wanted version 1.10
  # org.apache.httpcomponents:httpclient:jar:4.5.1
  native.maven_jar(
      name = "commons_codec_commons_codec",
      artifact = "commons-codec:commons-codec:1.9",
      sha1 = "9ce04e34240f674bc72680f8b843b1457383161a",
  )


  # org.ow2.asm:asm-tree:jar:5.0.3 got requested version
  # org.eclipse.jetty:jetty-annotations:jar:9.2.13.v20150730 wanted version 5.0.1
  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_ow2_asm_asm",
      artifact = "org.ow2.asm:asm:5.0.3",
      sha1 = "dcc2193db20e19e1feca8b1240dbbc4e190824fa",
  )


  # org.mortbay.jasper:apache-jsp:jar:8.0.9.M3
  native.maven_jar(
      name = "org_mortbay_jasper_apache_el",
      artifact = "org.mortbay.jasper:apache-el:8.0.9.M3",
      sha1 = "98daa71c32b7d27dd9463b36de9cebab3f2e5e2e",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "ant_ant",
      artifact = "ant:ant:1.6.5",
      sha1 = "7d18faf23df1a5c3a43613952e0e8a182664564b",
  )


  # xerces:xercesImpl:jar:2.11.0 wanted version 1.4.01
  # xalan:serializer:jar:2.7.2
  native.maven_jar(
      name = "xml_apis_xml_apis",
      artifact = "xml-apis:xml-apis:1.3.04",
      sha1 = "90b215f48fe42776c8c7f6e3509ec54e84fd65ef",
  )


  native.maven_jar(
      name = "com_google_truth_truth",
      artifact = "com.google.truth:truth:0.40",
      sha1 = "0d74e716afec045cc4a178dbbfde2a8314ae5574",
  )


  # com.google.guava:guava:bundle:23.4-android
  # com.google.truth:truth:jar:0.40 wanted version 2.1.3
  native.maven_jar(
      name = "com_google_errorprone_error_prone_annotations",
      artifact = "com.google.errorprone:error_prone_annotations:2.0.18",
      sha1 = "5f65affce1684999e2f4024983835efc3504012e",
  )


  # com.google.truth:truth:jar:0.40
  native.maven_jar(
      name = "com_googlecode_java_diff_utils_diffutils",
      artifact = "com.googlecode.java-diff-utils:diffutils:1.3.0",
      sha1 = "7e060dd5b19431e6d198e91ff670644372f60fbd",
  )


  # org.eclipse.jetty:jetty-annotations:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_plus",
      artifact = "org.eclipse.jetty:jetty-plus:9.2.13.v20150730",
      sha1 = "1e5f3fd1489441a8dd85c4f5abc01983ad13b2d6",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "net_sourceforge_htmlunit_htmlunit_core_js",
      artifact = "net.sourceforge.htmlunit:htmlunit-core-js:2.17",
      sha1 = "4316d68f449d42f69faf4ee255aa31b03e4f7dd5",
  )


  # org.eclipse.jetty.websocket:websocket-common:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_websocket_websocket_api",
      artifact = "org.eclipse.jetty.websocket:websocket-api:9.2.13.v20150730",
      sha1 = "11f8b6f733f45e218bcdf0406667af99995bc45b",
  )


  native.maven_jar(
      name = "com_google_gwt_gwt_dev",
      artifact = "com.google.gwt:gwt-dev:2.8.1",
      sha1 = "c7e88c07e9cda90cc623b4451d0d9713ae03aa53",
  )


  # com.google.gwt:gwt-user:jar:2.8.2 got requested version
  # com.google.gwt:gwt-user:jar:2.8.2
  native.maven_jar(
      name = "javax_validation_validation_api",
      artifact = "javax.validation:validation-api:1.0.0.GA",
      sha1 = "b6bd7f9d78f6fdaa3c37dae18a4bd298915f328e",
  )


  # junit:junit:jar:4.12
  native.maven_jar(
      name = "org_hamcrest_hamcrest_core",
      artifact = "org.hamcrest:hamcrest-core:1.3",
      sha1 = "42a25dc3219429f0e5d060061f71acb49bf010a0",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_servlets",
      artifact = "org.eclipse.jetty:jetty-servlets:9.2.14.v20151106",
      sha1 = "a75c78a0ee544073457ca5ee9db20fdc6ed55225",
  )


  # com.google.gwt:gwt-user:jar:2.8.2 got requested version
  # com.google.gwt:gwt-user:jar:2.8.2
  native.maven_jar(
      name = "com_google_jsinterop_jsinterop_annotations",
      artifact = "com.google.jsinterop:jsinterop-annotations:1.0.2",
      sha1 = "abd7319f53d018e11108a88f599bd16492448dd2",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "xalan_xalan",
      artifact = "xalan:xalan:2.7.2",
      sha1 = "d55d3f02a56ec4c25695fe67e1334ff8c2ecea23",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "tapestry_tapestry",
      artifact = "tapestry:tapestry:4.0.2",
      sha1 = "e855a807425d522e958cbce8697f21e9d679b1f7",
  )


  # org.eclipse.jetty:jetty-webapp:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_servlet",
      artifact = "org.eclipse.jetty:jetty-servlet:9.2.13.v20150730",
      sha1 = "5ad6e38015a97ae9a60b6c2ad744ccfa9cf93a50",
  )


  # org.ow2.asm:asm-commons:jar:5.0.3 got requested version
  # org.ow2.asm:asm-util:jar:5.0.3
  native.maven_jar(
      name = "org_ow2_asm_asm_tree",
      artifact = "org.ow2.asm:asm-tree:5.0.3",
      sha1 = "287749b48ba7162fb67c93a026d690b29f410bed",
  )


  native.maven_jar(
      name = "com_google_gwt_gwt_user",
      artifact = "com.google.gwt:gwt-user:2.8.2",
      sha1 = "a2b9be2c996a658c4e009ba652a9c6a81c88a797",
  )


  # org.eclipse.jetty:jetty-plus:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_jndi",
      artifact = "org.eclipse.jetty:jetty-jndi:9.2.13.v20150730",
      sha1 = "cc5845a2280b605cc4931a28f9c02b4835e8c316",
  )


  # org.eclipse.jetty:jetty-annotations:jar:9.2.13.v20150730 wanted version 5.0.1
  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_ow2_asm_asm_commons",
      artifact = "org.ow2.asm:asm-commons:5.0.3",
      sha1 = "a7111830132c7f87d08fe48cb0ca07630f8cb91c",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_eclipse_jetty_apache_jsp",
      artifact = "org.eclipse.jetty:apache-jsp:9.2.14.v20151106",
      sha1 = "0756745c6efff964ae8d183866b962a534f20e30",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "org_apache_httpcomponents_httpmime",
      artifact = "org.apache.httpcomponents:httpmime:4.5.1",
      sha1 = "96823b9421ebb9f490dec837d9f96134e864e3a7",
  )


  # org.eclipse.jetty:jetty-plus:jar:9.2.13.v20150730 wanted version 9.2.13.v20150730
  # org.eclipse.jetty:jetty-annotations:jar:9.2.13.v20150730 wanted version 9.2.13.v20150730
  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_webapp",
      artifact = "org.eclipse.jetty:jetty-webapp:9.2.14.v20151106",
      sha1 = "773f1c45f6534bff6313997ab3bdbe25533ee255",
  )


  # com.google.guava:guava:bundle:23.4-android
  native.maven_jar(
      name = "com_google_j2objc_j2objc_annotations",
      artifact = "com.google.j2objc:j2objc-annotations:1.1",
      sha1 = "ed28ded51a8b1c6b112568def5f4b455e6809019",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_annotations",
      artifact = "org.eclipse.jetty:jetty-annotations:9.2.14.v20151106",
      sha1 = "bb7030e5d13eaf9023f38e297c8b2fcae4f8be9b",
  )


  # org.apache.httpcomponents:httpclient:jar:4.5.1
  native.maven_jar(
      name = "org_apache_httpcomponents_httpcore",
      artifact = "org.apache.httpcomponents:httpcore:4.4.3",
      sha1 = "e876a79d561e5c6207b78d347e198c8c4531a5e5",
  )


  # org.eclipse.jetty.websocket:websocket-client:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_websocket_websocket_common",
      artifact = "org.eclipse.jetty.websocket:websocket-common:9.2.13.v20150730",
      sha1 = "1e7b1ef77f4bd774b4bbaf5495772194ef8da691",
  )


  native.maven_jar(
      name = "com_google_guava_guava_gwt",
      artifact = "com.google.guava:guava-gwt:23.6.1-jre",
      sha1 = "6c88422d0df90c22231ae45c8c1ba207ad587ca2",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "net_sourceforge_htmlunit_htmlunit",
      artifact = "net.sourceforge.htmlunit:htmlunit:2.19",
      sha1 = "230f011fa87e96ff4115cd8c9d1572572d718b3e",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "colt_colt",
      artifact = "colt:colt:1.2.0",
      sha1 = "0abc984f3adc760684d49e0f11ddf167ba516d4f",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "xerces_xercesImpl",
      artifact = "xerces:xercesImpl:2.11.0",
      sha1 = "9bb329db1cfc4e22462c9d6b43a8432f5850e92c",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "net_sourceforge_cssparser_cssparser",
      artifact = "net.sourceforge.cssparser:cssparser:0.9.18",
      sha1 = "61c015378d27b5e245a5deb7a324c7e716b4706a",
  )


  # org.eclipse.jetty:jetty-server:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty.websocket:websocket-client:jar:9.2.13.v20150730
  # org.eclipse.jetty:jetty-servlets:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty.websocket:websocket-common:jar:9.2.13.v20150730 got requested version
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_io",
      artifact = "org.eclipse.jetty:jetty-io:9.2.13.v20150730",
      sha1 = "7a351e6a1b63dfd56b6632623f7ca2793ffb67ad",
  )


  # org.eclipse.jetty:apache-jsp:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_mortbay_jasper_apache_jsp",
      artifact = "org.mortbay.jasper:apache-jsp:8.0.9.M3",
      sha1 = "0e46309f2423c0d7321cc2a0928f4e411b82aee9",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19 wanted version 3.2.1
  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "commons_collections_commons_collections",
      artifact = "commons-collections:commons-collections:3.2.2",
      sha1 = "8ad72fe39fa8c91eaaf12aadb21e0c3661fe26d5",
  )


  # com.google.truth:truth:jar:0.40
  native.maven_jar(
      name = "junit_junit",
      artifact = "junit:junit:4.12",
      sha1 = "2973d150c0dc1fefe998f834810d68f278ea58ec",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "com_ibm_icu_icu4j",
      artifact = "com.ibm.icu:icu4j:50.1.1",
      sha1 = "c1267563fd08f2885bc1f934ddaca15d19c3d888",
  )


  # com.google.guava:guava:bundle:23.4-android
  native.maven_jar(
      name = "org_codehaus_mojo_animal_sniffer_annotations",
      artifact = "org.codehaus.mojo:animal-sniffer-annotations:1.14",
      sha1 = "775b7e22fb10026eed3f86e8dc556dfafe35f2d5",
  )


  # org.apache.httpcomponents:httpclient:jar:4.5.1
  # net.sourceforge.htmlunit:htmlunit:jar:2.19 got requested version
  native.maven_jar(
      name = "commons_logging_commons_logging",
      artifact = "commons-logging:commons-logging:1.2",
      sha1 = "4bfc12adfe4842bf07b657f0369c4cb522955686",
  )


  # org.eclipse.jetty:jetty-jndi:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:apache-jsp:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty.websocket:websocket-client:jar:9.2.13.v20150730
  # org.eclipse.jetty:jetty-http:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:jetty-xml:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:jetty-io:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:jetty-servlets:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty.websocket:websocket-common:jar:9.2.13.v20150730 got requested version
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_util",
      artifact = "org.eclipse.jetty:jetty-util:9.2.13.v20150730",
      sha1 = "c101476360a7cdd0670462de04053507d5e70c97",
  )


  # com.google.gwt:gwt-dev:jar:2.8.1
  native.maven_jar(
      name = "com_google_code_gson_gson",
      artifact = "com.google.code.gson:gson:2.6.2",
      sha1 = "f1bc476cc167b18e66c297df599b2377131a8947",
  )


  # xalan:xalan:jar:2.7.2
  native.maven_jar(
      name = "xalan_serializer",
      artifact = "xalan:serializer:2.7.2",
      sha1 = "24247f3bb052ee068971393bdb83e04512bb1c3c",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  # org.apache.httpcomponents:httpmime:jar:4.5.1 got requested version
  native.maven_jar(
      name = "org_apache_httpcomponents_httpclient",
      artifact = "org.apache.httpcomponents:httpclient:4.5.1",
      sha1 = "7e3cecc566df91338c6c67883b89ddd05a17db43",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "org_eclipse_jetty_websocket_websocket_client",
      artifact = "org.eclipse.jetty.websocket:websocket-client:9.2.13.v20150730",
      sha1 = "52833f983df57fd6aaae9642d39b87a82d38c177",
  )


  # org.eclipse.jetty:jetty-server:jar:9.2.13.v20150730
  # org.eclipse.jetty:jetty-servlets:jar:9.2.13.v20150730 got requested version
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_http",
      artifact = "org.eclipse.jetty:jetty-http:9.2.13.v20150730",
      sha1 = "23a745d9177ef67ef53cc46b9b70c5870082efc2",
  )


  # org.eclipse.jetty:jetty-servlets:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_continuation",
      artifact = "org.eclipse.jetty:jetty-continuation:9.2.13.v20150730",
      sha1 = "f6bd4e6871ecd0a5e7a5e5addcea160cd73f81bb",
  )


  # net.sourceforge.htmlunit:htmlunit:jar:2.19
  native.maven_jar(
      name = "org_apache_commons_commons_lang3",
      artifact = "org.apache.commons:commons-lang3:3.4",
      sha1 = "5fe28b9518e58819180a43a850fbc0dd24b7c050",
  )


  # org.eclipse.jetty:jetty-servlet:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_security",
      artifact = "org.eclipse.jetty:jetty-security:9.2.13.v20150730",
      sha1 = "cc7c7f27ec4cc279253be1675d9e47e58b995943",
  )


  # org.eclipse.jetty:apache-jsp:jar:9.2.13.v20150730 got requested version
  # org.eclipse.jetty:jetty-server:jar:9.2.13.v20150730 got requested version
  # com.google.gwt:gwt-user:jar:2.8.2
  native.maven_jar(
      name = "javax_servlet_javax_servlet_api",
      artifact = "javax.servlet:javax.servlet-api:3.1.0",
      sha1 = "3cd63d075497751784b2fa84be59432f4905bf7c",
  )


  # org.eclipse.jetty:jetty-webapp:jar:9.2.13.v20150730
  native.maven_jar(
      name = "org_eclipse_jetty_jetty_xml",
      artifact = "org.eclipse.jetty:jetty-xml:9.2.13.v20150730",
      sha1 = "9e17bdfb8c25d0cd377960326b79379df3181776",
  )


  # com.google.truth:truth:jar:0.40
  # com.google.guava:guava-gwt:jar:23.4-android got requested version
  native.maven_jar(
      name = "com_google_guava_guava",
      artifact = "com.google.guava:guava:23.4-android",
      sha1 = "6b52ce80a01cdd1bda08d81d2e4035e5399ee903",
  )




def generated_java_libraries():
  native.java_library(
      name = "com_google_code_findbugs_jsr305",
      visibility = ["//visibility:public"],
      exports = ["@com_google_code_findbugs_jsr305//jar"],
  )


  native.java_library(
      name = "javax_annotation_javax_annotation_api",
      visibility = ["//visibility:public"],
      exports = ["@javax_annotation_javax_annotation_api//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_toolchain_jetty_schemas",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_toolchain_jetty_schemas//jar"],
  )


  native.java_library(
      name = "org_ow2_asm_asm_util",
      visibility = ["//visibility:public"],
      exports = ["@org_ow2_asm_asm_util//jar"],
      runtime_deps = [
          ":org_ow2_asm_asm",
          ":org_ow2_asm_asm_tree",
      ],
  )


  native.java_library(
      name = "commons_io_commons_io",
      visibility = ["//visibility:public"],
      exports = ["@commons_io_commons_io//jar"],
  )


  native.java_library(
      name = "net_sourceforge_nekohtml_nekohtml",
      visibility = ["//visibility:public"],
      exports = ["@net_sourceforge_nekohtml_nekohtml//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_server",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_server//jar"],
      runtime_deps = [
          ":javax_servlet_javax_servlet_api",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "commons_codec_commons_codec",
      visibility = ["//visibility:public"],
      exports = ["@commons_codec_commons_codec//jar"],
  )


  native.java_library(
      name = "org_ow2_asm_asm",
      visibility = ["//visibility:public"],
      exports = ["@org_ow2_asm_asm//jar"],
  )


  native.java_library(
      name = "org_mortbay_jasper_apache_el",
      visibility = ["//visibility:public"],
      exports = ["@org_mortbay_jasper_apache_el//jar"],
  )


  native.java_library(
      name = "ant_ant",
      visibility = ["//visibility:public"],
      exports = ["@ant_ant//jar"],
  )


  native.java_library(
      name = "xml_apis_xml_apis",
      visibility = ["//visibility:public"],
      exports = ["@xml_apis_xml_apis//jar"],
  )


  native.java_library(
      name = "com_google_truth_truth",
      visibility = ["//visibility:public"],
      exports = ["@com_google_truth_truth//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_guava_guava",
          ":com_google_j2objc_j2objc_annotations",
          ":com_googlecode_java_diff_utils_diffutils",
          ":junit_junit",
          ":org_codehaus_mojo_animal_sniffer_annotations",
          ":org_hamcrest_hamcrest_core",
      ],
  )


  native.java_library(
      name = "com_google_errorprone_error_prone_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_google_errorprone_error_prone_annotations//jar"],
  )


  native.java_library(
      name = "com_googlecode_java_diff_utils_diffutils",
      visibility = ["//visibility:public"],
      exports = ["@com_googlecode_java_diff_utils_diffutils//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_plus",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_plus//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_jndi",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_jetty_webapp",
      ],
  )


  native.java_library(
      name = "net_sourceforge_htmlunit_htmlunit_core_js",
      visibility = ["//visibility:public"],
      exports = ["@net_sourceforge_htmlunit_htmlunit_core_js//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_websocket_websocket_api",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_websocket_websocket_api//jar"],
  )


  native.java_library(
      name = "com_google_gwt_gwt_dev",
      visibility = ["//visibility:public"],
      exports = ["@com_google_gwt_gwt_dev//jar"],
      runtime_deps = [
          ":ant_ant",
          ":colt_colt",
          ":com_google_code_gson_gson",
          ":com_ibm_icu_icu4j",
          ":commons_codec_commons_codec",
          ":commons_collections_commons_collections",
          ":commons_io_commons_io",
          ":commons_logging_commons_logging",
          ":javax_annotation_javax_annotation_api",
          ":javax_servlet_javax_servlet_api",
          ":net_sourceforge_cssparser_cssparser",
          ":net_sourceforge_htmlunit_htmlunit",
          ":net_sourceforge_htmlunit_htmlunit_core_js",
          ":net_sourceforge_nekohtml_nekohtml",
          ":org_apache_commons_commons_lang3",
          ":org_apache_httpcomponents_httpclient",
          ":org_apache_httpcomponents_httpcore",
          ":org_apache_httpcomponents_httpmime",
          ":org_eclipse_jetty_apache_jsp",
          ":org_eclipse_jetty_jetty_annotations",
          ":org_eclipse_jetty_jetty_continuation",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_jndi",
          ":org_eclipse_jetty_jetty_plus",
          ":org_eclipse_jetty_jetty_security",
          ":org_eclipse_jetty_jetty_server",
          ":org_eclipse_jetty_jetty_servlet",
          ":org_eclipse_jetty_jetty_servlets",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_jetty_webapp",
          ":org_eclipse_jetty_jetty_xml",
          ":org_eclipse_jetty_toolchain_jetty_schemas",
          ":org_eclipse_jetty_websocket_websocket_api",
          ":org_eclipse_jetty_websocket_websocket_client",
          ":org_eclipse_jetty_websocket_websocket_common",
          ":org_mortbay_jasper_apache_el",
          ":org_mortbay_jasper_apache_jsp",
          ":org_ow2_asm_asm",
          ":org_ow2_asm_asm_commons",
          ":org_ow2_asm_asm_tree",
          ":org_ow2_asm_asm_util",
          ":tapestry_tapestry",
          ":xalan_serializer",
          ":xalan_xalan",
          ":xerces_xercesImpl",
          ":xml_apis_xml_apis",
      ],
  )


  native.java_library(
      name = "javax_validation_validation_api",
      visibility = ["//visibility:public"],
      exports = ["@javax_validation_validation_api//jar"],
  )


  native.java_library(
      name = "org_hamcrest_hamcrest_core",
      visibility = ["//visibility:public"],
      exports = ["@org_hamcrest_hamcrest_core//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_servlets",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_servlets//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_continuation",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "com_google_jsinterop_jsinterop_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_google_jsinterop_jsinterop_annotations//jar"],
  )


  native.java_library(
      name = "xalan_xalan",
      visibility = ["//visibility:public"],
      exports = ["@xalan_xalan//jar"],
      runtime_deps = [
          ":xalan_serializer",
          ":xml_apis_xml_apis",
      ],
  )


  native.java_library(
      name = "tapestry_tapestry",
      visibility = ["//visibility:public"],
      exports = ["@tapestry_tapestry//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_servlet",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_servlet//jar"],
      runtime_deps = [
          ":javax_servlet_javax_servlet_api",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_security",
          ":org_eclipse_jetty_jetty_server",
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "org_ow2_asm_asm_tree",
      visibility = ["//visibility:public"],
      exports = ["@org_ow2_asm_asm_tree//jar"],
      runtime_deps = [
          ":org_ow2_asm_asm",
      ],
  )


  native.java_library(
      name = "com_google_gwt_gwt_user",
      visibility = ["//visibility:public"],
      exports = ["@com_google_gwt_gwt_user//jar"],
      runtime_deps = [
          ":com_google_jsinterop_jsinterop_annotations",
          ":javax_servlet_javax_servlet_api",
          ":javax_validation_validation_api",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_jndi",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_jndi//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "org_ow2_asm_asm_commons",
      visibility = ["//visibility:public"],
      exports = ["@org_ow2_asm_asm_commons//jar"],
      runtime_deps = [
          ":org_ow2_asm_asm_tree",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_apache_jsp",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_apache_jsp//jar"],
      runtime_deps = [
          ":javax_servlet_javax_servlet_api",
          ":org_eclipse_jetty_jetty_server",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_toolchain_jetty_schemas",
          ":org_mortbay_jasper_apache_el",
          ":org_mortbay_jasper_apache_jsp",
      ],
  )


  native.java_library(
      name = "org_apache_httpcomponents_httpmime",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_httpcomponents_httpmime//jar"],
      runtime_deps = [
          ":org_apache_httpcomponents_httpclient",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_webapp",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_webapp//jar"],
      runtime_deps = [
          ":javax_servlet_javax_servlet_api",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_security",
          ":org_eclipse_jetty_jetty_server",
          ":org_eclipse_jetty_jetty_servlet",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_jetty_xml",
      ],
  )


  native.java_library(
      name = "com_google_j2objc_j2objc_annotations",
      visibility = ["//visibility:public"],
      exports = ["@com_google_j2objc_j2objc_annotations//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_annotations",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_annotations//jar"],
      runtime_deps = [
          ":javax_annotation_javax_annotation_api",
          ":org_eclipse_jetty_jetty_jndi",
          ":org_eclipse_jetty_jetty_plus",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_jetty_webapp",
          ":org_ow2_asm_asm",
          ":org_ow2_asm_asm_commons",
      ],
  )


  native.java_library(
      name = "org_apache_httpcomponents_httpcore",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_httpcomponents_httpcore//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_websocket_websocket_common",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_websocket_websocket_common//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_websocket_websocket_api",
      ],
  )


  native.java_library(
      name = "com_google_guava_guava_gwt",
      visibility = ["//visibility:public"],
      exports = ["@com_google_guava_guava_gwt//jar"],
      runtime_deps = [
          ":com_google_guava_guava",
      ],
  )


  native.java_library(
      name = "net_sourceforge_htmlunit_htmlunit",
      visibility = ["//visibility:public"],
      exports = ["@net_sourceforge_htmlunit_htmlunit//jar"],
      runtime_deps = [
          ":commons_codec_commons_codec",
          ":commons_collections_commons_collections",
          ":commons_io_commons_io",
          ":commons_logging_commons_logging",
          ":net_sourceforge_cssparser_cssparser",
          ":net_sourceforge_htmlunit_htmlunit_core_js",
          ":net_sourceforge_nekohtml_nekohtml",
          ":org_apache_commons_commons_lang3",
          ":org_apache_httpcomponents_httpclient",
          ":org_apache_httpcomponents_httpcore",
          ":org_apache_httpcomponents_httpmime",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_websocket_websocket_api",
          ":org_eclipse_jetty_websocket_websocket_client",
          ":org_eclipse_jetty_websocket_websocket_common",
          ":xalan_serializer",
          ":xalan_xalan",
          ":xerces_xercesImpl",
          ":xml_apis_xml_apis",
      ],
  )


  native.java_library(
      name = "colt_colt",
      visibility = ["//visibility:public"],
      exports = ["@colt_colt//jar"],
  )


  native.java_library(
      name = "xerces_xercesImpl",
      visibility = ["//visibility:public"],
      exports = ["@xerces_xercesImpl//jar"],
      runtime_deps = [
          ":xml_apis_xml_apis",
      ],
  )


  native.java_library(
      name = "net_sourceforge_cssparser_cssparser",
      visibility = ["//visibility:public"],
      exports = ["@net_sourceforge_cssparser_cssparser//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_io",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_io//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "org_mortbay_jasper_apache_jsp",
      visibility = ["//visibility:public"],
      exports = ["@org_mortbay_jasper_apache_jsp//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_toolchain_jetty_schemas",
          ":org_mortbay_jasper_apache_el",
      ],
  )


  native.java_library(
      name = "commons_collections_commons_collections",
      visibility = ["//visibility:public"],
      exports = ["@commons_collections_commons_collections//jar"],
  )


  native.java_library(
      name = "junit_junit",
      visibility = ["//visibility:public"],
      exports = ["@junit_junit//jar"],
      runtime_deps = [
          ":org_hamcrest_hamcrest_core",
      ],
  )


  native.java_library(
      name = "com_ibm_icu_icu4j",
      visibility = ["//visibility:public"],
      exports = ["@com_ibm_icu_icu4j//jar"],
  )


  native.java_library(
      name = "org_codehaus_mojo_animal_sniffer_annotations",
      visibility = ["//visibility:public"],
      exports = ["@org_codehaus_mojo_animal_sniffer_annotations//jar"],
  )


  native.java_library(
      name = "commons_logging_commons_logging",
      visibility = ["//visibility:public"],
      exports = ["@commons_logging_commons_logging//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_util",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_util//jar"],
  )


  native.java_library(
      name = "com_google_code_gson_gson",
      visibility = ["//visibility:public"],
      exports = ["@com_google_code_gson_gson//jar"],
  )


  native.java_library(
      name = "xalan_serializer",
      visibility = ["//visibility:public"],
      exports = ["@xalan_serializer//jar"],
      runtime_deps = [
          ":xml_apis_xml_apis",
      ],
  )


  native.java_library(
      name = "org_apache_httpcomponents_httpclient",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_httpcomponents_httpclient//jar"],
      runtime_deps = [
          ":commons_codec_commons_codec",
          ":commons_logging_commons_logging",
          ":org_apache_httpcomponents_httpcore",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_websocket_websocket_client",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_websocket_websocket_client//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_util",
          ":org_eclipse_jetty_websocket_websocket_api",
          ":org_eclipse_jetty_websocket_websocket_common",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_http",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_http//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_continuation",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_continuation//jar"],
  )


  native.java_library(
      name = "org_apache_commons_commons_lang3",
      visibility = ["//visibility:public"],
      exports = ["@org_apache_commons_commons_lang3//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_security",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_security//jar"],
      runtime_deps = [
          ":javax_servlet_javax_servlet_api",
          ":org_eclipse_jetty_jetty_http",
          ":org_eclipse_jetty_jetty_io",
          ":org_eclipse_jetty_jetty_server",
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "javax_servlet_javax_servlet_api",
      visibility = ["//visibility:public"],
      exports = ["@javax_servlet_javax_servlet_api//jar"],
  )


  native.java_library(
      name = "org_eclipse_jetty_jetty_xml",
      visibility = ["//visibility:public"],
      exports = ["@org_eclipse_jetty_jetty_xml//jar"],
      runtime_deps = [
          ":org_eclipse_jetty_jetty_util",
      ],
  )


  native.java_library(
      name = "com_google_guava_guava",
      visibility = ["//visibility:public"],
      exports = ["@com_google_guava_guava//jar"],
      runtime_deps = [
          ":com_google_code_findbugs_jsr305",
          ":com_google_errorprone_error_prone_annotations",
          ":com_google_j2objc_j2objc_annotations",
          ":org_codehaus_mojo_animal_sniffer_annotations",
      ],
  )


