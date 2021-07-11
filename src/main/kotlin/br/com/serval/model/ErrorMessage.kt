package br.com.serval.model

data class ErrorMessage(val statusCode: Int, val reason: String, val messages: List<String>)