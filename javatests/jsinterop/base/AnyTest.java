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

public class AnyTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  // would have been much nicer with JUnitParams... :/

  public void testAsDouble() {
    assertThat(Any.of(15.5d).asDouble()).isEqualTo(15.5d);
    assertThat(Any.of(15.5f).asDouble()).isEqualTo(15.5d);
    assertThat(Any.of(15).asDouble()).isEqualTo(15d);
    assertThat(Any.of((byte) 15).asDouble()).isEqualTo(15d);
    assertThat(Any.of((char) 15).asDouble()).isEqualTo(15d);
    assertThat(Any.of((short) 15).asDouble()).isEqualTo(15d);

    // GWT represents small longs as 'number'
    // assertThrowsClassCastException(() -> Any.of(15L).asDouble());
    assertThrowsClassCastException(() -> Any.of(new Object()).asDouble());
    assertThrowsClassCastException(() -> Any.of("1").asDouble());
    assertThrowsClassCastException(() -> Any.of("").asDouble());
    assertThrowsClassCastException(() -> Any.of(null).asDouble());
  }

  public void testAsFloat() {
    // Note: float is represented as number and double test alrready covers issues around
    // conversions to number.
    assertThat(Any.of(15.5f).asFloat()).isEqualTo(15.5f);
    assertThat(Any.of(15.5d).asFloat()).isEqualTo(15.5f);
  }

  public void testAsLong() {
    assertThat(Any.of(0L).asLong()).isEqualTo(0L);
    assertThat(Any.of(Long.MIN_VALUE).asLong()).isEqualTo(Long.MIN_VALUE);
    assertThat(Any.of(Long.MAX_VALUE).asLong()).isEqualTo(Long.MAX_VALUE);

    // GWT represents small longs as 'number'
    // assertThrowsClassCastException(() -> Any.of(15).asLong());
    assertThrowsClassCastException(() -> Any.of(15.5d).asLong());
    assertThrowsClassCastException(() -> Any.of(new Object()).asLong());
    assertThrowsClassCastException(() -> Any.of("1").asLong());
    assertThrowsClassCastException(() -> Any.of("").asLong());
    assertThrowsClassCastException(() -> Any.of(null).asLong());
  }

  public void testAsInt() {
    // Note: int is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Any.of(15).asInt()).isEqualTo(15);
    assertThat(Any.of(15d).asInt()).isEqualTo(15);

    assertThrowsClassCastException(() -> Any.of(15.5d).asInt());
  }

  public void testAsShort() {
    // Note: short is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Any.of(15).asShort()).isEqualTo(15);

    assertThrowsClassCastException(() -> Any.of(15.5d).asShort());
    assertThrowsClassCastException(() -> Any.of(Short.MAX_VALUE + 1).asShort());
  }

  public void testAsChar() {
    // Note: char is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Any.of(15).asChar()).isEqualTo(15);

    assertThrowsClassCastException(() -> Any.of(15.5d).asChar());
    assertThrowsClassCastException(() -> Any.of(Character.MAX_VALUE + 1).asChar());
  }

  public void testAsByte() {
    // Note: byte is represented as number and double test already covers issues around
    // conversions to number.
    assertThat(Any.of(15).asByte()).isEqualTo(15);

    assertThrowsClassCastException(() -> Any.of(15.5d).asByte());
    assertThrowsClassCastException(() -> Any.of(Byte.MAX_VALUE + 1).asByte());
  }

  public void testAsBoolean() {
    assertThat(Any.of(false).asBoolean()).isFalse();
    assertThat(Any.of(true).asBoolean()).isTrue();

    assertThrowsClassCastException(() -> Any.of(15.5d).asBoolean());
    assertThrowsClassCastException(() -> Any.of(15L).asBoolean());
    assertThrowsClassCastException(() -> Any.of(new Object()).asBoolean());
    assertThrowsClassCastException(() -> Any.of("1").asBoolean());
    assertThrowsClassCastException(() -> Any.of("").asBoolean());
    assertThrowsClassCastException(() -> Any.of(null).asBoolean());
  }

  public void testAsUnchecked() {
    Double fakeNumber = Any.of("dangerous").uncheckedCast();
    assertThat(fakeNumber).isEqualTo("dangerous");
  }

  private static void assertThrowsClassCastException(Runnable runnable) {
    try {
      runnable.run();
      fail("Exception not thrown");
    } catch (ClassCastException excepted) {
      // Expected.
    }
  }
}
