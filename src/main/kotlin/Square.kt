class Square(property: Double) : Figure(property) {
    init {
        println(this.toString())
    }

    override fun toString(): String {
        return "Square(property=$property)"
    }
}
