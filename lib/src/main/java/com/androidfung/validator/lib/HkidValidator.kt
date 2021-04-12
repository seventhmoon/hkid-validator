package com.androidfung.validator.lib

class HkidValidator {

    companion object {
        private val acceptedChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ "
        private val hkidRegex = Regex("[A-Z]{1,2}\\d{6}")

        @ExperimentalStdlibApi
        fun isValid(id: String, checksum: Char): Boolean {
            return try {
                calcCheckDigit(id) == checksum
            } catch (e: IllegalArgumentException) {
                false
            }
        }

        @ExperimentalStdlibApi
        fun calcCheckDigit(input: String): Char {
            if (input.matches(hkidRegex)) {
                val id = if (input.length == 7) " $input" else input
                val sum = id.mapIndexed { index, c ->
                    (9 - index) * acceptedChars.indexOf(c)
                }.sum()
                val checksum = ((11 - (sum % 11)) % 11)

                return checksum.digitToChar(16)
            } else throw IllegalArgumentException()
        }
    }
}