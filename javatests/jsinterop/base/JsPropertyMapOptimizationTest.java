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
import jsinterop.annotations.JsProperty;

/** Tests for verifying {@link JsPropertyMap} optimize out by compiler. */
public class JsPropertyMapOptimizationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsMethod
  private static void modifyObject(Object objectField) {
    JsPropertyMap.of(objectField).set("x-x", "ABC");
  }

  @JsProperty
  private static native Object getModifyObject();

  public void testSet() {
    assertFunctionMatches(getModifyObject(), "<obf>['x-x']='ABC'");
  }

  @JsMethod
  private static void modifyObjectInt(Object objectField) {
    JsPropertyMap.of(objectField).set("x-x", 42);
  }

  @JsProperty
  private static native Object getModifyObjectInt();

  public void testSetInt() {
    assertFunctionMatches(getModifyObjectInt(), "<obf>['x-x']=42");
  }

  @JsMethod
  private static void modifyObjectLong(Object objectField, long local) {
    JsPropertyMap.of(objectField).set("x-x", local);
  }

  @JsProperty
  private static native Object getModifyObjectLong();

  public void testSetLong() {
    assertFunctionMatches(getModifyObjectLong(), "<obf>['x-x']=<obf>");
  }

  @JsMethod
  private static Object accessObject(Object objectField) {
    return JsPropertyMap.of(objectField).get("x-x");
  }

  @JsProperty
  private static native Object getAccessObject();

  public void testGet() {
    assertFunctionMatches(getAccessObject(), "return <obf>['x-x']");
  }

  @JsMethod
  private static int accessObjectInt(Object objectField) {
    return JsPropertyMap.of(objectField).getAny("x-x").asInt();
  }

  @JsProperty
  private static native Object getAccessObjectInt();

  public void testGetAsInt() {
    assertFunctionMatches(getAccessObjectInt(), "return <obf>['x-x']");
  }

  @JsMethod
  private static long accessObjectLong(Object objectField) {
    return JsPropertyMap.of(objectField).getAny("x-x").asLong();
  }

  @JsProperty
  private static native Object getAccessObjectLong();

  public void testGetAsLong() {
    assertFunctionMatches(getAccessObjectLong(), "return <obf>['x-x']");
  }
}
