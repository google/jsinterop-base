package jsinterop.base;

import jsinterop.annotations.JsPackage;
import jsinterop.annotations.JsType;

// TODO(b/33437732): remove
/** Place holder fot ArrayLike interface. Complete implementation will be provided later. */
@JsType(isNative = true, name = "IArrayLike", namespace = JsPackage.GLOBAL)
public interface ArrayLike<T> extends JsArrayLike<T> {}
