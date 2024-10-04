
fun getOperation(operation: String): Operation {
    return when (operation) {
        "1", "1)" -> Operation.INSERT
        "2", "2)" -> Operation.GET_AREA
        "3", "3)" -> Operation.GET_PERIMETER
        "4", "4)" -> Operation.EXIT
        else -> throw WrongOperationTypeException(operation)
    }
}

fun getProperty(): Double {
    val propertyStr = readln()
    val property = propertyStr.toDoubleOrNull() ?: throw BadPropertyException(propertyStr)
    if (property <= 0) throw BadPropertyException(property)
    return property
}

object ConsoleServiceImpl : ConsoleService {
    val figureService: FigureServiceImpl = FigureServiceImpl

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
        println("Суммарный периметр всех фигур - ${figureService.getPerimeter()}")
    }

    private fun getArea() {
        println("Суммарная площадь всех фигур - ${figureService.getArea()}")
    }

    private fun addFigure() {
        println("Введите тип фигуры, которую хотите добавить:\n1) круг\n2) квадрат")
        when (readln()) {
            "1", "1)" -> {
                println("Введите радиус круга")
                figureService.addCircle(getProperty())
            }
            "2", "2)" -> {
                println("Введите сторону квадрата")
                figureService.addSquare(getProperty())
            }
            else -> println("Неизвестный тип. Попробуйте еще раз")
        }
    }
}
