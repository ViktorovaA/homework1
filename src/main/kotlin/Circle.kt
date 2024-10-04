// хотелось бы сделать data class, чтобы выводить строку "из коробки", но не разобралась
class Circle(property: Double) : Figure(property) {
    init {
        println(this.toString())
    }

    override fun toString(): String {
        return "Circle(property=$property)"
    }
}
