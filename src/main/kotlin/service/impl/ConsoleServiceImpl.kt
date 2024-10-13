package service.impl

import enums.Operation
import exeption.BadPropertyException
import exeption.WrongFigureTypeException
import exeption.WrongOperationTypeException
import service.ConsoleService

object ConsoleServiceImpl : ConsoleService {
    override fun work() {
        while (true) {
            println(
                "Введите тип операции, которую хотите исполнить:\n1) добавить фигуру\n2) получить площадь всех" +
                    " фигур\n3) получить периметр всех фигур\n4) завершить выполнение",
            )
            try {
                when (getOperation(readln())) {
                    Operation.INSERT -> addFigure()
                    Operation.GET_AREA -> getArea()
                    Operation.GET_PERIMETER -> getPerimiter()
                    Operation.EXIT -> break
                }
            } catch (e: WrongOperationTypeException) {
                println(e.message)
            } catch (e: BadPropertyException) {
                println(e.message)
            }
        }
    }

    private fun getPerimiter() {
        println("периметры фигур:")
        for ((index, perimeter) in FigureServiceImpl.getPerimeter().withIndex()) {
            println("Фигура ${index + 1}) $perimeter")
        }
    }

    private fun getArea() {
        println("площади фигур:")
        for ((index, area) in FigureServiceImpl.getArea().withIndex()) {
            println("Фигура ${index + 1}) $area")
        }
    }

    private fun addFigure() {
        println("Введите тип фигуры, которую хотите добавить:\n1) круг\n2) квадрат")
        when (val figure = readln()) {
            "1", "1)" -> {
                println("Введите радиус круга")
                FigureServiceImpl.addCircle(getProperty())
            }
            "2", "2)" -> {
                println("Введите сторону квадрата")
                FigureServiceImpl.addSquare(getProperty())
            }
            else -> throw WrongFigureTypeException(figure)
        }
    }
}
