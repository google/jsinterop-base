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

public class AnyTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  // would have been much nicer with JUnitParams... :/

  public void testAsPropertyMap() {
    assertThat(Js.asAny("abc").asPropertyMap().getAsAny("toString")).isNotNull();
    assertThat(Js.asAny("abc").asPropertyMap().getAsAny("something")).isNull();
  }

  public void testAsArrayLike() {
    String[] stringArray = {"abc"};
    assertThat(Js.asAny(stringArray).asArrayLike().getAt(0)).isEqualTo("abc");

    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asArrayLike());
  }

  @SuppressWarnings("TruthIncompatibleType")
  public void testAsArray() {
    String[] stringArray = {"abc"};
    assertThat(Js.asAny(stringArray).asArray()[0]).isEqualTo("abc");

    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asArray());
  }

  public void testAsString() {
    assertThat(Js.asAny("abc").asString()).isEqualTo("abc");

    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asString());
  }

  public void testAsDouble() {
    assertThat(Js.asAny(15.5d).asDouble()).isEqualTo(15.5d);
    assertThat(Js.asAny(15.5f).asDouble()).isEqualTo(15.5d);
    assertThat(Js.asAny(15).asDouble()).isEqualTo(15d);
    assertThat(Js.asAny((byte) 15).asDouble()).isEqualTo(15d);
    assertThat(Js.asAny((char) 15).asDouble()).isEqualTo(15d);
    assertThat(Js.asAny((short) 15).asDouble()).isEqualTo(15d);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> Js.asAny(15L).asDouble());
    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asDouble());
    assertThrowsHiddenClassCastException(() -> Js.asAny("1").asDouble());
    assertThrowsHiddenClassCastException(() -> Js.asAny("").asDouble());
    assertThrowsHiddenClassCastException(() -> Js.asAny(null).asDouble());
  }

  public void testAsFloat() {
    // Note: float is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Js.asAny(15.5f).asFloat()).isEqualTo(15.5f);
    assertThat(Js.asAny(15.5d).asFloat()).isEqualTo(15.5f);
  }

  public void testAsLong() {
    assertThat(Js.asAny(0L).asLong()).isEqualTo(0L);
    assertThat(Js.asAny(Long.MIN_VALUE).asLong()).isEqualTo(Long.MIN_VALUE);
    assertThat(Js.asAny(Long.MAX_VALUE).asLong()).isEqualTo(Long.MAX_VALUE);

    // GWT represents small longs as 'number'
    // assertThrowsHiddenClassCastException(() -> Js.asAny(15).asLong());
    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asLong());
    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asLong());
    assertThrowsHiddenClassCastException(() -> Js.asAny("1").asLong());
    assertThrowsHiddenClassCastException(() -> Js.asAny("").asLong());
    assertThrowsHiddenClassCastException(() -> Js.asAny(null).asLong());
  }

  public void testAsInt() {
    // Note: int is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Js.asAny(15).asInt()).isEqualTo(15);
    assertThat(Js.asAny(15d).asInt()).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asInt());
  }

  public void testAsShort() {
    // Note: short is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Js.asAny(15).asShort()).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asShort());
    assertThrowsHiddenClassCastException(() -> Js.asAny(Short.MAX_VALUE + 1).asShort());
  }

  public void testAsChar() {
    // Note: char is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Js.asAny(15).asChar()).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asChar());
    assertThrowsHiddenClassCastException(() -> Js.asAny(Character.MAX_VALUE + 1).asChar());
  }

  public void testAsByte() {
    // Note: byte is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Js.asAny(15).asByte()).isEqualTo(15);

    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asByte());
    assertThrowsHiddenClassCastException(() -> Js.asAny(Byte.MAX_VALUE + 1).asByte());
  }

  public void testAsBoolean() {
    assertThat(Js.asAny(false).asBoolean()).isFalse();
    assertThat(Js.asAny(true).asBoolean()).isTrue();

    assertThrowsHiddenClassCastException(() -> Js.asAny(15.5d).asBoolean());
    assertThrowsHiddenClassCastException(() -> Js.asAny(15L).asBoolean());
    assertThrowsHiddenClassCastException(() -> Js.asAny(new Object()).asBoolean());
    assertThrowsHiddenClassCastException(() -> Js.asAny("1").asBoolean());
    assertThrowsHiddenClassCastException(() -> Js.asAny("").asBoolean());
    assertThrowsHiddenClassCastException(() -> Js.asAny(null).asBoolean());
  }

  public void testCast() {
    assertThrowsClassCastException(
        () -> {
          String unused = Js.asAny(5).cast();
        });
  }

  @SuppressWarnings("TruthIncompatibleType")
  public void testUncheckedCast() {
    Double fakeNumber = Js.asAny("dangerous").uncheckedCast();
    assertThat(fakeNumber).isEqualTo("dangerous");
  }
}
