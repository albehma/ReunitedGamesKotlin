package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Risultato_Differenze : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_risultato__differenze)
        val extras = intent.extras
        val corretti = extras!!.getInt("p")
        val tot = extras.getInt("numImm")
        val riepilogo : TextView = findViewById(R.id.riepilogo)
        riepilogo.text = "Il tuo punteggio è di: "+corretti+" su "+tot
    }

    fun ritorna(view: View){
        val openMenu = Intent(this,Menu_Differenze::class.java)
        startActivity(openMenu)
    }
}
