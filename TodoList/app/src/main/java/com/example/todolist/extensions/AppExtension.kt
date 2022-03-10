package com.example.todolist.extensions

import java.text.SimpleDateFormat
import java.util.*

private val locale = Locale("pt", "BR")

fun Date.format(): String{
    return java.text.SimpleDateFormat("dd/MM/yyyy", locale).format(this)
}

var TextImputLayout.text: String
    get() = editText?.text?.toString() ?: ""
    set(value){
        editText?.setText(value)
    }