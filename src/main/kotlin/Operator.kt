/**
 * @author sirius
 * @since 2019/05/15
 */
class Demo

class DemoOperator {
    val demoMap = hashMapOf<(Class<out Demo>), Demo>()

    @Suppress("UNCHECKED_CAST")
    operator fun <T : Demo> get(clazz: Class<T>): T = requireNotNull(demoMap[clazz] as? T) {"gagaga"}
}

fun main() {
    val dp = DemoOperator()

    val demo: Demo = dp[Demo::class.java]
}