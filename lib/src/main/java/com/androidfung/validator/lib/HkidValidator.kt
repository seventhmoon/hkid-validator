package com.androidfung.validator.lib

import java.lang.IllegalArgumentException

class HkidValidator {

    fun String.matchesHkidFormat(): Boolean{
        return this.matches(Regex("[A-Z]{1,2}\\d{6}"))
    }

    fun calcCheckDigit(input: String): Char {
        return if (input.matchesHkidFormat()) {
            var sum = 0;
            val id = if (input.length == 7) " $input" else input

            id.forEachIndexed { index, c ->
                sum += (9-index) * convertCharToMultiplier(c)
            }

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