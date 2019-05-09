package EffectiveJava.ej11

import EffectiveJava.ej10.PhoneNumber
import java.lang.IllegalArgumentException

/**
 * @author sirius
 * @since 2019/05/09
 */

/**
 * This is a negative example. The PhoneNumber didn't override hashCode()
 */
fun negativeExample() {
    val m = hashMapOf<PhoneNumber, String>()
    m[PhoneNumber(707, 867, 5309)] = "Jenny"
    println(m[PhoneNumber(707, 867, 5309)])
}

/**
 * A good class
 */
class GoodPhoneNumber(areaCode: Int, prefix: Int, lineNum: Int) {
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
        if (other !is GoodPhoneNumber)
            return false
        return other.lineNum == lineNum && other.prefix == prefix && other.areaCode == areaCode
    }

    override fun hashCode(): Int {
        var result = areaCode.hashCode()
        result = 31 * result + prefix.hashCode()
        result = 31 * result + lineNum.hashCode()
        return result
    }
}

fun goodExample() {
    val m = hashMapOf<GoodPhoneNumber, String>()
    m[GoodPhoneNumber(707, 867, 5309)] = "Jenny"
    println(m[GoodPhoneNumber(707, 867, 5309)])
}

fun main() {
    negativeExample()
    goodExample()
}