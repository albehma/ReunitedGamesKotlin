package com.example.aggio.giochiriunitikotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import android.widget.Toast


class Principale_Impiccato : AppCompatActivity() {
    //parte il gioco con un'istanza della classe Gioco
    var play = Gioco_Impiccato()
    //sovrascrizione classica del metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principale__impiccato) //schermata da visualizzare

        val wordView = findViewById<View>(R.id.word) as TextView
        val scoreText = findViewById<View>(R.id.score) as TextView

        //imposto sulla schermata visualizzata i testi da vedere: la parola tratteggiata ed il punteggio
        wordView.text = play.get_display_word() //aggiorna man mano la parola
        scoreText.text = Integer.toString(play.get_score())
    }
    //metodo per inserire una nuova lettera nella parola
    fun new_guess(view: View) {
        //Imposto gli elementi da visualizzare:
        val wordView = findViewById(R.id.word) as TextView
        val scoreText = findViewById(R.id.score) as TextView
        //nuova lettera inserita
        val letter_guessed = findViewById(R.id.new_letter) as TextView
        //definisco il metodo di inserimento della nuova lettera:
        val new_guess:String = letter_guessed.getText().toString()

        if(!new_guess.equals("")) {
            play.inserimento_lettera(new_guess) }
        wordView.text = play.get_display_word() //aggiorno la parola
        scoreText.text = Integer.toString(play.get_score()) //aggiorno il punteggio
        letter_guessed.text = "" //serve a cancellare la lettera appena scritta nel box per inserimento lettera
        //in modo da poter scrivere una nuova lettera senza dover cancellare manualmente
        //quella precedente.

        //Questo serve a capire se il gioco è completato o no. Le condizioni di vittoria sono che la parola sia
        //completata e che il punteggio sia positivo. Sia in caso di vittoria che di sconfitta compare un Toast di avviso.
        if (play.parola_completata() && play.get_score() > 0) {
            Toast.makeText(applicationContext, "Congratulazioni, \n hai indovinato la parola " + play.visualizza_parola_completa().toUpperCase() + " !!!", Toast.LENGTH_LONG).show()
        } else if (play.parola_completata() && play.get_score() < 0)
            Toast.makeText(applicationContext, "Congratulazioni, \n hai indovinato la parola " + play.visualizza_parola_completa().toUpperCase() + ", ma hai ottenuto un punteggio negativo...", Toast.LENGTH_LONG).show()
    }

    //reset: permette di far ripartire il gioco da zero con una nuova parola, reimpostando entrambi i parametri
    fun reset(view: View) {
        val wordView = findViewById<View>(R.id.word) as TextView
        val scoreText = findViewById<View>(R.id.score) as TextView

        play = Gioco_Impiccato()
        wordView.text = play.get_display_word()
        scoreText.text = Integer.toString(play.get_score())
    }
}

