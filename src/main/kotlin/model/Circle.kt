package model

// хотелось бы сделать data class, чтобы выводить строку "из коробки", но не разобралась
data class Circle(override val property: Double) : Figure() {
    init {
        println(this)
    }
}
