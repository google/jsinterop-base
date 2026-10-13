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

import static java.lang.System.getProperty;

/**
 * A utility class that provides utility functions to do precondition checks following a pattern
 * similar to {@code javaemul.internal.InternalPreconditions}.
 */
public final class InternalPreconditions {

  private static final boolean IS_TYPE_CHECKED =
      getProperty("jsinterop.checks", "DISABLED") == "ENABLED";

  private static final boolean IS_ASSERTED = getProperty("jre.checkedMode") == "ENABLED";

  public static void checkType(boolean expression) {
    if (IS_TYPE_CHECKED) {
      checkCriticalType(expression);
    } else if (IS_ASSERTED) {
      try {
        checkCriticalType(expression);
      } catch (Exception e) {
        throw new AssertionError(e);
      }
    }
  }

  public static void checkCriticalType(boolean expression) {
    if (!expression) {
      throw new ClassCastException();
    }
  }

  public static void checkElementIndex(int index, int size) {
    if (IS_TYPE_CHECKED) {
      checkCriticalElementIndex(index, size);
    } else if (IS_ASSERTED) {
      try {
        checkCriticalElementIndex(index, size);
      } catch (Exception e) {
        throw new AssertionError(e);
      }
    }
  }

  private static void checkCriticalElementIndex(int index, int size) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
    }
  }

  // Hides the constructor for this static utility class.
  private InternalPreconditions() { }
}
