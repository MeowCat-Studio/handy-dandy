/**
 * Copyright 2020-2021 Itsusinn and contributors.
 *
 * Licensed under the GNU Lesser General Public License version 3,
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *       https://opensource.org/licenses/LGPL-3.0
 */

package io.itsusinn.extension.runtime

val runtime = Runtime.getRuntime()

fun addShutdownHook(hook: Runnable) {
   runtime.addShutdownHook(Thread(hook))
}

fun exit(status: Int) {
   runtime.exit(status)
}
