/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */

package io.itsusinn.extension.base64

import java.util.* // ktlint-disable no-wildcard-imports

private val decoder = Base64.getUrlDecoder()
private val encoder = Base64.getUrlEncoder()
val ByteArray.base64
   get() = encoder.encodeToString(this)
val String.base64
   get() = encoder.encodeToString(this.toByteArray())
val String.debase64: String?
   get() {
      try {
         return String(decoder.decode(this))
      } catch (_: Throwable) {
         return null
      }
   }
val ByteArray.debase64: String?
   get() {
      try {
         return String(decoder.decode(this))
      } catch (_: Throwable) {
         return null
      }
   }
