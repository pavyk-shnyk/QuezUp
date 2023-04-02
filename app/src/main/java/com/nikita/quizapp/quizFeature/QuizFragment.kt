package com.nikita.quizapp.quizFeature

import android.os.Bundle
import android.view.Display
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nikita.quizapp.R
import com.nikita.quizapp.helpers.DataManager
import com.nikita.quizapp.helpers.testExample
import com.nikita.quizapp.model.Question
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class QuizFragment: Fragment() {
    @Inject
    lateinit var Datamanager: DataManager
    private var currentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentquiz,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val WelcomeLabel = view.findViewById<TextView>(R.id.HellowText)
        WelcomeLabel.text = getString(R.string.Hellow_text, Datamanager.UserName)

        displayQuestion(Datamanager.test.QuestionList[currentIndex])

        val buttonAnswer = view.findViewById<Button>(R.id.NextQuestionButton)
        buttonAnswer.setOnClickListener{
            currentIndex +=1
            if(currentIndex < Datamanager.test.QuestionList.size){

                displayQuestion(Datamanager.test.QuestionList[currentIndex])
            }
        }
    }

    private fun displayQuestion(CurrentQuestion: Question){
        val questionLable: TextView? = view?.findViewById<TextView>(R.id.QuestionLable)
        questionLable?.text = CurrentQuestion.text

        val variant1 = view?.findViewById<RadioButton>(R.id.Var_1)
        val variant2 = view?.findViewById<RadioButton>(R.id.Var_2)
        val variant3 = view?.findViewById<RadioButton>(R.id.Var_3)

        variant1?.text = CurrentQuestion.Answers[0].text
        variant2?.text = CurrentQuestion.Answers[1].text
        variant3?.text = CurrentQuestion.Answers[2].text

    }

}
