package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Menu_Principale : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu__principale)
    }

    //gestione pulsante Labirinto
    fun labirinto(view: View){
        val apriLabirinto = Intent(this,Menu_Labirinto::class.java)
        startActivity(apriLabirinto)
    }

    //gestione pulsante differenze
    fun differenze(view: View){
        val apriDifferenze = Intent(this,Menu_Differenze::class.java)
        startActivity(apriDifferenze)
    }

    //gestione pulsante Puzzle15
    fun puzzle(view: View){
        val apriPuzzle = Intent(this,Principale_Puzzle15::class.java)
        startActivity(apriPuzzle)
    }

    //gestione pulsante Memory
    fun memory(view: View){
        val apriMemory = Intent(this,Principale_Memory::class.java)
        startActivity(apriMemory)
    }

    //gestione pulsante Impiccato
    fun impiccato(view: View){
        val apriImpiccato= Intent(this,Principale_Impiccato::class.java)
        startActivity(apriImpiccato)
    }

    //gestione pulsante Tris
    fun tris(view: View){
        val apriTris= Intent(this,Principale_Tris::class.java)
        startActivity(apriTris)
    }
}
