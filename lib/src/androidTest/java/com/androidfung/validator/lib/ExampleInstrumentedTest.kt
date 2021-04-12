package com.androidfung.validator.lib

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.androidfung.validator.lib.test", appContext.packageName)
    }

    @ExperimentalStdlibApi
    @Test
    fun hkidTest() {
        assert(HkidValidator.isValid("A123456", '3'))
        assertFalse(HkidValidator.isValid("A123456", '4'))

        assert(HkidValidator.isValid("A654321", '1'))
        assertFalse(HkidValidator.isValid("A654321", 'A'))

        assert(HkidValidator.isValid("ZA654321", 'A'))
        assertFalse(HkidValidator.isValid("ZA654321", '9'))

    }
}