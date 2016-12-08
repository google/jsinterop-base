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
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

public class JsPropertyMapTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsType(isNative = true, namespace = JsPackage.GLOBAL, name = "Object")
  private static class NativeObject {}

  public void testOf() {
    JsPropertyMap.of(1d);
    JsPropertyMap.of("");
    JsPropertyMap.of(new NativeObject());
    JsPropertyMap.of(null); // JsPropertyMap.of is similar to casting so null should be accepted.
  }

  public void testSetGet() {
    JsPropertyMap o = JsPropertyMap.of(new NativeObject());
    assertThat(o.get("foo")).isNull();
    o.set("foo", "str");
    assertThat(o.get("foo")).isEqualTo("str");
  }

  public void testDeleteHas() {
    JsPropertyMap o = JsPropertyMap.of(new NativeObject());
    assertThat(o.has("foo")).isFalse();
    o.set("foo", null);
    assertThat(o.has("foo")).isTrue();
    o.delete("foo");
    assertThat(o.has("foo")).isFalse();
  }

  public void testSetGetAny() {
    JsPropertyMapOfAny o = JsPropertyMap.of(new NativeObject());
    o.set("p0", 15.5d);
    o.set("p1", 15.5f);
    o.set("p2", 15L);
    o.set("p3", 15);
    o.set("p4", (short) 15);
    o.set("p5", (char) 15);
    o.set("p6", (byte) 15);
    o.set("p7", true);

    assertThat(o.getAny("p0").asDouble()).isEqualTo(15.5);
    assertThat(o.getAny("p1").asDouble()).isEqualTo(15.5);
    assertThat(o.getAny("p2").asLong()).isEqualTo(15L);
    assertThat(o.getAny("p3").asInt()).isEqualTo(15);
    assertThat(o.getAny("p4").asShort()).isEqualTo(15);
    assertThat(o.getAny("p5").asChar()).isEqualTo(15);
    assertThat(o.getAny("p6").asByte()).isEqualTo(15);
    assertThat(o.getAny("p7").asBoolean()).isTrue();
  }
  public void testForEach() {
    JsPropertyMap o = JsPropertyMap.of(new NativeObject());
    o.set("foo", "");
    o.set("bar", "");

    StringBuilder result = new StringBuilder();
    o.forEach(t -> result.append(t));
    assertThat(result.toString()).isEqualTo("foobar");
  }
}
