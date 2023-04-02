package com.nikita.quizapp.helpers

import com.nikita.quizapp.model.Answer
import com.nikita.quizapp.model.AnswerList
import com.nikita.quizapp.model.Question


val Question1 = Question("Столица Китая").apply {
    val Answer1 = Answer(
        "Токио", false)
    val Answer2 = Answer(
        "Пекин", true)
    val Answer3 = Answer(
        "Сиань", false)

    this.Answers.add(Answer1)
    this.Answers.add(Answer2)
    this.Answers.add(Answer3)
}
val Question2 = Question("Столица Казахстана").apply {
    val Answer1 = Answer(
        "Астана", true
    )
    val Answer2 = Answer(
        "Нур_Султан", false
    )
    val Answer3 = Answer(
        "Шимкент", false
    )

    this.Answers.add(Answer1)
    this.Answers.add(Answer2)
    this.Answers.add(Answer3)
}
val Question3 = Question("Столица Молдавии").apply {
    val Answer1 = Answer(
        "Кишинев", true
    )
    val Answer2 = Answer(
        "Кагул", false
    )
    val Answer3 = Answer(
        "Бельцы", false
    )

    this.Answers.add(Answer1)
    this.Answers.add(Answer2)
    this.Answers.add(Answer3)
}
val Question4 = Question("Дата начала ВОВ").apply {
    val Answer1 = Answer(
        "1941", true
    )
    val Answer2 = Answer(
        "1939", false
    )
    val Answer3 = Answer(
        "1914", false
    )
    this.Answers.add(Answer1)
    this.Answers.add(Answer2)
    this.Answers.add(Answer3)
}

val testExample = AnswerList().apply {
    this.QuestionList.add(Question1)
    this.QuestionList.add(Question2)
    this.QuestionList.add(Question3)
    this.QuestionList.add(Question4)
}

