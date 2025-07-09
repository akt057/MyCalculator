package com.example.mycalculator



fun calculateExpression(inputValueArgument: String): Double {
    var currentNumber = ""
    var currentOperation = '+'
    var result = 0.0
    if (inputValueArgument.isEmpty()) return result

    val inputValue = if (doesInputValueHaveMultiplicationOrDivision(inputValueArgument)) {
        changeOperationsOrder(inputValueArgument)
    } else {
        inputValueArgument
    }

    for (i in inputValue.indices) {
        val c = inputValue[i]

        if (c.isDigit() || c == '.') {
            currentNumber += c
        }

        val isLastChar = i == inputValue.lastIndex

        if (!c.isDigit() && c != '.' || isLastChar) {
            if (currentNumber.isNotEmpty()) {
                val num = currentNumber.toDouble()
                when (currentOperation) {
                    '+' -> result += num
                    '-' -> result -= num
                    '*' -> result *= num
                    '/' -> result /= num
                }
                currentNumber = ""
            }

            if (!c.isDigit() && c != '.') {
                currentOperation = c
            }
        }
    }

    if (currentNumber.isNotEmpty()) {
        val num = currentNumber.toDouble()
        when (currentOperation) {
            '+' -> result += num
            '-' -> result -= num
            '*' -> result *= num
            '/' -> result /= num
        }
    }

    return result
}



fun changeOperationsOrder(inputValue: String): String {
    var expression = inputValue
    var i = 0

    while (i < expression.length) {
        if (expression[i] == '*' || expression[i] == '/') {

            var leftStart = i - 1
            while (leftStart >= 0 && expression[leftStart].isDigit()) {
                leftStart--
            }
            leftStart++

            val left = expression.substring(leftStart, i).toDouble()

            var rightEnd = i + 1
            while (rightEnd < expression.length && expression[rightEnd].isDigit()) {
                rightEnd++
            }

            val right = expression.substring(i + 1, rightEnd).toDouble()

            val result = if (expression[i] == '*') {
                left * right
            } else {
                if (right == 0.0) return "0"
                left / right
            }

            expression = expression.replaceRange(leftStart, rightEnd, result.toString())

            i = 0
        } else {
            i++
        }
    }

    return expression
}
//


fun doesInputValueHaveMultiplicationOrDivision(inputValue: String): Boolean{
    var doesInputValueHaveMultiplicationOrDivision = false
    for (i in 0 .. inputValue.lastIndex){
        if (inputValue[i].toString()  == "+" || inputValue[i].toString()  == "-" || inputValue[i].toString()  == "*" || inputValue[i].toString()  == "/"){
            doesInputValueHaveMultiplicationOrDivision = true
        }
    }
    return doesInputValueHaveMultiplicationOrDivision
}