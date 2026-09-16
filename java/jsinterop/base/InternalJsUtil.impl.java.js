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

goog.module('jsinterop.base.InternalJsUtil');

const JavaClass = goog.requireType('java.lang.Class');
const Long = goog.require('goog.math.Long');

class InternalJsUtil {
  /**
   * @return {!Object}
   * @public
   */
  static emptyObjectLiteral() {
    return {};
  }

  /**
   * @template T
   * @param {*} obj
   * @param {string|number} key
   * @return {T}
   * @public
   */
  static getIndexed(obj, key) {
    return obj[key];
  }

  /**
   * @param {*} obj
   * @param {string|number} key
   * @return {boolean}
   * @public
   */
  static hasIndexed(obj, key) {
    return key in obj;
  }

  /**
   * @param {*} obj
   * @param {string|number} key
   * @return {boolean}
   * @public
   */
  static deleteIndexed(obj, key) {
    return delete obj[key];
  }

  /**
   * @param {*} obj
   * @param {string|number} key
   * @param {*} value
   * @return {void}
   * @public
   */
  static setIndexed(obj, key, value) {
    obj[key] = value;
  }

  /**
   * @param {*} obj
   * @param {function(?string):void} cb
   * @return {void}
   * @public
   */
  static forEach(obj, cb) {
    for (let key in obj) {
      cb(key);
    }
  }

  /**
   * @template T
   * @param {*} obj
   * @return {T}
   * @public
   */
  static castToAny(obj) {
    return obj;
  }

  /**
   * @param {*} obj
   * @return {boolean}
   * @public
   */
  static isLong(obj) {
    return obj instanceof Long;
  }

  /**
   * @param {*} obj
   * @return {boolean}
   * @public
   */
  static isInt(obj) {
    return ( /** @type {?} */ (obj) | 0) === obj;
  }

  /**
   * @param {*} obj
   * @return {boolean}
   * @public
   */
  static hasLength(obj) {
    return typeof obj == 'object' && typeof obj.length == 'number';
  }

  /**
   * @param {!IArrayLike} obj
   * @return {number}
   * @public
   */
  static getLength(obj) {
    return obj.length;
  }

  /**
   * @param {!IArrayLike} obj
   * @param {number} length
   * @public
   */
  static setLength(obj, length) {
    obj.length = length;
  }

  /**
   * @param {!JavaClass<T>} clazz
   * @return {function(new:T)}
   * @template T
   * @public
   */
  static toCtor(clazz) {
    return /** @type {?} */ (clazz.f_ctor__java_lang_Class_);
  }
}

exports = InternalJsUtil;

