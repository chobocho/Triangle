package com.chobocho.triangle

import org.junit.Test

import org.junit.Assert.*

class StringUtilTest {

    @Test
    fun removeZero() {
        val stringUtil = StringUtil()
        assertEquals(stringUtil.removeZero("3.00000"),"3")
        assertEquals(stringUtil.removeZero("3"),"3")
        assertNotEquals(stringUtil.removeZero("3.00001"),"3")
    }
}