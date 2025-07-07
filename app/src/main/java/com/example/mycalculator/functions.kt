package com.example.mycalculator

fun calculateExpression(inputValue: String): Int{
    var currentSymbol = ""
    var result = 0
    var allValues = mutableListOf<Int>()
    for (i in 0 .. inputValue.lastIndex){
        if (inputValue[i].isDigit()){
            currentSymbol += inputValue[i]
        }else if (inputValue[i].toString() === "+"){
            allValues.add(currentSymbol.toInt())
            currentSymbol = ""
            for(j in i..inputValue.lastIndex){
                if (inputValue[j].isDigit()){

                }
            }
        }
    }
    return result
}
