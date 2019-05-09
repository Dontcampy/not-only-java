package EffectiveJava.ej2

/**
 * @author sirius
 * @since 2019/04/28
 */
class Car(builder: Builder) {
    private var brand: String
    private var name: String
    private var color: String

    class Builder constructor(val brand: String) {
        var name = ""
        var color = ""

        fun name(name:String): Builder = apply { this.name = name }

        fun color(color:String): Builder = apply { this.color = color }

        fun build(): Car = Car(this)

    }

    init {
        this.brand = builder.brand
        this.name = builder.name
        this.color = builder.color
    }

    override fun toString(): String {
        return "EJ1.Car(brand='$brand', name='$name', color='$color')"
    }


}

fun main() {
    val car = Car.Builder("Honda").name("AE86").color("Red").build()
    println(car)
}