package service

import enums.Operation
import exeption.BadPropertyException
import exeption.WrongOperationTypeException

interface ConsoleService {
    fun work()

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
}
