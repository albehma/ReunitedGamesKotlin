package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Menu_Labirinto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu__labirinto)
    }
    //Assegno nome al pulsante level1 e gestisco azione
    fun level1 (view: View){
        val intent = Intent(this, Livello1_Labirinto::class.java)
        startActivity(intent)
    }
    fun level2 (view: View){
        val intent = Intent(this, Livello2_Labirinto::class.java)
        startActivity(intent)
    }
    fun level3 (view: View){
        val intent = Intent(this, Livello3_Labirinto::class.java)
        startActivity(intent)
    }
    fun menu (view: View){
        val intent = Intent(this, Menu_Principale::class.java)
        startActivity(intent)
    }
}


