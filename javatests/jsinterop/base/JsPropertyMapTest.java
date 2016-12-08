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

  public void testForEach() {
    JsPropertyMap o = JsPropertyMap.of(new NativeObject());
    o.set("foo", "");
    o.set("bar", "");

    StringBuilder result = new StringBuilder();
    o.forEach(t -> result.append(t));
    assertThat(result.toString()).isEqualTo("foobar");
  }
}
