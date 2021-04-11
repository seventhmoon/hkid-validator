package com.androidfung.validator.lib

class HkidValidator {

    private val acceptedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ "
    private val hkidRegex = Regex("[A-Z]{1,2}\\d{6}")

    @ExperimentalStdlibApi
    fun calcCheckDigit(input: String): Char {
        return if (input.matches(hkidRegex)) {
            val id = if (input.length == 7) " $input" else input
            val sum = id.mapIndexed { index, c ->
                (9 - index) * c.toMultiplier()
            }.sum()

            val checksum = (11 - (sum % 11) % 11)
            checksum.digitToChar(16)

        } else throw IllegalArgumentException()
    }

    private fun Char.toMultiplier(): Int {
        return acceptedChars.indexOf(this, ignoreCase = true)
    }
}