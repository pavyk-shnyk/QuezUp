package com.nikita.quizapp.quizFeature

import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nikita.quizapp.R
import com.nikita.quizapp.helpers.DataManager
import com.nikita.quizapp.helpers.testExample
import com.nikita.quizapp.model.Question
import dagger.hilt.android.AndroidEntryPoint
import javax.annotation.meta.When
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var Datamanager: DataManager
    private var currentIndex = 0
    private var variantGroup: RadioGroup? = null
    private var Variant1: RadioButton? = null
    private var Variant2: RadioButton? = null
    private var Variant3: RadioButton? = null
    private var buttonAnswer: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentquiz,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Variant1 = view.findViewById(R.id.Var_1)
        Variant1?.setOnClickListener {
            buttonAnswer?.isEnabled = true }
        Variant2 = view.findViewById(R.id.Var_2)
        Variant2?.setOnClickListener {
            buttonAnswer?.isEnabled = true }
        Variant3 = view.findViewById(R.id.Var_3)
        Variant3?.setOnClickListener {
            buttonAnswer?.isEnabled = true }


        variantGroup = view.findViewById(R.id.QuezRadioGroup)

        val WelcomeLabel = view.findViewById<TextView>(R.id.HellowText)
        WelcomeLabel.text = getString(R.string.Hellow_text, Datamanager.UserName)

        println("dffdfddf : ${Datamanager.UserName}")

        displayQuestion(Datamanager.test.QuestionList[currentIndex])

        buttonAnswer = view.findViewById<Button>(R.id.NextQuestionButton)
        buttonAnswer?.isEnabled = false

        buttonAnswer?.setOnClickListener{
            val currentQuestion = Datamanager.test.QuestionList[currentIndex]
            val Index = currentQuestion.Answers.indexOfFirst { currentAnswer ->
                currentAnswer.isCorrect == true
            }
            if(Index == 0){
                if(Variant1?.isChecked == true){
                    Datamanager.test.Score += 1;

                }
            } else if(Index == 1){
                if(Variant2?.isChecked == true){
                    Datamanager.test.Score += 1;

                }
            }else if(Index == 2){
                if(Variant3?.isChecked == true){
                    Datamanager.test.Score += 1;
                }
            }


            currentIndex +=1
            if(currentIndex < Datamanager.test.QuestionList.size){

                displayQuestion(Datamanager.test.QuestionList[currentIndex])
            }
            else{
                findNavController().navigate(R.id.resultFragment)
            }
        }
    }

    private fun displayQuestion(CurrentQuestion: Question){


        val questionLable: TextView? = view?.findViewById<TextView>(R.id.QuestionLable)
        questionLable?.text = CurrentQuestion.text

        buttonAnswer?.isEnabled = false
        variantGroup?.clearCheck()

        Variant1?.text = CurrentQuestion.Answers[0].text
        Variant2?.text = CurrentQuestion.Answers[1].text
        Variant3?.text = CurrentQuestion.Answers[2].text

    }

}
