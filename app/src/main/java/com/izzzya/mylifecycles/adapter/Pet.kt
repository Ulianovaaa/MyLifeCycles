package com.izzzya.mylifecycles.adapter

import java.time.LocalDate

data class Pet(
    val name: String,
    val birth: LocalDate,
    val death: LocalDate?,
    val img: Int
)
