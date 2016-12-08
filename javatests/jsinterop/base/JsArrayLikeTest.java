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

public class JsArrayLikeTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  public void testGet() {
    JsArrayLike<Object> arrayLike = getArrayLikeOf("a", "b", "c");
    assertThat(arrayLike.getLength()).isEqualTo(3);
    assertThat(arrayLike.getAt(0)).isEqualTo("a");
    assertThat(arrayLike.getAt(1)).isEqualTo("b");
    assertThat(arrayLike.getAt(2)).isEqualTo("c");
  }

  public void testSet() {
    JsArrayLike<Object> arrayLike = getArrayLikeOf("a", "b", "c");
    arrayLike.setAt(1, "bb");
    assertThat(arrayLike.getAt(1)).isEqualTo("bb");
  }

  public void testSetAny() {
    JsArrayLikeOfAny arrayLike = getArrayLikeOf();
    arrayLike.setAt(0, 15.5d);
    arrayLike.setAt(1, 15.5f);
    arrayLike.setAt(2, 15L);
    arrayLike.setAt(3, 15);
    arrayLike.setAt(4, (short) 15);
    arrayLike.setAt(5, (char) 15);
    arrayLike.setAt(6, (byte) 15);
    arrayLike.setAt(7, true);

    assertThat(arrayLike.getAnyAt(0).asDouble()).isEqualTo(15.5);
    assertThat(arrayLike.getAnyAt(1).asDouble()).isEqualTo(15.5);
    assertThat(arrayLike.getAnyAt(2).asLong()).isEqualTo(15L);
    assertThat(arrayLike.getAnyAt(3).asInt()).isEqualTo(15);
    assertThat(arrayLike.getAnyAt(4).asShort()).isEqualTo(15);
    assertThat(arrayLike.getAnyAt(5).asChar()).isEqualTo(15);
    assertThat(arrayLike.getAnyAt(6).asByte()).isEqualTo(15);
    assertThat(arrayLike.getAnyAt(7).asBoolean()).isTrue();
  }

  public void testToArray() {
    JsArrayLike<Object> arrayLike = getArrayLikeOf("a", "b", "c");
    String all = "";
    int count = 0;
    for (Object o : arrayLike.asArray()) {
      all += o;
      count++;
    }
    assertThat(count).isEqualTo(3);
    assertThat(all).isEqualTo("abc");
  }

  private static JsArrayLikeOfAny getArrayLikeOf(Object... args) {
    return JsArrayLike.of(args);
  }
}
