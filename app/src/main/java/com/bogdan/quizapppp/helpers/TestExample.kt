package com.bogdan.quizapppp.helpers

import com.bogdan.quizapppp.model.Answer
import com.bogdan.quizapppp.model.Question
import com.bogdan.quizapppp.model.Test

var answer1 = Answer(
    isCorrect = false,
    text = "Вариант1"
)
var answer2 = Answer(
    isCorrect = true,
    text = "Вариант2"
)
var answer3 = Answer(
    isCorrect = false,
    text = "Вариант3"
)
var question1 = Question(
    text = "Какой?",
    answer = listOf(answer1, answer2, answer3)
)
///////////////////////////////////////////////////////////
var question2 = Question(
    text = "1, 2, 3?",
    answer = listOf(
        Answer(
            isCorrect = false,
            text = "Один"
        ),
        Answer(
            isCorrect = true,
            text = "Два"
        ),
        Answer(
            isCorrect = false,
            text = "Три"
        )
    )
)
///////////////////////////////////////////////////////////
var question3 = Question(
    text = "Сколько раз?",
    answer = listOf(
        Answer(
            isCorrect = false,
            text = "1"
        ),
        Answer(
            isCorrect = true,
            text = "2"
        ),
        Answer(
            isCorrect = false,
            text = "3"
        )
    )
)

val textExample = Test(
    score = 0,
    question = listOf(question1, question2, question3)
)