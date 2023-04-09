package com.nikita.quizapp.ResultFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nikita.quizapp.R
import com.nikita.quizapp.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ResultFragment: Fragment() {
    @Inject
    lateinit var datamanager: DataManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val resultText = view.findViewById<TextView>(R.id.Result_text)
        val restartButton = view.findViewById<Button>(R.id.restart_button)


        //if(datamanager.test.score = 0){
         //   resultText = ""
       // }
        resultText.text = "${datamanager.test.Score}"

        restartButton.setOnClickListener {
            datamanager.test.Score = 0
            findNavController().popBackStack(R.id.loginFragment, false)
        }
    }


}