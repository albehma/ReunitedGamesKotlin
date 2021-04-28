package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class Menu_Differenze : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu__differenze)
    }
    fun easy (view: View){
        val intent = Intent(this,Livello_Facile_Differenze::class.java)
        startActivity(intent)
    }

    fun hard (view: View){
        val intent = Intent(this,Livello_Difficile_Differenze::class.java)
        startActivity(intent)
    }
    fun menu (view: View){
        val intent = Intent(this, Menu_Principale::class.java)
        startActivity(intent)
    }

}
