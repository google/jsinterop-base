/*
 * Copyright 2017 Google Inc.
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
 * This file provides the @defines for jsinterop configuration options.
 * See InternalPreconditions.java for details.
 */

goog.module('jsinterop');

const jre = goog.require('jre');

// Note that disabling checking only disables it for production.

/** @define {string} */
const checks = goog.define('jsinterop.checks', 'DISABLED');
jre.addSystemPropertyFromGoogDefine('jsinterop.checks', checks);

exports = {
  checks,
};
