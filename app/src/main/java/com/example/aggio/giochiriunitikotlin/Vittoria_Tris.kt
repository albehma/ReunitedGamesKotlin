package com.example.aggio.giochiriunitikotlin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class Vittoria_Tris : Activity() {

    //classe che annuncia la vittoria di uno dei due giocatori
    internal val context: Context = this
    //Definisco un bottone per poter tornare indietro
    internal lateinit var b: Button
    //Utile per poter scrivere il nome del vincitore
    internal lateinit var nomeVincitore: TextView
    //Immagine di vittoria
    private lateinit var miaImmagine: ImageView

    //sovrascrivo il metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //imposto la schermata di vittoria (definita nel file .xml)
        setContentView(R.layout.activity_vittoria__tris)

        //imposto l'immagine del trofeo
        miaImmagine = findViewById(R.id.imageView)
        miaImmagine.setImageResource(R.drawable.premio)
        //Tramite questa chiamata posso recuperare il nome del vincitore
        val intent = getIntent()
        val vincitore = intent.getStringExtra("vincitore")
        //Ed impostarlo sulla schermata
        nomeVincitore = findViewById(R.id.textView4)
        nomeVincitore.setText(vincitore)

    }
    //Definisco cosa succede se clicco sul tasto prima definito
    fun back (view: View){
        val torna= Intent(this,Menu_Principale::class.java)
        startActivity(torna)
    }
}


