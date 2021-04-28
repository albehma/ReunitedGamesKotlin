package com.example.aggio.giochiriunitikotlin

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

class Livello1_Labirinto : AppCompatActivity() {
    //variabili per gestione riga e colonna corrente
    //setto giocatore al punto di partenza
    private var r : Int = 0
    private var c : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livello1__labirinto)
    }

    //Creo una variabile matrice di tipo Labirinto e inserisco al suo interno tutte le coordinate
    // della posizione della casella e il booleano per definire la possibilità di passaggio
    val lab1 : Array<Array<Labirinto>> = arrayOf(

            arrayOf(Labirinto(90,120,true), Labirinto(90,360,false), Labirinto(90,600,false),Labirinto(90,840,true)),
            arrayOf(Labirinto(267,120,true), Labirinto(267,360,true), Labirinto(267,600,false),Labirinto(267,840,true)),
            arrayOf(Labirinto(445,120,false), Labirinto(445,360,true), Labirinto(445,600,true),Labirinto(445,840,true)),
            arrayOf(Labirinto(622,120,true), Labirinto(622,360,true), Labirinto(622,600,false),Labirinto(622,840,false)),
            arrayOf(Labirinto(800,120,false), Labirinto(800,360,true), Labirinto(800,600,true),Labirinto(800,840,true))
    )
    /*
        Utilizzo una variabile di tipo Gioca_Labirinto per gestire il movimento e capire se è
        possibile o meno una determinata mossa. Passo la variabile lab1 di tipo Labirinto come parametro
    */
    val play = Gioca_Labirinto(lab1)

    //Gestisco azioni sui pulsanti di comando movimento
    // in caso di movimento verso l'alto controllo se questo è possibile usando la posizione corrente
    // e il metodo up della classe Gioca_Labirinto
    fun up (view: View){
        //se possibile la mossa, setto l'immagine del personaggio alla posizione della mossa eseguita
        if (play.up(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r - 1][c].giveX().toFloat())  //prendo le variabili delle coordinate dalla matrice creata in precedenza alle coordinate della mossa scelta
            man.setY(lab1[r - 1][c].giveY().toFloat())
            r--
        }
        //controllo se sono arrivato alle coordinate segnate come punto di arrivo, annunciandone in caso affermativo la vittoria
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    // in caso di movimento verso il basso, controllo se questo è possibile usando la posizione corrente
    // e il metodo down della classe Gioca_Labirinto
    fun down (view: View){
        //se possibile la mossa, setto l'immagine del personaggio alla posizione della mossa eseguita
        if (play.down(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r + 1][c].giveX().toFloat()) //prendo le variabili delle coordinate dalla matrice creata in precedenza alle coordinate della mossa scelta
            man.setY(lab1[r + 1][c].giveY().toFloat())
            r++
        }
        //controllo se sono arrivato alle coordinate segnate come punto di arrivo, annunciandone in caso affermativo la vittoria
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    // in caso di movimento verso sinistra, controllo se questo è possibile usando la posizione corrente
    // e il metodo left della classe Gioca_Labirinto
    fun left (view: View){
        //se possibile la mossa, setto l'immagine del personaggio alla posizione della mossa eseguita
        if (play.left(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r][c -1].giveX().toFloat()) //prendo le variabili delle coordinate dalla matrice creata in precedenza alle coordinate della mossa scelta
            man.setY(lab1[r][c -1].giveY().toFloat())
            c--
        }
        //controllo se sono arrivato alle coordinate segnate come punto di arrivo, annunciandone in caso affermativo la vittoria
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
    // in caso di movimento verso destra, controllo se questo è possibile usando la posizione corrente
    // e il metodo right della classe Gioca_Labirinto
    fun right (view: View){
        //se possibile la mossa, setto l'immagine del personaggio alla posizione della mossa eseguita
        if (play.right(r, c)) {
            val man : ImageView = findViewById(R.id.Image)
            man.setX(lab1[r][c + 1].giveX().toFloat())  //prendo le variabili delle coordinate dalla matrice creata in precedenza alle coordinate della mossa scelta
            man.setY(lab1[r][c + 1].giveY().toFloat())
            c++
        }
        //controllo se sono arrivato alle coordinate segnate come punto di arrivo, annunciandone in caso affermativo la vittoria
        if (r == 4 && c == 3) {
            //Messaggio di vincita
            val toast = Toast.makeText(applicationContext, "HAI VINTO!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}
