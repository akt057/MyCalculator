package com.example.mycalculator

import kotlin.time.Duration.Companion.milliseconds

fun calculateExpression(inputValueArgument: String): Int {
    if (inputValueArgument.isEmpty()){
        return 0
    }
    var result = 0
    if (doesInputValueHaveMultiplicationOrDivision(inputValueArgument)){
        var inputValue = changeOperationsOrder(inputValueArgument)
    }else{
        var inputValue =  inputValueArgument
    }



    return result
}

fun changeOperationsOrder(inputValue: String): String {

    var inputValueReformated = inputValue

    var prioritizedParts = mutableListOf<String>()

    if (
        inputValue.last() == '+' || inputValue.last() == '-' || inputValue.last() == '*' || inputValue.last() == '/'
        ){
        inputValueReformated = inputValueReformated.removeRange(inputValueReformated.lastIndex, inputValueReformated.lastIndex + 1)
    }

    if (inputValueReformated[0].isDigit()){
        inputValueReformated = "+$inputValueReformated"
    }

    var i = 0

    if (inputValueReformated[0].isDigit()){
        inputValueReformated = "+$inputValueReformated"
    }

    while (i < inputValue.lastIndex) {
        if (inputValue[i].toString() === "*" || inputValue[i].toString() === "/") {
            var startIndexOfElementToTransfer = i - 1
            while (startIndexOfElementToTransfer >= 0 && inputValueReformated[startIndexOfElementToTransfer].isDigit()){
                startIndexOfElementToTransfer--
            }
            if(startIndexOfElementToTransfer < 0){
                startIndexOfElementToTransfer = 0
            }else{
                startIndexOfElementToTransfer++
            }
            var lastIndexOfElementToTransfer = i + 1
            while (lastIndexOfElementToTransfer < inputValueReformated.length && inputValueReformated[lastIndexOfElementToTransfer].isDigit()){
                lastIndexOfElementToTransfer++
            }

            val elementToTransfer = inputValueReformated.substring(startIndexOfElementToTransfer..lastIndexOfElementToTransfer)

            prioritizedParts.add(elementToTransfer)

            inputValueReformated = inputValueReformated.removeRange(startIndexOfElementToTransfer..lastIndexOfElementToTransfer)
            i = 0
        }else{
            i++
        }
    }

    return prioritizedParts.joinToString("") + inputValueReformated
}


fun doesInputValueHaveMultiplicationOrDivision(inputValue: String): Boolean{
    var doesInputValueHaveMultiplicationOrDivision = false
    for (i in 0 .. inputValue.lastIndex){
        if (inputValue[i].toString()  === "+" || inputValue[i].toString()  === "-" || inputValue[i].toString()  === "*" || inputValue[i].toString()  === "/"){
            doesInputValueHaveMultiplicationOrDivision = true
        }
    }
    return doesInputValueHaveMultiplicationOrDivision
}