package exeption

class WrongOperationTypeException(val operation: String) :
    RuntimeException("Введен неизвестный тип операции: $operation")

class BadPropertyException : RuntimeException {
    constructor(badProperty: String) : super("Введено неверное значение параметра property: $badProperty")
    constructor(badProperty: Double) : super("Введено неверное значение параметра property: $badProperty")
}

class WrongFigureTypeException(figure: String) :
    RuntimeException("Введен неизвестный тип фигуры: $figure")
