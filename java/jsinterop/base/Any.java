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
    javaemul.internal.InternalPreconditions.checkType(Js.typeof(this).equals("boolean"));
    return InternalJsUtil.asBoolean(this);
  }

  @JsOverlay
  default double asDouble() {
    javaemul.internal.InternalPreconditions.checkType(Js.typeof(this).equals("number"));
    return InternalJsUtil.asDouble(this);
  }

  @JsOverlay
  default float asFloat() {
    return (float) asDouble();
  }

  @JsOverlay
  default long asLong() {
    javaemul.internal.InternalPreconditions.checkType(InternalJsUtil.isLong(this));
    return InternalJsUtil.asLong(this);
  }

  @JsOverlay
  default int asInt() {
    double num = asDouble();
    javaemul.internal.InternalPreconditions.checkType(num == ((int) num));
    return InternalJsUtil.asInt(this);
  }

  @JsOverlay
  default short asShort() {
    double num = asDouble();
    javaemul.internal.InternalPreconditions.checkType(num == ((short) num));
    return InternalJsUtil.asShort(this);
  }

  @JsOverlay
  default char asChar() {
    double num = asDouble();
    javaemul.internal.InternalPreconditions.checkType(num == ((char) num));
    return InternalJsUtil.asChar(this);
  }

  @JsOverlay
  default byte asByte() {
    double num = asDouble();
    javaemul.internal.InternalPreconditions.checkType(num == ((byte) num));
    return InternalJsUtil.asByte(this);
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
