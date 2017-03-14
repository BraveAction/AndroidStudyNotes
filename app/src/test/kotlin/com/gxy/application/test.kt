package com.gxy.application

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Gxy on 2017/1/18
 */
class test {
    @Test
    fun firstTest() {
        assertEquals(1, 1)
    }

    @Test
    fun testString() {
        var a = "123"
        var b = "123"
        assertEquals(a, b)
    }
}