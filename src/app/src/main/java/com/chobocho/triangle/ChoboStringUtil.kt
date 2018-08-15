package com.chobocho.triangle

class StringUtil {
    public fun removeZero(numString: String): String {
        var dot = numString.indexOf('.')
        if (dot == -1) {
            return numString
        }
        if (dot < 2) {
            dot = 2
        }
        var result = numString
        while (result.length > dot && result.endsWith("0")) {
            result = result.substring(0, result.length - 1)
        }

        if (result.endsWith(".")) {
            result = result.substring(0, result.length - 1)
        }
        return result
    }
}