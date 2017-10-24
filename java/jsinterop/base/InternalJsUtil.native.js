/**
 * @return {Object}
 * @public
 */
InternalJsUtil.emptyObjectLiteral = function() {
  return {};
};

/**
 * @template T
 * @param {*} obj
 * @param {string|number} key
 * @return {T}
 * @public
 */
InternalJsUtil.getIndexed = function(obj, key) {
  return obj[key];
};

/**
 * @param {*} obj
 * @param {string|number} key
 * @return {boolean}
 * @public
 */
InternalJsUtil.hasIndexed = function(obj, key) {
  return key in obj;
};

/**
 * @param {*} obj
 * @param {string|number} key
 * @return {void}
 * @public
 */
InternalJsUtil.deleteIndexed = function(obj, key) {
  delete obj[key];
};

/**
 * @param {*} obj
 * @param {string|number} key
 * @param {*} value
 * @return {void}
 * @public
 */
InternalJsUtil.setIndexed = function(obj, key, value) {
  obj[key] = value;
};


/**
 * @param {*} obj
 * @param {function(?string):void} cb
 * @return {void}
 * @public
 */
InternalJsUtil.forEach = function(obj, cb) {
  for (let key in obj) {
    cb(key);
  }
};

/**
 * @template T
 * @param {*} obj
 * @return {T}
 * @public
 */
InternalJsUtil.castToAny = function(obj) {
  return obj;
};

const $Long_ = goog.require('nativebootstrap.Long');

/**
 * @param {*} obj
 * @return {boolean}
 * @public
 */
InternalJsUtil.isLong = function(obj) {
  return obj instanceof $Long_;
};

/**
 * @param {*} obj
 * @return {boolean}
 * @public
 */
InternalJsUtil.isInt = function(obj) {
  return ( /** @type {?} */ (obj) | 0) === obj;
};

/**
 * @param {*} obj
 * @return {boolean}
 * @public
 */
InternalJsUtil.hasLength = function(obj) {
  return typeof obj == 'object' && typeof obj.length == 'number';
};

/**
 * @param {IArrayLike} obj
 * @return {number}
 * @public
 */
InternalJsUtil.getLength = function(obj) {
  return obj.length;
};

/**
 * @param {IArrayLike} obj
 * @param {number} length
 * @public
 */
InternalJsUtil.setLength = function(obj, length) {
  obj.length = length;
};

var Class = goog.forwardDeclare("java.lang.Class");

/**
 * @param {Class<T>} clazz
 * @return {function(new:T)}
 * @template T
 * @public
 */
InternalJsUtil.toCtor = function(clazz) {
  return /** @type {?} */ (clazz.f_ctor__java_lang_Class_);
};
