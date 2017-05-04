/*
 * Copyright 2017 Google Inc.
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
import jsinterop.annotations.JsType;

public class JsConstructorFnTest extends GWTTestCase {

  @Override
  public String getModuleName() {
    return "jsinterop.base.TestModule";
  }

  @JsType
  public static class Abc {
    private final int param;
    public Abc(int param) {
      this.param = param;
    }
  }

  public void testJsConstructorFn() {
    JsConstructorFn<Abc> ctor = Js.asConstructorFn(Abc.class);
    // Casting to Object to get the correct overload (due to b/30126552).
    assertThat((Object) ctor.asClass()).isSameAs(Abc.class);
    assertThat(ctor.construct(42).param).isEqualTo(42);

    // TODO(b/36232750): Fix following after JsConstructor classes are marked in J2CL.
    // assertThrowsHiddenClassCastException(() -> JsConstructorFn.of(Object.class));
    // assertThrowsHiddenClassCastException(() -> JsConstructorFn.of(String.class));
  }
}
