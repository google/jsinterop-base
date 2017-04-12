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

import static jsinterop.base.InternalPreconditions.checkType;

import javaemul.internal.annotations.HasNoSideEffects;
import javaemul.internal.annotations.UncheckedCast;
import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsProperty;

/**
 * Utilities to provide access to JavaScript language constructs that are not available in pure
 * Java.
 *
 * <p>Note that this class avoids providing replacements for stuff that is already available via a
 * pure Java or Elemental and enforce safe (runtime-checked) coding practices.
 */
public final class Js {
  @JsProperty(namespace = "<window>", name = "undefined")
  public static native Object undefined();

  @JsProperty(namespace = "<window>", name = "arguments")
  public static native JsArrayLike<Object> arguments();

  @JsProperty(namespace = "<window>", name = "debugger")
  public static native void debugger();

  @JsMethod(namespace = "<window>")
  @HasNoSideEffects
  public static native String typeof(Object obj);

  public static Any[] castToArray(Object obj) {
    checkType(obj instanceof Any[]);
    return uncheckedCast(obj);
  }

  @SuppressWarnings("ReferenceEquality") // GWT is not good at optimizing equals
  public static String castToString(Object obj) {
    checkType(Js.typeof(obj) == "string");
    return uncheckedCast(obj);
  }

  @SuppressWarnings("ReferenceEquality") // GWT is not good at optimizing equals
  public static boolean castToBoolean(Object obj) {
    checkType(Js.typeof(obj) == "boolean");
    return InternalJsUtil.asBoolean(obj);
  }

  @SuppressWarnings("ReferenceEquality") // GWT is not good at optimizing equals
  public static double castToDouble(Object obj) {
    checkType(Js.typeof(obj) == "number");
    return InternalJsUtil.asDouble(obj);
  }

  public static float castToFloat(Object obj) {
    return (float) castToDouble(obj);
  }

  public static long castToLong(Object obj) {
    checkType(InternalJsUtil.isLong(obj));
    return InternalJsUtil.asLong(obj);
  }

  public static int castToInt(Object obj) {
    checkType(InternalJsUtil.isInt(obj));
    return InternalJsUtil.asInt(obj);
  }

  public static short castToShort(Object obj) {
    int num = castToInt(obj);
    checkType(num == ((short) num));
    return InternalJsUtil.asShort(obj);
  }

  public static char castToChar(Object obj) {
    int num = castToInt(obj);
    checkType(num == ((char) num));
    return InternalJsUtil.asChar(obj);
  }

  public static byte castToByte(Object obj) {
    int num = castToInt(obj);
    checkType(num == ((byte) num));
    return InternalJsUtil.asByte(obj);
  }

  /**
   * Performs checked cast to lefthand-side type. This is useful for cases when Java won't allow you
   * otherwise, like casting from a native interface to a final Java type (like String).
   */
  @SuppressWarnings({"TypeParameterUnusedInFormals", "unchecked"})
  public static <T> T cast(Object obj) {
    return (T) obj;
  }

  /**
   * Performs unchecked cast to lefthand-side type. You should always prefer regular casting over
   * this (unless you know what you are doing!).
   */
  @UncheckedCast
  @SuppressWarnings({"TypeParameterUnusedInFormals", "unchecked"})
  public static <T> T uncheckedCast(Object obj) {
    return (T) obj;
  }

  public static boolean isTruthy(Object obj) {
    return !isFalsy(obj);
  }

  //J2CL_ONLY @JsMethod
  @HasNoSideEffects
  public static native boolean isFalsy(Object obj) /*-{
    return !obj;
  }-*/;

  /**
   * Returns {@code true} if two objects are same.
   *
   * <p>This method mostly behaves similar to Java {@code ==} operator except that it doesn't return
   * {@code true} for {@code null==undefined} comparison.
   */
  //J2CL_ONLY @JsMethod
  @HasNoSideEffects
  public static native boolean isTripleEqual(Object o1, Object o2) /*-{
    return o1 === o2;
  }-*/;

  private Js() {} // Hide constructor for utility class.
}
