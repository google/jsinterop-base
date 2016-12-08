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

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Provides abstraction for JavaScript array-like object of {@link Any}. */
@JsType(isNative = true, name = "IArrayLike", namespace = JsPackage.GLOBAL)
public interface JsArrayLikeOfAny extends JsArrayLike<Object> {
  @JsOverlay
  default void setAt(int index, float value) {
    InternalJsUtil.setAt(this, index, Any.of(value));
  }

  @JsOverlay
  default void setAt(int index, int value) {
    InternalJsUtil.setAt(this, index, Any.of(value));
  }

  @JsOverlay
  default void setAt(int index, long value) {
    InternalJsUtil.setAt(this, index, Any.of(value));
  }

  @JsOverlay
  default Any getAnyAt(int index) {
    return (Any) InternalJsUtil.getAt(this, index);
  }
}
