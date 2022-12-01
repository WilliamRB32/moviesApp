package com.example.taller2.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taller2.fragments.FragmentLogIn
import com.example.taller2.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.container, FragmentLogIn())
        transaction.commit()


    }



}