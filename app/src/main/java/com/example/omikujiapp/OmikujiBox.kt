package com.example.omikujiapp

import java.util.*

class OmikujiBox {
    val number: Int
        get() {
            return Random().nextInt(20)
        }
}
