/**
 * @param {*} obj
 * @return {Object}
 * @public
 */
Js.cast = function(obj) {
  // TODO(goktug): Shouldn't be required when we move to * for JsUnsafeObject
  return /** @type {Object} */ (obj);
};


/**
 * @param {*} obj
 * @return {boolean}
 * @public
 */
Js.isFalsy = function(obj) {
  return !obj;
};

/**
 * @param {*} obj1
 * @param {*} obj2
 * @return {boolean}
 * @public
 */
Js.isTripleEqual = function(obj1, obj2) {
  return obj1 === obj2;
};
