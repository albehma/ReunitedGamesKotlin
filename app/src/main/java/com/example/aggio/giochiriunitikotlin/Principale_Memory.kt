package com.example.aggio.giochiriunitikotlin

import android.content.Intent
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import java.util.Random

//Classe principale
class Principale_Memory : AppCompatActivity() {

    //id delle immagini nell'activity_main
    internal lateinit var iv_11: ImageView
    internal lateinit var iv_12: ImageView
    internal lateinit var iv_13: ImageView
    internal lateinit var iv_14: ImageView
    internal lateinit var iv_21: ImageView
    internal lateinit var iv_22: ImageView
    internal lateinit var iv_23: ImageView
    internal lateinit var iv_24: ImageView
    internal lateinit var iv_31: ImageView
    internal lateinit var iv_32: ImageView
    internal lateinit var iv_33: ImageView
    internal lateinit var iv_34: ImageView
    internal lateinit var iv_41: ImageView
    internal lateinit var iv_42: ImageView
    internal lateinit var iv_43: ImageView
    internal lateinit var iv_44: ImageView

    //array per le immagini
    internal var cardsArray = arrayOf(101, 102, 103, 104, 105, 106, 107, 108, 201, 202, 203, 204, 205, 206, 207, 208)



    //nome reale delle immagini
    internal var image101: Int = 0
    internal var image102: Int = 0
    internal var image103: Int = 0
    internal var image104: Int = 0
    internal var image105: Int = 0
    internal var image106: Int = 0
    internal var image107: Int = 0
    internal var image108: Int = 0
    internal var image201: Int = 0
    internal var image202: Int = 0
    internal var image203: Int = 0
    internal var image204: Int = 0
    internal var image205: Int = 0
    internal var image206: Int = 0
    internal var image207: Int = 0
    internal var image208: Int = 0

