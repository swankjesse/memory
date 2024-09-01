package com.publicobject.gators

import android.os.Build

class AndroidPlatform : Platform {
}

actual fun getPlatform(): Platform = AndroidPlatform()
