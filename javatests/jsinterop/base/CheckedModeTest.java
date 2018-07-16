/*
 * Copyright 2018 Google Inc.
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

import static jsinterop.base.ExceptionAssert.assertThrowsClassCastException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class CheckedModeTest {
  @Test
  public void testThrowClassCastException() throws Exception {
    assertThrowsClassCastException(() -> Js.asArrayLike(5));
    assertThrowsClassCastException(() -> Js.asDouble(new Object()));
    assertThrowsClassCastException(() -> Js.asInt(15.5d));
  }
}
