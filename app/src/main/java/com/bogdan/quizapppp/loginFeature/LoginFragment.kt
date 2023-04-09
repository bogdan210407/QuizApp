package com.bogdan.quizapppp.loginFeature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bogdan.quizapppp.R
import com.bogdan.quizapppp.helpers.DataManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment: Fragment() {
    @Inject
    lateinit var dataManager: DataManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button = view.findViewById<Button>(R.id.enter_button)
        button.isEnabled = dataManager.userName.isNotBlank()
        button.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_quizFragmernt2)
        }

        val userText = view.findViewById<EditText>(R.id.name_text)
        userText.doOnTextChanged { text, start, before, count ->
            dataManager.userName = text.toString()
            button.isEnabled = dataManager.userName.isNotBlank()
        }
    }
}