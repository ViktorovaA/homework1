package service.impl

import model.Circle
import model.Figure
import model.Square
import service.FigureService

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

    override fun getPerimeter(): List<Double> {
        val perimeter = mutableListOf<Double>()
        for (figure in figures) {
            if (figure is Circle) {
                perimeter.add(2 * kotlin.math.PI * figure.property)
            }
            if (figure is Square) {
                perimeter.add(figure.property * 4)
            }
        }
        return perimeter
    }

    override fun getArea(): List<Double> {
        val area = mutableListOf<Double>()
        for (figure in figures) {
            if (figure is Circle) {
                area.add(kotlin.math.PI * figure.property * figure.property)
            }
            if (figure is Square) {
                area.add(figure.property * figure.property)
            }
        }
        return area
    }
}
