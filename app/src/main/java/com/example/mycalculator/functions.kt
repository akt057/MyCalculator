package com.example.mycalculator

fun calculateExpression(inputValueArgument: String): Int {
    var result = 0
    mutableListOf<Int>()
    var inputValue = inputValueArgument

    if (inputValue[0].isDigit()) {
        inputValue = "+$inputValue"
    }




    return result
}

fun changeOperationsOrder(inputValue: String): String {

    var inputValueReformated = inputValue

    var i = 0

    if (inputValueReformated[0].isDigit()){
        inputValueReformated = "+$inputValueReformated"
    }

    while (i < inputValue.lastIndex) {
        if (inputValue[i].toString() === "*" || inputValue[i].toString() === "/") {
            var startIndexOfElementToTransfer = i - 1
            for (j in i downTo 0) {
                if (inputValue[j].toString() === "+" || inputValue[j].toString() === "-") {
                    startIndexOfElementToTransfer = j
                    break
                }else if(j == 0){
                    i++
                    startIndexOfElementToTransfer = j
                    break
                }
            }
            if(startIndexOfElementToTransfer === 0){
                continue
            }
            var lastIndexOfElementToTransfer = i + 1
            for (j in i..inputValue.lastIndex) {
                if (inputValue[j].toString() === "+" || inputValue[j].toString() === "-") {
                    lastIndexOfElementToTransfer = j - 1
                    break
                }
            }
            val elementToTransfer = inputValue.substring(startIndexOfElementToTransfer..lastIndexOfElementToTransfer)
            inputValueReformated = inputValueReformated.removeRange(startIndexOfElementToTransfer..lastIndexOfElementToTransfer)
            inputValueReformated = elementToTransfer + inputValueReformated
        }
        i++
    }

    return inputValueReformated
}


