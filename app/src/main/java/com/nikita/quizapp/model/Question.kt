package com.nikita.quizapp.model

class Question(
    val text: String
) {

    val Answers: MutableList<Answer> = mutableListOf()

}