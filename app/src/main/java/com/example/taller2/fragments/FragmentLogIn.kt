package com.example.taller2.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.taller2.R
import com.example.taller2.activities.MainMenu


class FragmentLogIn : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_log_in, container, false)
        val loginButton : Button = view.findViewById(R.id.button)
        loginButton.setOnClickListener{
            val intent = Intent(view.context, MainMenu::class.java)
            startActivity(intent)
        }
        return view
    }


}