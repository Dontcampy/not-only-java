package EffectiveJava.ej14

import EffectiveJava.ej10.PhoneNumber
import com.google.common.base.Objects
import java.lang.IllegalArgumentException
import java.math.BigDecimal
import java.util.*
import kotlin.Comparator

/**
 * @author sirius
 * @since 2019/05/15
 */
fun main() {
//    val s = sortedSetOf<String>()
//    val args = arrayOf("b", "c", "d", "d", "a")
//
//    s.addAll(args)
//    println(s)
//
//    val set = hashSetOf<BigDecimal>()
//    val treeSet = sortedSetOf<BigDecimal>()
//    val bd1 = BigDecimal("1.0")
//    val bd2 = BigDecimal("1.00")
//
//    set.add(bd1)
//    set.add(bd2)
//    println(set)
//
//    treeSet.add(bd1)
//    treeSet.add(bd2)
//    print(treeSet)
    val pn1 = CompareGoodPhoneNumber(1, 2, 3)
    val pn2 = CompareGoodPhoneNumber(1, 1, 6)
    println(pn1.compareTo(pn2))
}

class CaseInsensitiveString(private val s: String): Comparable<CaseInsensitiveString> {
    override fun compareTo(other: CaseInsensitiveString): Int {
        return String.CASE_INSENSITIVE_ORDER.compare(s, other.s)
    }
}

class CompareGoodPhoneNumber(areaCode: Int, prefix: Int, lineNum: Int): Comparable<CompareGoodPhoneNumber> {
    private val areaCode: Short
    private val prefix: Short
    private val lineNum: Short

    companion object {
        private fun rangeCheck(value: Int, max: Int, arg: String): Short {
            if (value < 0 || value > max)
                throw IllegalArgumentException("$arg: $value")
            return value.toShort()
        }

        private val COMPARATOR: Comparator<CompareGoodPhoneNumber> = compareBy(
            { it.areaCode },
            { it.prefix },
            { it.lineNum }
        )
    }

    init {
        this.areaCode = rangeCheck(areaCode, 999, "area code")
        this.prefix = rangeCheck(prefix, 999, "prefix")
        this.lineNum = rangeCheck(lineNum, 9999, "line num")
    }

    override fun equals(other: Any?): Boolean {
        if (other === this)
        // use "other == this" will result in a StackOverflowError, at kotlin.jvm.internal.Intrinsics.areEqual(Intrinsics.java:153)
        // https://kotlinlang.org/docs/reference/equality.html
            return true
        if (other !is CompareGoodPhoneNumber)
            return false
        return other.lineNum == lineNum && other.prefix == prefix && other.areaCode == areaCode
    }

//    override fun hashCode(): Int {
//        var result = areaCode.hashCode()
//        result = 31 * result + prefix.hashCode()
//        result = 31 * result + lineNum.hashCode()
//        return result
//    }
    /**
     * With Guava
     */
    private var hashCode: Int = 0

    override fun hashCode(): Int {
        // Lazy
        var result = hashCode
        if (result == 0) {
            result = Objects.hashCode(areaCode, prefix, lineNum)
        }
        return result
    }

    /**
     * Normal compare
     */
//    override fun compareTo(other: CompareGoodPhoneNumber): Int {
//        var result = areaCode.compareTo(other.areaCode)
//        if (result == 0) {
//            result = prefix.compareTo(other.prefix)
//            if (result == 0) {
//                result = lineNum.compareTo(other.lineNum)
//            }
//        }
//        return result
//    }

    /**
     * Use comparator
     */
    override fun compareTo(other: CompareGoodPhoneNumber): Int {
        return COMPARATOR.compare(this, other)
    }
}
