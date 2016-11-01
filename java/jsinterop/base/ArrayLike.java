package jsinterop.base;

import jsinterop.annotations.JsOverlay;
import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

/** Place holder fot ArrayLike interface. Complete implementation will be provided later. */
@JsType(isNative = true, name = "IArrayLike", namespace = JsPackage.GLOBAL)
public interface ArrayLike<T> {
  @JsOverlay
  default T getAt(int index) {
    return JsObjects.get(this, index);
  }

  @JsOverlay
  default void setAt(int index, T value) {
    JsObjects.set(this, index, value);
  }
}
