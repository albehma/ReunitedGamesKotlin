package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup


class Principale_Tris : AppCompatActivity() {
    //variabili varie che mi serviranno durante lo sviluppo del codice:
    //Bottone di inizio gioco (porta alla griglia)
    internal lateinit var play: Button
    //Gruppo di pulsanti per selezionare x oppure o
    internal lateinit var rg1: RadioGroup
    internal lateinit var rg2: RadioGroup
    //pulsanti x e o
    internal lateinit var rb1: RadioButton
    internal lateinit var rb2: RadioButton
    //Tasto per procedere nel gioco (porta alla selezione personaggio)
    internal lateinit var continua: Button
    //Stringhe che identificano i giocatori 1 e 2
    internal lateinit var p1: String
    internal lateinit var p2: String
    //sovrascrivo il metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //imposto la grafica da visualizzare
        setContentView(R.layout.activity_principale__tris)

    }

    //definisco uscita da tris
    fun menu(view: View){
        val i = Intent(this@Principale_Tris, Menu_Principale::class.java)
        startActivity(i)
    }
    //definisco cosa succede quando clicco sul bottone continua:

    fun continua(view: View){
        //si apre la nuova activity selezione personaggio
        setContentView(R.layout.select_player_tris)
        //inizializzo i vari pulsanti con gli ID definiti nell'XML
        rg1 = findViewById(R.id.RadioGroup1) as RadioGroup
        rg2 = findViewById(R.id.radioGroup2) as RadioGroup

    }
    //definisco cosa succede cliccando su play
    fun play4(view: View){
        //Differenzio la scelta del presonaggio x da quello o, tramite la definizione di interi
        //grazie al metodo getCheckedRadioButtonId()
        val scelta1 = rg1.getCheckedRadioButtonId()
        rb1 = findViewById(scelta1)
        //cambio la stringa del player 1 ottenendo il carattere scelto e trasformandolo in stringa
        p1 = rb1.getText().toString()

        //faccio le stesse operazioni fatte per il player 1
        val scelta2 = rg2.getCheckedRadioButtonId()
        rb2 = findViewById(scelta2)
        p2 = rb2.getText().toString()

        //Definisco l'intent per aprire una nuova schermata, in particolare quella del Gioco
        val i = Intent(this@Principale_Tris, Gioco_Tris::class.java)
        //putExtra: indispensabile per portarmi nella schermata di gioco le scelte fatte dai
        //giocatori x e o nella schermata precedente.
        i.putExtra("Player 1", p1)
        i.putExtra("Player 2", p2)
        //inizio l'activity gioco
        startActivity(i)
    }
}