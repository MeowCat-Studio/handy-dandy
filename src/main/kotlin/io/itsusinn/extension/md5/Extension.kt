/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */

@file:Suppress("EXPERIMENTAL_API_USAGE")
package io.itsusinn.extension.md5

import java.security.MessageDigest

val String.md5
   get() = run {
      val digest = MessageDigest.getInstance("MD5")
      digest.update(this.toByteArray())
      digest.digest()
   }
