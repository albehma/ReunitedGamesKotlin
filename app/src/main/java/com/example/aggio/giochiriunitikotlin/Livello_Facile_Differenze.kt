package com.example.aggio.giochiriunitikotlin

/*
Questa classe gestisce il gioco delle differenze. Appare l'immagine composta da due parti, quella sinistra
a cui manca qualcosa, e quella di destra che mostra l'immagine completa.
Avro quindi due pulsanti, uno per la differenza di destra e uno per la differenza di sinistra.
Un'altro pulsante è presente nel restante spazio dell'immagine per capire se sbaglio la differenza.
 */

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class Livello_Facile_Differenze : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livello__facile__differenze)
        //inizializzo la prima immagine e le relative coordinate della differenza
        sbagliato.background = getDrawable(easyP[i].giveName())
        corretto1.x = easyP[i].giveX().toFloat()
        corretto1.y = easyP[i].giveY().toFloat()
        //calcolo che la seconda immagine è spostata di 550 rispetto la prima, così ho le coordinate della seocnda casella di differenza
        corretto2.x = easyP[i].giveX().toFloat() + 550
        corretto2.y = easyP[i].giveY().toFloat()


    }

    val numFoto : Int = 10      //numero i foto totali di livello
    var i = 0                   //foto corrente
    var p = 0                   //nomero di differenze trovate

    //variabili utili
    // Textview che visualizza a che numero di immagine sono arrivato sul totale
    val corrente : TextView
        get() = findViewById(R.id.immagineCorr)
    //Textview che indica qual è il mio punteggio attuale
    val punteggio : TextView
        get() = findViewById(R.id.punteggioCorr)
    //pulsanti che si trovano nella differenza dell'immagine sinistra e destra
    val corretto1 : Button
        get() = findViewById(R.id.correct1)
    val corretto2 : Button
        get() = findViewById(R.id.correct2)
    //pulsante per cogliere l'errore dell'utente nel trovare la differenza
    val sbagliato: Button
        get() = findViewById(R.id.notCorrect)
    //variabile per il tempo di attesa tra un immagine e l'altra nel quale viene mostrato l'errore
    val handler : Handler = Handler()



    //Coordinate box corretti per immagine
    //creo un vettore con N elementi, uno per immagine
    val easyP = arrayListOf<Coordinate_Differenze>(
            Coordinate_Differenze(270,400,R.drawable.e11,R.drawable.e12),
            Coordinate_Differenze(270,230,R.drawable.e21,R.drawable.e22),
            Coordinate_Differenze(170,280,R.drawable.e31,R.drawable.e32),
            Coordinate_Differenze(30,200,R.drawable.e41,R.drawable.e42),
            Coordinate_Differenze(20,180,R.drawable.e51,R.drawable.e52),
            Coordinate_Differenze(80,285,R.drawable.e61,R.drawable.e62),
            Coordinate_Differenze(200,30,R.drawable.e71,R.drawable.e72),
            Coordinate_Differenze(100,360,R.drawable.e81,R.drawable.e82),
            Coordinate_Differenze(100,500,R.drawable.e91,R.drawable.e92),
            Coordinate_Differenze(150,150,R.drawable.e101,R.drawable.e102)
    )

    fun correct1(view: View){
        //metodo per la gestione dell'attesa tra un'immagine e la successiva
        handler.postDelayed(object : Runnable {
            internal var j = 0
            override fun run() {
                if (j == 0) {
                    p++    //incremento il punteggio di 1
                    sbagliato.background = getDrawable(easyP[i].giveNameC())
                    //aggiorno la casella di testo col punteggio aggiornato
                    punteggio.text = "CORRETTI: " + p
                    //visualizzo un messaggio che mi indica la correttezza
                    val toastC = Toast.makeText(applicationContext,"TROVATO!!!",Toast.LENGTH_SHORT)
                    toastC.show()
                    //incremento il numero dell'immagine corrente
                    i++
                    j++
                    //disabilito i pulsanti per evitare errori durante la visualizzazione della differenza
                    corretto1.isEnabled = false
                    corretto2.isEnabled = false
                    sbagliato.isEnabled = false
                    //imposto tempo d'attesa
                    handler.postDelayed(this, 3000)
                    //controllo se ho ancora foto da giocare
                } else if (i != numFoto) {
                    //aggiorno l'immagine successiva
                    sbagliato.background = getDrawable(easyP[i].giveName())
                    //Aggiorno il numero di immagine corrente
                    corrente.text = "FACILE : " + (i + 1) + " DI 10"
                    //sposto coordinate nuova foto
                    corretto1.x = easyP[i].giveX().toFloat()
                    corretto1.y = easyP[i].giveY().toFloat()
                    corretto2.x = easyP[i].giveX().toFloat() + 550
                    corretto2.y = easyP[i].giveY().toFloat()
                    //abilito i pulsanti
                    corretto1.isEnabled = true
                    corretto2.isEnabled = true
                    sbagliato.isEnabled = true
                    //tempo di attesa
                    handler.postDelayed(this, 3000)
                    //se invece mi trovo all'ultima foto e non ho foto successive
                } else if (i == numFoto) {
                    //salvo il punteggio e mando l'utente all'activity finale con segnalazione punteggio
                    val openRisultato = Intent(this@Livello_Facile_Differenze, Risultato_Differenze::class.java)
                    openRisultato.putExtra("p", p)
                    openRisultato.putExtra("numImm", numFoto)
                    startActivity(openRisultato)
                }

            }
        }, 10)
    }

    //questa azione sul pulsante è analoga al "corretto1"
    fun correct2(view: View){
        handler.postDelayed(object : Runnable {
            internal var j = 0
            override fun run() {
                if (j == 0) {
                    p++    //incremento il punteggio di 1
                    sbagliato.background = getDrawable(easyP[i].giveNameC())
                    punteggio.text = "CORRETTI: " + p
                    val toastC = Toast.makeText(applicationContext,"TROVATO!!!",Toast.LENGTH_SHORT)
                    toastC.show()
                    i++
                    j++
                    corretto1.isEnabled = false
                    corretto2.isEnabled = false
                    sbagliato.isEnabled = false
                    handler.postDelayed(this, 3000)
                } else if (i != numFoto) {
                    sbagliato.background = getDrawable(easyP[i].giveName())
                    corrente.text = "FACILE : " + (i + 1) + " DI 10"
                    //sposto coordinate nuova foto
                    corretto1.x = easyP[i].giveX().toFloat()
                    corretto1.y = easyP[i].giveY().toFloat()
                    corretto2.x = easyP[i].giveX().toFloat() + 550
                    corretto2.y = easyP[i].giveY().toFloat()
                    corretto1.isEnabled = true
                    corretto2.isEnabled = true
                    sbagliato.isEnabled = true
                    handler.postDelayed(this, 3000)
                } else if (i == numFoto) {
                    val openRisultato = Intent(this@Livello_Facile_Differenze, Risultato_Differenze::class.java)
                    openRisultato.putExtra("p", p)
                    openRisultato.putExtra("numImm", numFoto)
                    startActivity(openRisultato)
                }

            }
        }, 10)
    }

    //Azione nel caso di errore sul ritrovamento
    fun notCorrect(view: View){
        handler.postDelayed(object : Runnable {
            internal var j = 0
            override fun run() {
                if (j == 0) {
                    //non incremento il punteggio
                    //mostro l'errore con l'immagine corretta
                    sbagliato.background = getDrawable(easyP[i].giveNameC())
                    //visualizzo il punteggio
                    punteggio.text = "CORRETTI: " + p
                    //avverto l'utente dell'errore
                    val toastE = Toast.makeText(applicationContext,"SBAGLIATO!!!",Toast.LENGTH_SHORT)
                    toastE.show()
                    //incremento il numero di foto corrente
                    i++
                    j++
                    //disabilito i pulsanti per evitare errori
                    corretto1.isEnabled = false
                    corretto2.isEnabled = false
                    sbagliato.isEnabled = false
                    //tempo di attesa del programma per permettere di visualizzare l'errore
                    handler.postDelayed(this, 3000)
                } else if (i != numFoto) {
                    //Aggiorno all'immagine successiva
                    sbagliato.background = getDrawable(easyP[i].giveName())
                    //visualizzo il numero di foto corrente
                    corrente.text = "FACILE : " + (i + 1) + " DI 10"
                    //sposto coordinate nuova foto
                    corretto1.x = easyP[i].giveX().toFloat()
                    corretto1.y = easyP[i].giveY().toFloat()
                    corretto2.x = easyP[i].giveX().toFloat() + 550
                    corretto2.y = easyP[i].giveY().toFloat()
                    //riabilito i pulsanti
                    corretto1.isEnabled = true
                    corretto2.isEnabled = true
                    sbagliato.isEnabled = true
                    //tempo di attesa
                    handler.postDelayed(this, 3000)
                    //se sono all'ultima foto
                } else if (i == numFoto) {
                    //salvo il punteggio e mando l'utente all'activity finale che mostrerà il punteggio
                    val openRisultato = Intent(this@Livello_Facile_Differenze, Risultato_Differenze::class.java)
                    openRisultato.putExtra("p", p)
                    openRisultato.putExtra("numImm", numFoto)
                    startActivity(openRisultato)
                }

            }
        }, 10)
    }
}

