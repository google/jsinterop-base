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

/** Provides abstraction of JavaScript objects as property maps. */
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public interface JsPropertyMap<T> {

  @JsOverlay
  static JsPropertyMapOfAny of() {
    return InternalJsUtil.emptyObjectLiteral();
  }

  @JsOverlay
  static JsPropertyMapOfAny of(String k, Object v) {
    JsPropertyMapOfAny map = of();
    map.set(k, v);
    return map;
  }

  @JsOverlay
  static JsPropertyMapOfAny of(String k1, Object v1, String k2, Object v2) {
    JsPropertyMapOfAny map = of();
    map.set(k1, v1);
    map.set(k2, v2);
    return map;
  }

  @JsOverlay
  static JsPropertyMapOfAny of(String k1, Object v1, String k2, Object v2, String k3, Object v3) {
    JsPropertyMapOfAny map = of();
    map.set(k1, v1);
    map.set(k2, v2);
    map.set(k3, v3);
    return map;
  }

  @JsOverlay
  static JsPropertyMapOfAny of(Object obj) {
    return (JsPropertyMapOfAny) obj;
  }

  @JsOverlay
  @SuppressWarnings("unchecked")
  default T get(String propertyName) {
    return (T) InternalJsUtil.get(this, propertyName);
  }

  @JsOverlay
  default boolean has(String propertyName) {
    return InternalJsUtil.has(this, propertyName);
  }

  @JsOverlay
  default void delete(String propertyName) {
    InternalJsUtil.delete(this, propertyName);
  }

  @JsOverlay
  default void set(String propertyName, T value) {
    InternalJsUtil.set(this, propertyName, value);
  }

  @JsOverlay
  default void forEach(JsForEachCallbackFn cb) {
    InternalJsUtil.forEach(this, cb);
  }
}
