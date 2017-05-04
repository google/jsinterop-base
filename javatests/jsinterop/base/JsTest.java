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

import com.google.common.annotations.UsedReflectively;
import com.google.gwt.junit.client.GWTTestCase;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

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
    String unused = Js.uncheckedCast(3.5);
  }

  public void testCast() {
    Double unusedDouble = Js.cast(3.5);
    assertThrowsClassCastException(
        () -> {
          String unusedString = Js.cast(3.5);
        });
  }

  public void testAsPropertyMap() {
    Js.asPropertyMap(1d);
    Js.asPropertyMap("");
    Js.asPropertyMap(null); // Js.asPropertyMap is similar to casting so null should be accepted.
  }

  public void testAsArrayLike() {
    Js.asArrayLike(new String[0]);
    Js.asArrayLike(Js.arguments());
    Js.asArrayLike(null); // Js.asArrayLike is similar to casting so null should be accepted.

    assertThrowsHiddenClassCastException(() -> Js.asArrayLike(5));
    assertThrowsHiddenClassCastException(() -> Js.asArrayLike("str"));
    assertThrowsHiddenClassCastException(() -> Js.asArrayLike(new Object()));

    JsPropertyMap<Object> objectWithNonconformingLength = JsPropertyMap.of("length", null);
    assertThrowsHiddenClassCastException(() -> Js.asArrayLike(objectWithNonconformingLength));

    Js.asPropertyMap(objectWithNonconformingLength).set("length", "1");
    assertThrowsHiddenClassCastException(() -> Js.asArrayLike(objectWithNonconformingLength));
  }

  public void testAsDouble() {
    assertThat(Js.asDouble(15.5d)).isEqualTo(15.5d);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> AsDouble(15L));
    assertThrowsHiddenClassCastException(() -> Js.asDouble(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.asDouble("1"));
    assertThrowsHiddenClassCastException(() -> Js.asDouble(""));
    assertThrowsHiddenClassCastException(() -> Js.asDouble(null));
  }

  public void testAsFloat() {
    // Note: float is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asFloat(15.5d)).isEqualTo(15.5f);
  }

  public void testAsLong() {
    assertThat(Js.asLong(Js.asAny(15L))).isEqualTo(15L);
    assertThat(Js.asLong(Js.asAny(Long.MAX_VALUE))).isEqualTo(Long.MAX_VALUE);
    assertThat(Js.asLong(Js.asAny(Long.MIN_VALUE))).isEqualTo(Long.MIN_VALUE);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> Js.asLong(15d));
    assertThrowsHiddenClassCastException(() -> Js.asLong(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.asLong(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.asLong("1"));
    assertThrowsHiddenClassCastException(() -> Js.asLong(""));
    assertThrowsHiddenClassCastException(() -> Js.asLong(null));
  }

  public void testAsInt() {
    // Note: int is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asInt(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asInt(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.asInt(Integer.MAX_VALUE + 1d));
  }

  public void testAsShort() {
    // Note: short is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asShort(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asShort(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.asShort(Short.MAX_VALUE + 1d));
  }

  public void testAsChar() {
    // Note: char is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asChar(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asChar(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.asChar(Character.MAX_VALUE + 1d));
  }

  public void testAsByte() {
    // Note: byte is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asByte(15d)).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asByte(15.5d));
    assertThrowsHiddenClassCastException(() -> Js.asByte(Byte.MAX_VALUE + 1d));
  }

  public void testAsBoolean() {
    assertThat(Js.asBoolean(true)).isTrue();
    assertThat(Js.asBoolean(false)).isFalse();

    assertThrowsHiddenClassCastException(() -> Js.asBoolean(15));
    assertThrowsHiddenClassCastException(() -> Js.asBoolean(new Object()));
    assertThrowsHiddenClassCastException(() -> Js.asBoolean("1"));
    assertThrowsHiddenClassCastException(() -> Js.asBoolean(""));
    assertThrowsHiddenClassCastException(() -> Js.asBoolean(null));
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
    JsArrayLike<Object> arrayLike = ((IndirectMethodAccess) this).getArguments("a", "b", "c");
    assertThat(arrayLike.getLength()).isEqualTo(3);
    assertThat(arrayLike.getAt(0)).isEqualTo("a");
    assertThat(arrayLike.getAt(1)).isEqualTo("b");
    assertThat(arrayLike.getAt(2)).isEqualTo("c");
  }

  @JsMethod @UsedReflectively
  private JsArrayLike<Object> getArgumentsHack(Object arg1, Object arg2, Object arg3) {
    return Js.arguments();
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "?")
  private interface IndirectMethodAccess {
    // The extra indirection here prevents GWT optimization over params.
    @JsMethod(name = "getArgumentsHack")
    JsArrayLike<Object> getArguments(Object arg1, Object arg2, Object arg3);
  }
}
