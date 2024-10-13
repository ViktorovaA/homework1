package model

data class Square(override val property: Double) : Figure() {
    init {
        println(this)
    }
}
