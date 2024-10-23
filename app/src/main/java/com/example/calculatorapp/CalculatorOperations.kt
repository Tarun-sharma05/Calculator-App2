package com.example.calculatorapp

sealed class CalculatorOperations(val symbol: String) {
    object Add: CalculatorOperations("+")
    object Subtraction: CalculatorOperations("-")
    object Multiplication: CalculatorOperations("X")
    object Devision: CalculatorOperations("/")

}