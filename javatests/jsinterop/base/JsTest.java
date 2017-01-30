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
import static jsinterop.base.ExceptionAssert.assertThrowsClassCastException;
import static jsinterop.base.ExceptionAssert.assertThrowsHiddenClassCastException;

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

  public void testUncheckedCast() {
    String s = Js.uncheckedCast(3.5);
  }

  public void testCast() {
    Double d = Js.cast(3.5);
    assertThrowsClassCastException(
        () -> {
          String s = Js.cast(3.5);
        });
  }

  public void testCastToDouble() {
    assertThat(Js.castToDouble(15.5d)).isEqualTo(15.5d);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> castToDouble(15L));
    assertThrowsHiddenClassCastException(() -> Js.castToDouble(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.castToDouble("1"));
    assertThrowsHiddenClassCastException(() -> Js.castToDouble(""));
    assertThrowsHiddenClassCastException(() -> Js.castToDouble(null));
  }

  public void testCastToFloat() {
    // Note: float is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.castToFloat(15.5d)).isEqualTo(15.5f);
  }

  public void testCastToLong() {
    assertThat(Js.castToLong(Any.of(15L))).isEqualTo(15L);
    assertThat(Js.castToLong(Any.of(Long.MAX_VALUE))).isEqualTo(Long.MAX_VALUE);
    assertThat(Js.castToLong(Any.of(Long.MIN_VALUE))).isEqualTo(Long.MIN_VALUE);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> Js.castToLong(15d));
    assertThrowsHiddenClassCastException(() -> Js.castToLong(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.castToLong(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.castToLong("1"));
    assertThrowsHiddenClassCastException(() -> Js.castToLong(""));
    assertThrowsHiddenClassCastException(() -> Js.castToLong(null));
  }

  public void testCastToInt() {
    // Note: int is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.castToInt(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.castToInt(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.castToInt(Integer.MAX_VALUE + 1d));
  }

  public void testCastToShort() {
    // Note: short is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.castToShort(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.castToShort(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.castToShort(Short.MAX_VALUE + 1d));
  }

  public void testCastToChar() {
    // Note: char is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.castToChar(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.castToChar(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.castToChar(Character.MAX_VALUE + 1d));
  }

  public void testCastToByte() {
    // Note: byte is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.castToByte(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.castToByte(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.castToByte(Byte.MAX_VALUE + 1d));
  }

  public void testCastToBoolean() {
    assertThat(Js.castToBoolean(true)).isEqualTo(true);
    assertThat(Js.castToBoolean(false)).isEqualTo(false);

    assertThrowsHiddenClassCastException(() -> Js.castToBoolean(15));
    assertThrowsHiddenClassCastException(() -> Js.castToBoolean(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.castToBoolean("1"));
    assertThrowsHiddenClassCastException(() -> Js.castToBoolean(""));
    assertThrowsHiddenClassCastException(() -> Js.castToBoolean(null));
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
