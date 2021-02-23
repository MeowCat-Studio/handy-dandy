/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */

package io.itsusinn.extension.test

fun timing(
   times: Int = 1,
   log: Boolean = true,
   block: () -> Unit,
): Long {
   val start = System.currentTimeMillis()
   for (i in 1..times) {
      block.invoke()
   }
   val end = System.currentTimeMillis()
   if (log) {
      println("""$block invoke $times times cost ${end - start}""")
   }
   return end - start
}
