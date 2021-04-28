package com.example.aggio.giochiriunitikotlin

/**
 * Sottolineo che livello2 labirinto non è commentato completamente
 * in quanto il commento completo si trova su "Livello1_Labirinto"
 * che è uguale, cambia solo nell'assegnazione dei valori della matrice, per ovvie ragioni, diversi.
 */

/*
Gestisco il gioco del primo livello del labirinto
Utilizzo una classe di supporto (LABIRINTO) che mi gestisce le proprietà di ogni casella così da
poter salvare al suo interno le coordinate dello schermo per lo spostamento e gestirlo in maniera
più facile. Gestisco quindi i pulsanti di movimento e se posso o meno eseguire un determinato
spostamento nel mio labirinto
 */


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class Livello2_Labirinto : AppCompatActivity() {

    //setto giocatore al punto di partenza
    private var r : Int = 0
    private var c : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livello2__labirinto)
    }

    val lab1 : Array<Array<Labirinto>> = arrayOf(

            arrayOf(Labirinto(90,120,true), Labirinto(90,360,true), Labirinto(90,600,true),Labirinto(90,840,true)),
            arrayOf(Labirinto(267,120,false), Labirinto(267,360,false), Labirinto(267,600,false),Labirinto(267,840,true)),
            arrayOf(Labirinto(445,120,true), Labirinto(445,360,true), Labirinto(445,600,true),Labirinto(445,840,true)),
            arrayOf(Labirinto(622,120,true), Labirinto(622,360,false), Labirinto(622,600,false),Labirinto(622,840,false)),
            arrayOf(Labirinto(800,120,true), Labirinto(800,360,true), Labirinto(800,600,true),Labirinto(800,840,true))
    )
    val play = Gioca_Labirinto(lab1)

    //Gestisco azioni sui pulsanti di comando movimento
    fun up (view: View){
        if (play.up(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r - 1][c].giveX().toFloat())
            man.setY(lab1[r - 1][c].giveY().toFloat())
            r--
        }
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun down (view: View){
        if (play.down(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r + 1][c].giveX().toFloat())
            man.setY(lab1[r + 1][c].giveY().toFloat())
            r++
        }
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun left (view: View){
        if (play.left(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r][c -1].giveX().toFloat())
            man.setY(lab1[r][c -1].giveY().toFloat())
            c--
        }
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }

    fun right (view: View){
        if (play.right(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r][c + 1].giveX().toFloat())
            man.setY(lab1[r][c + 1].giveY().toFloat())
            c++
        }
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}