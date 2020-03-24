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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsProperty;

public class JsTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  public void testGlobal() {
    assertThat(Js.global().get("eval")).isSameInstanceAs(getEval());
  }

  @JsProperty(namespace = JsPackage.GLOBAL)
  private static native Object getEval();

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

  public void testAndAlso() {
    assertThat(Js.andAlso("foo", "bar")).isEqualTo("bar");
    assertThat(Js.andAlso(1, "bar")).isEqualTo("bar");
    assertThat(Js.andAlso("", "bar")).isEqualTo("");
    assertThat(Js.andAlso(null, "bar")).isNull();
  }

  public void testOrElse() {
    assertThat(Js.orElse("foo", "bar")).isEqualTo("foo");
    assertThat(Js.orElse(1, "bar")).isEqualTo(1);
    assertThat(Js.orElse("", "bar")).isEqualTo("bar");
    assertThat(Js.orElse(null, "bar")).isEqualTo("bar");
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

  public void testCoerceToInt() {
    assertThat(Js.coerceToInt(0.1d)).isEqualTo(0);
    assertThat(Js.coerceToInt(1.1d)).isEqualTo(1);
    assertThat(Js.coerceToInt(-1.1d)).isEqualTo(-1);
    assertThat(Js.coerceToInt(Integer.MAX_VALUE)).isEqualTo(Integer.MAX_VALUE);
    assertThat(Js.coerceToInt(Integer.MIN_VALUE)).isEqualTo(Integer.MIN_VALUE);

    assertThat(Js.coerceToInt("1")).isEqualTo(1);
    assertThat(Js.coerceToInt("0")).isEqualTo(0);
    assertThat(Js.coerceToInt("NaN")).isEqualTo(0);
    assertThat(Js.coerceToInt("random string")).isEqualTo(0);
    assertThat(Js.coerceToInt(new Object())).isEqualTo(0);
    assertThat(Js.coerceToInt(new Object[0])).isEqualTo(0);
    assertThat(Js.coerceToInt(true)).isEqualTo(1);
    assertThat(Js.coerceToInt(false)).isEqualTo(0);
    assertThat(Js.coerceToInt(null)).isEqualTo(0);
  }

  public void testCoerceToDouble() {
    assertThat(Js.coerceToDouble(0.1d)).isEqualTo(0.1d);
    assertThat(Js.coerceToDouble(1.1d)).isEqualTo(1.1d);
    assertThat(Js.coerceToDouble(-1.1d)).isEqualTo(-1.1d);

    assertThat(Js.coerceToDouble("1")).isEqualTo(1d);
    assertThat(Js.coerceToDouble("0")).isEqualTo(0d);
    assertThat(Js.coerceToDouble("Infinity")).isPositiveInfinity();
    assertThat(Js.coerceToDouble("-Infinity")).isNegativeInfinity();
    assertThat(Js.coerceToDouble("NaN")).isNaN();
    assertThat(Js.coerceToDouble("random string")).isNaN();
    assertThat(Js.coerceToDouble(new Object())).isNaN();
    assertThat(Js.coerceToDouble(null)).isEqualTo(0d);
  }

  public void testArguments() throws Exception {
    JsArrayLike<Object> arrayLike = getArguments("a", "b", "c");
    assertThat(arrayLike.getLength()).isEqualTo(3);
    assertThat(arrayLike.getAt(0)).isEqualTo("a");
    assertThat(arrayLike.getAt(1)).isEqualTo("b");
    assertThat(arrayLike.getAt(2)).isEqualTo("c");
  }

  // The extra indirection here prevents GWT optimization over params.
  @JsMethod(name = "getArguments", namespace = "jsinterop.base.GetArgumentsHelper")
  private static native JsArrayLike<Object> getArguments(Object... args);
}
