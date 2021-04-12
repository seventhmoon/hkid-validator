package com.androidfung.validator.lib

import kotlin.math.ceil

class HkidValidator {
    private val acceptedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ "
    private val hkidRegex = Regex("[A-Z]{1,2}\\d{6}")

    @ExperimentalStdlibApi
    fun calcCheckDigit(input: String): Char {
        if (input.matches(hkidRegex)) {
            val id = if (input.length == 7) " $input" else input
            val sum = id.mapIndexed { index, c ->
                (9 - index) * acceptedChars.indexOf(c)
            }.sum()

            val checksum = (11 * ceil(sum / 11.0).toInt() - sum)

            return checksum.digitToChar(16)

        } else throw IllegalArgumentException()
    }
}