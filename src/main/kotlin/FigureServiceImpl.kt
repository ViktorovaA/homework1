object FigureServiceImpl : FigureService {
    private val figures: MutableList<Figure> = mutableListOf()
    private var perimeter = 0.0
    private var area = 0.0

    override fun addSquare(property: Double) {
        figures.add(Square(property))

        perimeter += property * 4
        area += property * property
    }

    override fun addCircle(property: Double) {
        figures.add(Circle(property))

        perimeter += 2 * kotlin.math.PI * property
        area += kotlin.math.PI * property * property
    }

    override fun getPerimeter(): Double {
        return perimeter
    }

    override fun getArea(): Double {
        return area
    }
}
