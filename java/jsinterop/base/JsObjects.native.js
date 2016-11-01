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
 * @template T
 * @param {*} object
 * @param {number} key
 * @return T
 * @public
 */
JsObjects.m_get__java_lang_Object__int = function(object, key) {
  return object[key];
};

/**
 * @template T
 * @param {*} object
 * @param {string} propertyName
 * @return T
 * @public
 */
JsObjects.m_get__java_lang_Object__java_lang_String = function(
    object, propertyName) {
  return object[propertyName];
};

/**
 * @param {*} object
 * @param {number} key
 * @param {*} value
 * @public
 */
JsObjects.m_set__java_lang_Object__int__java_lang_Object = function(
    object, key, value) {
  object[key] = value;
};

/**
 * @param {*} object
 * @param {string} propertyName
 * @param {*} value
 * @public
 */
JsObjects.m_set__java_lang_Object__java_lang_String__java_lang_Object =
    function(object, propertyName, value) {
  object[propertyName] = value;
};
