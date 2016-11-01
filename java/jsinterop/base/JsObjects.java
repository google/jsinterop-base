/*
 * Copyright 2015 Google Inc.
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

/**
 * Utility methods around javascript object.
 *
 * <p>This class must not be referred directly. It will disappear in the next releases.
 */
class JsObjects {
  public static native <T> T get(ArrayLike<T> object, int key) /*-{
      return object[key];
  }-*/;

  public static native <T> T get(ObjectLike<T> object, String propertyName) /*-{
      return object[propertyName];
  }-*/;

  public static native <T> void set(ArrayLike<T> object, int key, T value) /*-{
      object[key] = value;
  }-*/;

  public static native <T> void set(ObjectLike<T> object, String propertyName, T value) /*-{
      object[propertyName] = value;
  }-*/;

  private JsObjects() {}
}
