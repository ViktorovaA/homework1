class WrongOperationTypeException(val operation: String) :
    Exception("Введен неизвестный тип операции: $operation")

class BadPropertyException : Exception {
    constructor(badProperty: String) : super("Введено неверное значение параметра property: $badProperty")
    constructor(badProperty: Double) : super("Введено неверное значение параметра property: $badProperty")
}
