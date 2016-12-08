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

import com.google.gwt.core.client.UnsafeNativeLong;
//J2CL_ONLY import jsinterop.annotations.JsMethod;

/** Utilities used internally to interact with native code. */
class InternalJsUtil {

  //J2CL_ONLY @JsMethod(name="getIndexed")
  public static native Object get(Object obj, String key) /*-{
    return obj[key];
  }-*/;

  //J2CL_ONLY @JsMethod(name="hasIndexed")
  public static native boolean has(Object obj, String key) /*-{
    return key in obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="deleteIndexed")
  public static native Object delete(Object obj, String key) /*-{
    delete obj[key];
  }-*/;

  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void set(Object obj, String key, Object value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents boxing of numbers.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void set(Object obj, String key, double value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents conversion of long to double.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  @UnsafeNativeLong
  public static native void set(Object obj, String key, long value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents conversion of int to long.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void set(Object obj, String key, int value) /*-{
    obj[key] = value;
  }-*/;

  //J2CL_ONLY @JsMethod(name="getIndexed")
  public static native Object getAt(Object obj, int key) /*-{
    return obj[key];
  }-*/;

  //J2CL_ONLY @JsMethod(name="hasIndexed")
  public static native boolean hasAt(Object obj, int key) /*-{
    return key in obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="deleteIndexed")
  public static native void deleteAt(Object obj, int key) /*-{
    delete obj[key];
  }-*/;

  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void setAt(Object obj, int key, Object value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents boxing of numbers.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void setAt(Object obj, int key, double value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents conversion of long to double.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  @UnsafeNativeLong
  public static native void setAt(Object obj, int key, long value) /*-{
    obj[key] = value;
  }-*/;

  // This overload prevents conversion of int to long.
  //J2CL_ONLY @JsMethod(name="setIndexed")
  public static native void setAt(Object obj, String key, int value) /*-{
    obj[key] = value;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native void forEach(Object obj, JsForEachCallbackFn cb) /*-{
    for (var element in obj) {
      cb(element);
    }
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native Any castToAny(Object obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native Any castToAny(float obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native Any castToAny(int obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod
  @UnsafeNativeLong
  public static native Any castToAny(long obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native boolean asBoolean(Object obj) /*-{
   return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native double asDouble(Object obj) /*-{
   return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native int asInt(Object obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native short asShort(Object obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native char asChar(Object obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native byte asByte(Object obj) /*-{
    return obj;
  }-*/;

  @UnsafeNativeLong
  //J2CL_ONLY @JsMethod(name="castToAny")
  public static native long asLong(Object obj) /*-{
    return obj;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native boolean isLong(Object obj) /*-{
    if (typeof obj == 'number') {
      return @com.google.gwt.lang.LongLib::isSafeIntegerRange(*)(obj) && Math.floor(obj) === obj;
    }
    if (typeof obj == 'object' && obj) {
      return "h" in obj && "l" in obj && "m" in obj;
    }
    return false;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native boolean hasLength(Object obj) /*-{
    return typeof obj == 'object' && typeof obj.length == 'number';
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native int getLength(Object obj) /*-{
    return obj.length;
  }-*/;

  //J2CL_ONLY @JsMethod
  public static native void setLength(Object obj, int length) /*-{
    return obj.length = length;
  }-*/;

  private InternalJsUtil() {} // Hide constructor for utility class.
}
