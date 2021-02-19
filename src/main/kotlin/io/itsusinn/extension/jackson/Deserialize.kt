/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */

package io.itsusinn.extension.jackson

/**
 * Method to deserialize JSON content from given JSON content String.
 *
 * @throws JsonParseException if underlying input contains invalid content
 *    of type {@link JsonParser} supports (JSON for default case)
 * @throws JsonMappingException if the input JSON structure does not match structure
 *   expected for result type (or has other mismatch issues)
 */
inline fun <reified T> readValue(src: String): T? {
   try {
      return reader.readValue(src, T::class.java)
   } catch (e: Exception) {
      jacksonLogger.error(e) { e.stackTrace }
      return null
   }
}
inline fun <reified T> readValueOrFail(src: String): T = reader.readValue(src, T::class.java)

inline fun <reified T> readValue(src: ByteArray): T? {
   try {
      return reader.readValue(src, T::class.java)
   } catch (e: Exception) {
      jacksonLogger.error(e) { e.stackTrace }
      return null
   }
}
inline fun <reified T> readValueOrFail(src: ByteArray): T = reader.readValue(src, T::class.java)
