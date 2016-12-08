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

import static com.google.common.truth.Truth.assertThat;

import com.google.gwt.junit.client.GWTTestCase;
import jsinterop.annotations.JsMethod;

public class JsTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  public void testTypeOf() {
    assertThat(Js.typeof(1.0d)).isEqualTo("number");
    assertThat(Js.typeof("str")).isEqualTo("string");
    assertThat(Js.typeof(new Object())).isEqualTo("object");
  }

  public void testUnsafe() throws Exception {
    //long fakeNumber = Js.cast("dangerous").toLong();
    //String myString = Js.cast(fakeNumber).asAny();
    //assertEquals("dangerous", myString);
  }

  public void testTruthyFalsey() {
    assertThat(Js.isTruthy("abc")).isTrue();
    assertThat(Js.isTruthy("1")).isTrue();
    assertThat(Js.isTruthy("0")).isTrue();
    assertThat(Js.isTruthy(1d)).isTrue();

    assertThat(Js.isFalsy(0d)).isTrue();
    assertThat(Js.isFalsy("")).isTrue();
    assertThat(Js.isFalsy(null)).isTrue();
  }

  public void testTripleEqual() {
    assertThat(Js.isTripleEqual(null, null)).isTrue();
    assertThat(Js.isTripleEqual(Js.undefined(), Js.undefined())).isTrue();
    assertThat(Js.isTripleEqual(Js.undefined(), null)).isFalse();
  }

  public void testArguments() throws Exception {
    JsArrayLike<Object> arrayLike = getArguments("a", "b", "c");
    assertThat(arrayLike.getLength()).isEqualTo(3);
    assertThat(arrayLike.getAt(0)).isEqualTo("a");
    assertThat(arrayLike.getAt(1)).isEqualTo("b");
    assertThat(arrayLike.getAt(2)).isEqualTo("c");
  }

  // The extra indirection here prevents GWT optimization over params.
  @JsMethod(name = "getArgumentsHack")
  private static native JsArrayLike<Object> getArguments(Object arg1, Object arg2, Object arg3);

  @JsMethod
  private static JsArrayLike<Object> getArgumentsHack(Object arg1, Object arg2, Object arg3) {
    return Js.arguments();
  }
}