    //definisco le variabili principali
    internal var firstCard: Int = 0
    internal var secondCard: Int = 0
    internal var clickedFirst: Int = 0
    internal var clickedSecond: Int = 0
    internal var cardNumber = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principale__memory)

        //trovo le immagini tramite l'id e setto un tag per ognuna
        iv_11 = findViewById<View>(R.id.iv_11) as ImageView
        iv_12 = findViewById<View>(R.id.iv_12) as ImageView
        iv_13 = findViewById<View>(R.id.iv_13) as ImageView
        iv_14 = findViewById<View>(R.id.iv_14) as ImageView

        iv_21 = findViewById<View>(R.id.iv_21) as ImageView
        iv_22 = findViewById<View>(R.id.iv_22) as ImageView
        iv_23 = findViewById<View>(R.id.iv_23) as ImageView
        iv_24 = findViewById<View>(R.id.iv_24) as ImageView

        iv_31 = findViewById<View>(R.id.iv_31) as ImageView
        iv_32 = findViewById<View>(R.id.iv_32) as ImageView
        iv_33 = findViewById<View>(R.id.iv_33) as ImageView
        iv_34 = findViewById<View>(R.id.iv_34) as ImageView

        iv_41 = findViewById<View>(R.id.iv_41) as ImageView
        iv_42 = findViewById<View>(R.id.iv_42) as ImageView
        iv_43 = findViewById<View>(R.id.iv_43) as ImageView
        iv_44 = findViewById<View>(R.id.iv_44) as ImageView

        iv_11.tag = "0"
        iv_12.tag = "1"
        iv_13.tag = "2"
        iv_14.tag = "3"

        iv_21.tag = "4"
        iv_22.tag = "5"
        iv_23.tag = "6"
        iv_24.tag = "7"

        iv_31.tag = "8"
        iv_32.tag = "9"
        iv_33.tag = "10"
        iv_34.tag = "11"

        iv_41.tag = "12"
        iv_42.tag = "13"
        iv_43.tag = "14"
        iv_44.tag = "15"

        //carico le immagini delle carte
        frontOfCardsResources()

        //randomizzo le carte
        val random = Random()
        for (i in cardsArray.size - 1 downTo 1) {
            val j = random.nextInt(i + 1)
            val temp = cardsArray[i]
            cardsArray[i] = cardsArray[j]
            cardsArray[j] = temp
        }

        //Gestisco il tocco delle immagini
        iv_11.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_11, theCard)
        }

        iv_12.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_12, theCard)
        }

        iv_13.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_13, theCard)
        }

        iv_14.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_14, theCard)
        }

        iv_21.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_21, theCard)
        }

        iv_22.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_22, theCard)
        }

        iv_23.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_23, theCard)
        }

        iv_24.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_24, theCard)
        }

        iv_31.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_31, theCard)
        }

        iv_32.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_32, theCard)
        }

        iv_33.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_33, theCard)
        }

        iv_34.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_34, theCard)
        }

        iv_41.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_41, theCard)
        }

        iv_42.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_42, theCard)
        }

        iv_43.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_43, theCard)
        }

        iv_44.setOnClickListener { v ->
            val ss = v.tag.toString()
            val theCard = Integer.parseInt(ss)
            doStuff(iv_44, theCard)
        }


    }

    //metodo per controllare quale immagine è selezionata e per salvarla nella variabile temporanea
    private fun doStuff(iv: ImageView, card: Int) {

        //Imposto le immagini corrette
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101)
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102)
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103)
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104)
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105)
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106)
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(image107)
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(image108)
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201)
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202)
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203)
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204)
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205)
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206)
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(image207)
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(image208)
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card]
            if (firstCard > 200) {
                firstCard = firstCard - 100
            }

            cardNumber = 2
            clickedFirst = card
            iv.isEnabled = false
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card]
            if (secondCard > 200) {
                secondCard = secondCard - 100
            }

            cardNumber = 1
            clickedSecond = card

            iv_11.isEnabled = false
            iv_12.isEnabled = false
            iv_13.isEnabled = false
            iv_14.isEnabled = false
            iv_21.isEnabled = false
            iv_22.isEnabled = false
            iv_23.isEnabled = false
            iv_24.isEnabled = false
            iv_31.isEnabled = false
            iv_32.isEnabled = false
            iv_33.isEnabled = false
            iv_34.isEnabled = false
            iv_41.isEnabled = false
            iv_42.isEnabled = false
            iv_43.isEnabled = false
            iv_44.isEnabled = false

            val handler = Handler()
            handler.postDelayed({
                // controllo se l'immagine selezionata è uguale
                calculate()
            }, 1000)

        }
    }

    //metodo per controllare la corrispondenza tra le due carte
    private fun calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv_11.visibility = View.INVISIBLE
            } else if (clickedFirst == 1) {
                iv_12.visibility = View.INVISIBLE
            } else if (clickedFirst == 2) {
                iv_13.visibility = View.INVISIBLE
            } else if (clickedFirst == 3) {
                iv_14.visibility = View.INVISIBLE
            } else if (clickedFirst == 4) {
                iv_21.visibility = View.INVISIBLE
            } else if (clickedFirst == 5) {
                iv_22.visibility = View.INVISIBLE
            } else if (clickedFirst == 6) {
                iv_23.visibility = View.INVISIBLE
            } else if (clickedFirst == 7) {
                iv_24.visibility = View.INVISIBLE
            } else if (clickedFirst == 8) {
                iv_31.visibility = View.INVISIBLE
            } else if (clickedFirst == 9) {
                iv_32.visibility = View.INVISIBLE
            } else if (clickedFirst == 10) {
                iv_33.visibility = View.INVISIBLE
            } else if (clickedFirst == 11) {
                iv_34.visibility = View.INVISIBLE
            } else if (clickedFirst == 12) {
                iv_41.visibility = View.INVISIBLE
            } else if (clickedFirst == 13) {
                iv_42.visibility = View.INVISIBLE
            } else if (clickedFirst == 14) {
                iv_43.visibility = View.INVISIBLE
            } else if (clickedFirst == 15) {
                iv_44.visibility = View.INVISIBLE
            }

            if (clickedSecond == 0) {
                iv_11.visibility = View.INVISIBLE
            } else if (clickedSecond == 1) {
                iv_12.visibility = View.INVISIBLE
            } else if (clickedSecond == 2) {
                iv_13.visibility = View.INVISIBLE
            } else if (clickedSecond == 3) {
                iv_14.visibility = View.INVISIBLE
            } else if (clickedSecond == 4) {
                iv_21.visibility = View.INVISIBLE
            } else if (clickedSecond == 5) {
                iv_22.visibility = View.INVISIBLE
            } else if (clickedSecond == 6) {
                iv_23.visibility = View.INVISIBLE
            } else if (clickedSecond == 7) {
                iv_24.visibility = View.INVISIBLE
            } else if (clickedSecond == 8) {
                iv_31.visibility = View.INVISIBLE
            } else if (clickedSecond == 9) {
                iv_32.visibility = View.INVISIBLE
            } else if (clickedSecond == 10) {
                iv_33.visibility = View.INVISIBLE
            } else if (clickedSecond == 11) {
                iv_34.visibility = View.INVISIBLE
            } else if (clickedSecond == 12) {
                iv_41.visibility = View.INVISIBLE
            } else if (clickedSecond == 13) {
                iv_42.visibility = View.INVISIBLE
            } else if (clickedSecond == 14) {
                iv_43.visibility = View.INVISIBLE
            } else if (clickedSecond == 15) {
                iv_44.visibility = View.INVISIBLE
            }
        } else {
            iv_11.setImageResource(R.drawable.punto_interrogativo)
            iv_12.setImageResource(R.drawable.punto_interrogativo)
            iv_13.setImageResource(R.drawable.punto_interrogativo)
            iv_14.setImageResource(R.drawable.punto_interrogativo)
            iv_21.setImageResource(R.drawable.punto_interrogativo)
            iv_22.setImageResource(R.drawable.punto_interrogativo)
            iv_23.setImageResource(R.drawable.punto_interrogativo)
            iv_24.setImageResource(R.drawable.punto_interrogativo)
            iv_31.setImageResource(R.drawable.punto_interrogativo)
            iv_32.setImageResource(R.drawable.punto_interrogativo)
            iv_33.setImageResource(R.drawable.punto_interrogativo)
            iv_34.setImageResource(R.drawable.punto_interrogativo)
            iv_41.setImageResource(R.drawable.punto_interrogativo)
            iv_42.setImageResource(R.drawable.punto_interrogativo)
            iv_43.setImageResource(R.drawable.punto_interrogativo)
            iv_44.setImageResource(R.drawable.punto_interrogativo)
        }

        iv_11.isEnabled = true
        iv_12.isEnabled = true
        iv_13.isEnabled = true
        iv_14.isEnabled = true
        iv_21.isEnabled = true
        iv_22.isEnabled = true
        iv_23.isEnabled = true
        iv_24.isEnabled = true
        iv_31.isEnabled = true
        iv_32.isEnabled = true
        iv_33.isEnabled = true
        iv_34.isEnabled = true
        iv_41.isEnabled = true
        iv_42.isEnabled = true
        iv_43.isEnabled = true
        iv_44.isEnabled = true

        //Verifico la fine del gioco
        checkEnd()
    }

    //metodo per verificare la fine del gioco
    private fun checkEnd() {
        //se tutte le carte sono invisibili lancio il messaggio finale
        if (iv_11.visibility == View.INVISIBLE &&
                iv_11.visibility == View.INVISIBLE &&
                iv_12.visibility == View.INVISIBLE &&
                iv_13.visibility == View.INVISIBLE &&
                iv_14.visibility == View.INVISIBLE &&
                iv_21.visibility == View.INVISIBLE &&
                iv_22.visibility == View.INVISIBLE &&
                iv_23.visibility == View.INVISIBLE &&
                iv_24.visibility == View.INVISIBLE &&
                iv_31.visibility == View.INVISIBLE &&
                iv_32.visibility == View.INVISIBLE &&
                iv_33.visibility == View.INVISIBLE &&
                iv_34.visibility == View.INVISIBLE &&
                iv_41.visibility == View.INVISIBLE &&
                iv_42.visibility == View.INVISIBLE &&
                iv_43.visibility == View.INVISIBLE &&
                iv_44.visibility == View.INVISIBLE) {

            val alertDialogBuilder = AlertDialog.Builder(this@Principale_Memory)
            alertDialogBuilder
                    .setMessage("Congrats!")
                    .setCancelable(false)
                    .setPositiveButton("NEW") { _, _ ->
                        val intent = Intent(applicationContext, Principale_Memory::class.java)
                        startActivity(intent)
                        finish()//se premo new inizia una nuova partita
                    }
                    .setNegativeButton("EXIT") { _, _ ->
                        finish()//se premo exit termino il gioco
                    }
            val alertDialog = alertDialogBuilder.create()
            alertDialog.show()

        }
    }

    //metodo per caricare le immagini delle carte
    private fun frontOfCardsResources() {
        image101 = R.drawable.image101
        image102 = R.drawable.image102
        image103 = R.drawable.image103
        image104 = R.drawable.image104
        image105 = R.drawable.image105
        image106 = R.drawable.image106
        image107 = R.drawable.image107
        image108 = R.drawable.image108
        image201 = R.drawable.image201
        image202 = R.drawable.image202
        image203 = R.drawable.image203
        image204 = R.drawable.image204
        image205 = R.drawable.image205
        image206 = R.drawable.image206
        image207 = R.drawable.image207
        image208 = R.drawable.image208

    }

}