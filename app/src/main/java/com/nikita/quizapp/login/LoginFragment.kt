package com.nikita.quizapp.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.nikita.quizapp.R
import com.nikita.quizapp.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment() {
     @Inject
     lateinit var datamanager: DataManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val button = view.findViewById<Button>(R.id.buttonLogin)
        checkButtonEnabled()

         button.setOnClickListener {
            val parrentConrttoller = findNavController()
             parrentConrttoller.navigate(R.id.action_loginFragment_to_quizFragment)
         }


        val usertextFeild = view.findViewById<TextView>(R.id.userName_TextFeild)
        usertextFeild.doOnTextChanged { text, start, before, count ->
            println("ON CHANGE")
            datamanager.UserName = text.toString()
           checkButtonEnabled()
        }

    }

    private fun checkButtonEnabled(){
        val button = view?.findViewById<Button>(R.id.buttonLogin)
        button?.isEnabled = !datamanager.UserName.isEmpty()
    }

}