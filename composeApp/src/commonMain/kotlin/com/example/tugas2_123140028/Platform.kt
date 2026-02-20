package com.example.tugas2_123140028

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform