package EffectiveJava.ej13

import java.lang.AssertionError
import java.lang.IllegalArgumentException

/**
 * @author sirius
 * @since 2019/05/10
 */

/**
 * A good class
 */
class CloneablePhoneNumber(areaCode: Int, prefix: Int, lineNum: Int) : Cloneable {
    private val areaCode: Short
    private val prefix: Short
    private val lineNum: Short

    companion object {
        @Throws(IllegalArgumentException::class)
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

    @Throws(AssertionError::class)
    public override fun clone(): Any {
        try {
            return super.clone()
        } catch (e: CloneNotSupportedException) {
            throw AssertionError()
        }
    }
}

fun main() {

}