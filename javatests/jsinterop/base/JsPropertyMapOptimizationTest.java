/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */
package jsinterop.base;

import static jsinterop.base.FunctionAssert.assertFunctionMatches;

import com.google.gwt.junit.client.GWTTestCase;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;

/** Tests for verifying {@link JsPropertyMap} optimize out by compiler. */
public class JsPropertyMapOptimizationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsMethod
  private void modifyObject(Object objectField) {
    JsPropertyMap.of(objectField).set("x-x", "ABC");
  }

  public void testSet() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyObject(), "<obf>['x-x']='ABC'");
  }

  @JsMethod
  private void modifyObjectInt(Object objectField) {
    JsPropertyMap.of(objectField).set("x-x", 42);
  }

  public void testSetInt() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyObjectInt(), "<obf>['x-x']=42");
  }

  @JsMethod
  private void modifyObjectLong(Object objectField, long local) {
    JsPropertyMap.of(objectField).set("x-x", local);
  }

  public void testSetLong() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyObjectLong(), "<obf>['x-x']=<obf>");
  }

  @JsMethod
  private Object accessObject(Object objectField) {
    return JsPropertyMap.of(objectField).get("x-x");
  }

  public void testGet() {
    assertFunctionMatches(((MethodsAsProperties) this).getAccessObject(), "return <obf>['x-x']");
  }

  @JsMethod
  private int accessObjectInt(Object objectField) {
    return JsPropertyMap.of(objectField).getAny("x-x").asInt();
  }

  public void testGetAsInt() {
    assertFunctionMatches(((MethodsAsProperties) this).getAccessObjectInt(), "return <obf>['x-x']");
  }

  @JsMethod
  private long accessObjectLong(Object objectField) {
    return JsPropertyMap.of(objectField).getAny("x-x").asLong();
  }

  public void testGetAsLong() {
    assertFunctionMatches(
        ((MethodsAsProperties) this).getAccessObjectLong(), "return <obf>['x-x']");
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
  private interface MethodsAsProperties {
    @JsProperty
    Object getModifyObject();

    @JsProperty
    Object getModifyObjectInt();

    @JsProperty
    Object getModifyObjectLong();

    @JsProperty
    Object getAccessObject();

    @JsProperty
    Object getAccessObjectInt();

    @JsProperty
    Object getAccessObjectLong();
  }
}
