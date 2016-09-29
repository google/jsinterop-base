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
public class JsObjects {
  public static native <T> T get(Object object, double key) /*-{
      return object[key];
  }-*/;

  public static native <T> T get(Object object, String propertyName) /*-{
      return object[propertyName];
  }-*/;

  private JsObjects() {}
}
