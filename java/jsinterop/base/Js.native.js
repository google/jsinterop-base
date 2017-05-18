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

/**
 * @param {*} d
 * @return {number}
 * @public
 */
Js.coerceToDouble = function(d) {
  return +/** @type {?} */ (d);
};
