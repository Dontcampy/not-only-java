package EffectiveJava.ej10

import java.lang.IllegalArgumentException

/**
 * @author sirius
 * @since 2019/05/09
 */

/**
 * A class override equals and without override hashCode
 */
class PhoneNumber(areaCode: Int, prefix: Int, lineNum: Int) {
    private val areaCode: Short
    private val prefix: Short
    private val lineNum: Short

    companion object {
        private fun rangeCheck(value: Int, max: Int, arg: String): Short {
            if (value < 0 || value > max)
                throw IllegalArgumentException("$arg: $value")
            return value.toShort()
        }
    }

    init {
        this.areaCode = rangeCheck(areaCode, 999, "area code")
        this.prefix = rangeCheck(prefix, 999, "prefix")
        this.lineNum = rangeCheck(lineNum, 9999, "line num")
    }

    override fun equals(other: Any?): Boolean {
        if (other == this)
            return true
        if (other !is PhoneNumber)
            return false
        return other.lineNum == lineNum && other.prefix == prefix && other.areaCode == areaCode
    }
}