package com.example.aggio.giochiriunitikotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class Pareggio_Tris: Activity() {
    private lateinit var miaImmagine: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //imposto la grafica da visualizzare

        setContentView(R.layout.activity_pareggio__tris)
        miaImmagine = findViewById(R.id.imageView3)
        miaImmagine.setImageResource(R.drawable.pareggio)
    }
    fun back (view: View){
        val i = Intent(this, Principale_Tris::class.java)
        startActivity(i)
    }
}