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

/** Tests for verifying {@link JsArrayLike} optimize out by compiler. */
public class JsArrayLikeOptimizationTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsMethod @SuppressWarnings("unused")
  private void modifyArray(Object arrayField) {
    Js.asArrayLike(arrayField).setAt(0, "ABC");
  }

  public void testSet() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyArray(), "<obf>[0]='ABC';");
  }

  @JsMethod @SuppressWarnings("unused")
  private void modifyArrayInt(Object arrayField) {
    Js.asArrayLike(arrayField).setAt(0, 42);
  }

  public void testSetInt() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyArrayInt(), "<obf>[0]=42;");
  }

  @JsMethod @SuppressWarnings("unused")
  private void modifyArrayLong(Object arrayField, long local) {
    Js.asArrayLike(arrayField).setAt(0, local);
  }

  public void testSetLong() {
    assertFunctionMatches(((MethodsAsProperties) this).getModifyArrayLong(), "<obf>[0]=<obf>;");
  }

  @JsMethod @SuppressWarnings("unused")
  private Object accessArray(Object arrayField) {
    return Js.asArrayLike(arrayField).getAt(0);
  }

  public void testGet() {
    assertFunctionMatches(((MethodsAsProperties) this).getAccessArray(), "return <obf>[0];");
  }

  @JsMethod @SuppressWarnings("unused")
  private int accessArrayInt(Object arrayField) {
    return Js.asArrayLike(arrayField).getAtAsAny(0).asInt();
  }

  public void testGetAsInt() {
    assertFunctionMatches(((MethodsAsProperties) this).getAccessArrayInt(), "return <obf>[0];");
  }

  @JsMethod @SuppressWarnings("unused")
  private long accessArrayLong(Object arrayField) {
    return Js.asArrayLike(arrayField).getAtAsAny(0).asLong();
  }

  public void testGetAsLong() {
    assertFunctionMatches(((MethodsAsProperties) this).getAccessArrayLong(), "return <obf>[0];");
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
  private interface MethodsAsProperties {
    @JsProperty
    Object getModifyArray();

    @JsProperty
    Object getModifyArrayInt();

    @JsProperty
    Object getModifyArrayLong();

    @JsProperty
    Object getAccessArrayLong();

    @JsProperty
    Object getAccessArrayInt();

    @JsProperty
    Object getAccessArray();
  }
}
