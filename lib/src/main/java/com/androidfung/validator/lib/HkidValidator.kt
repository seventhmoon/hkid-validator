package com.androidfung.validator.lib

class HkidValidator {

    fun String.matchesHkidFormat(): Boolean {
        return this.matches(Regex("[A-Z]{1,2}\\d{6}"))
    }

    fun calcCheckDigit(input: String): Char {
        return if (input.matchesHkidFormat()) {
            val id = if (input.length == 7) " $input" else input
            val sum = id.mapIndexed { index, c ->
                (9 - index) * convertCharToMultiplier(c)
            }.sum()

            when (val reminder = sum % 11) {
                0 -> '0'
                1 -> 'A'
                else -> '0' + (11 - reminder)
            }
        } else throw IllegalArgumentException()
    }

    private fun convertCharToMultiplier(c: Char): Int {
        val m = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ "
        return m.indexOf(c, ignoreCase = true)
    }
}