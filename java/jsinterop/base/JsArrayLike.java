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

/** Provides abstraction for JavaScript array-like objects. */
@JsType(isNative = true, name = "IArrayLike", namespace = JsPackage.GLOBAL)
public interface JsArrayLike<T> {

  @JsOverlay
  static JsArrayLike<Object> of(Object obj) {
    // TODO(goktug): check length property and maybe others (see closure)
    @SuppressWarnings("unchecked")
    JsArrayLike<Object> arrayLike = (JsArrayLike) obj;
    return arrayLike;
  }

  @JsOverlay
  default int getLength() {
    return InternalJsUtil.getLength(this);
  }

  @JsOverlay
  default void setLength(int length) {
    InternalJsUtil.setLength(this, length);
  }

  @JsOverlay
  @SuppressWarnings("unchecked")
  default T getAt(int index) {
    return (T) InternalJsUtil.getAt(this, index);
  }

  @JsOverlay
  default void setAt(int index, T value) {
    InternalJsUtil.setAt(this, index, value);
  }

  @JsOverlay
  default T[] asArray() {
    // It is 'mostly' safe since there will be a real cast at the erasure call site when the
    // elements are accessed.
    return Any.of(this).uncheckedCast();
  }
}
