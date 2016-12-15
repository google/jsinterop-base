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

/** Tests for verifying {@link JsArrayLike} optimize out by compiler. */
public class JsArrayLikeOptimizationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsMethod
  private static void modifyArray(Object arrayField) {
    JsArrayLike.of(arrayField).setAt(0, "ABC");
  }

  @JsProperty
  private static native Object getModifyArray();

  public void testSet() {
    assertFunctionMatches(getModifyArray(), "<obf>[0]='ABC';");
  }

  @JsMethod
  private static void modifyArrayInt(Object arrayField) {
    JsArrayLike.of(arrayField).setAt(0, 42);
  }

  @JsProperty
  private static native Object getModifyArrayInt();

  public void testSetInt() {
    assertFunctionMatches(getModifyArrayInt(), "<obf>[0]=42;");
  }

  @JsMethod
  private static void modifyArrayLong(Object arrayField, long local) {
    JsArrayLike.of(arrayField).setAt(0, local);
  }

  @JsProperty
  private static native Object getModifyArrayLong();

  public void testSetLong() {
    assertFunctionMatches(getModifyArrayLong(), "<obf>[0]=<obf>;");
  }

  @JsMethod
  private static Object accessArray(Object arrayField) {
    return JsArrayLike.of(arrayField).getAt(0);
  }

  @JsProperty
  private static native Object getAccessArray();

  public void testGet() {
    assertFunctionMatches(getAccessArray(), "return <obf>[0];");
  }

  @JsMethod
  private static int accessArrayInt(Object arrayField) {
    return JsArrayLike.of(arrayField).getAnyAt(0).asInt();
  }

  @JsProperty
  private static native Object getAccessArrayInt();

  public void testGetAsInt() {
    assertFunctionMatches(getAccessArrayInt(), "return <obf>[0];");
  }

  @JsMethod
  private static long accessArrayLong(Object arrayField) {
    return JsArrayLike.of(arrayField).getAnyAt(0).asLong();
  }

  @JsProperty
  private static native Object getAccessArrayLong();

  public void testGetAsLong() {
    assertFunctionMatches(getAccessArrayLong(), "return <obf>[0];");
  }
}
