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

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.List;
import javaemul.internal.annotations.DoNotAutobox;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;
import org.jspecify.annotations.Nullable;

/**
 * Provides abstraction for JavaScript array-like objects.
 *
 * <p>See {@link Js#asArrayLike(Object)} to cast an array-like object to {@code JsArrayLike}.
 */
@JsType(isNative = true, name = "IArrayLike", namespace = JsPackage.GLOBAL)
public interface JsArrayLike<T extends @Nullable Object> {

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
  default @Nullable T getAt(int index) {
    return (T) InternalJsUtil.getAt(this, index);
  }

  @JsOverlay
  default @Nullable Any getAtAsAny(int index) {
    return (Any) InternalJsUtil.getAt(this, index);
  }

  @JsOverlay
  default void setAt(int index, @DoNotAutobox T value) {
    InternalJsUtil.setAt(this, index, value);
  }

  /** Returns {@code true} unless the property is non-configurable and owned by object. */
  @CanIgnoreReturnValue
  @JsOverlay
  default boolean delete(int index) {
    return InternalJsUtil.deleteAt(this, index);
  }


  @JsOverlay
  default List<T> asList() {
    // Since it is hidden behind Arrays.asList, it is safe to do uncheckedCast.
    T[] asArray = Js.<T[]>uncheckedCast(this);
    return Arrays.asList(asArray);
  }
}
