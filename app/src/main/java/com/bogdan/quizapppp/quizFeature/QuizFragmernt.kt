package com.bogdan.quizapppp.quizFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bogdan.quizapppp.R
import com.bogdan.quizapppp.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragmernt: Fragment() {
    @Inject
    lateinit var dataManager: DataManager
    var answer1: RadioButton?=null
    var answer2: RadioButton?=null
    var answer3: RadioButton?=null
    var questionText: TextView? =null
    var answerGroup: RadioGroup?=null
    var answerButton: Button?=null
    var currentIndex: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val welcomeLabel = view.findViewById<TextView>(R.id.hello_user)
        welcomeLabel.text = getString(R.string.welcome_user, dataManager.userName)

        answer1 = view.findViewById(R.id.variant1)
        answer2 = view.findViewById(R.id.variant2)
        answer3 = view.findViewById(R.id.variant3)
        questionText = view.findViewById(R.id.question_text)
        answerGroup = view.findViewById(R.id.radioGroup)
        answerButton = view.findViewById(R.id.answer_button)

        answerButton?.isEnabled = false
        answerButton?.setOnClickListener {

            val question = dataManager.test.question[currentIndex]
            val correctIndex = question.answer.indexOfFirst {
                it.isCorrect == true
            }
            if (correctIndex == 0){
                if(answer1?.isChecked == true){
                    dataManager.test.score += 1
                }
            } else if (correctIndex == 1){
                if(answer2?.isChecked == true){
                    dataManager.test.score += 1
                }
            } else if (correctIndex == 2){
                if(answer3?.isChecked == true){
                    dataManager.test.score += 1
                }
            }
            currentIndex++
            if (currentIndex <= 2){
                displayQuestion()
            }else{
                findNavController().navigate(R.id.action_quizFragmernt_to_resultFragment)
            }
            answerGroup?.clearCheck()
        }
        answer1?.setOnClickListener {
            answerButton?.isEnabled = true
        }
        answer2?.setOnClickListener {
            answerButton?.isEnabled = true
        }
        answer3?.setOnClickListener {
            answerButton?.isEnabled = true
        }
        displayQuestion()
    }
    private fun displayQuestion() {
        val question = dataManager.test.question[currentIndex]
        questionText?.text = question.text
        answer1?.text = question.answer[0].text
        answer2?.text = question.answer[1].text
        answer3?.text = question.answer[2].text

    }
}