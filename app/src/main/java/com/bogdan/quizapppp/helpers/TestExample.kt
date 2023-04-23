package com.bogdan.quizapppp.helpers

import com.bogdan.quizapppp.model.Answer
import com.bogdan.quizapppp.model.Question
import com.bogdan.quizapppp.model.Test

var answer1 = Answer(
    isCorrect = true,
    text = "Сакура"
)
var answer2 = Answer(
    isCorrect = false,
    text = "Гортензия"
)
var answer3 = Answer(
    isCorrect = false,
    text = "Ликорис"
)
var question1 = Question(
    text = "Какой национальный цветок Японии?",
    answer = listOf(answer1, answer2, answer3)
)
///////////////////////////////////////////////////////////
var question2 = Question(
    text = "Сколько полос на флаге США?",
    answer = listOf(
        Answer(
            isCorrect = false,
            text = "12"
        ),
        Answer(
            isCorrect = true,
            text = "13"
        ),
        Answer(
            isCorrect = false,
            text = "14"
        )
    )
)
///////////////////////////////////////////////////////////
var question3 = Question(
    text = "Где находится самая маленькая кость в теле человека?",
    answer = listOf(
        Answer(
            isCorrect = false,
            text = "Кисть руки"
        ),
        Answer(
            isCorrect = false,
            text = "Стопа"
        ),
        Answer(
            isCorrect = true,
            text = "Ухо"
        )
    )
)

val textExample = Test(
    score = 0,
    question = listOf(question1, question2, question3)
)