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

import javaemul.internal.annotations.UncheckedCast;
import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/**
 * Abstracts 'any' type in the type system (or '*' in Closure). This is the super type of all types
 * and provides helpers for casting into subtypes that are not otherwise castable (i.e. primitives).
 */
// TODO(goktug): name should be * here but GWT will not be happy.
@JsType(isNative = true, name = "Object", namespace = JsPackage.GLOBAL)
public interface Any {

  @JsOverlay
  public static Any of(Object obj) {
    return InternalJsUtil.castToAny(obj);
  }

  @JsOverlay
  public static Any of(float obj) {
    return InternalJsUtil.castToAny(obj);
  }

  @JsOverlay
  public static Any of(int obj) {
    return InternalJsUtil.castToAny(obj);
  }

  @JsOverlay
  public static Any of(long obj) {
    return InternalJsUtil.castToAny(obj);
  }

  @JsOverlay
  default boolean asBoolean() {
    return Js.castToBoolean(this);
  }

  @JsOverlay
  default double asDouble() {
    return Js.castToDouble(this);
  }

  @JsOverlay
  default float asFloat() {
    return Js.castToFloat(this);
  }

  @JsOverlay
  default long asLong() {
    return Js.castToLong(this);
  }

  @JsOverlay
  default int asInt() {
    return Js.castToInt(this);
  }

  @JsOverlay
  default short asShort() {
    return Js.castToShort(this);
  }

  @JsOverlay
  default char asChar() {
    return Js.castToChar(this);
  }

  @JsOverlay
  default byte asByte() {
    return Js.castToByte(this);
  }

  /**
   * Performs unchecked cast to lefthand-side type. You should always prefer regular casting over
   * this (unless you know what you are doing!).
   */
  @JsOverlay
  @UncheckedCast
  @SuppressWarnings({"TypeParameterUnusedInFormals", "unchecked"})
  default <T> T uncheckedCast() {
    return (T) this;
  }
}
