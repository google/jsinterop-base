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

const javaLangClass = goog.requireType('java.lang.Class');

/**
 * @param {javaLangClass<T>} clazz
 * @return {function(new:T)}
 * @template T
 * @public
 */
InternalJsUtil.toCtor = function(clazz) {
  return /** @type {?} */ (clazz.f_ctor__java_lang_Class_);
};
