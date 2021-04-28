package com.example.aggio.giochiriunitikotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*

class Gioco_Tris : Activity() {

    //variabili utili per lo sviluppo del codice
    internal lateinit var t: TextView
    internal lateinit var p1: String
    internal lateinit var p2: String
    //definizione di 2 array per controllare le mosse del giocatore x e o
    internal var checkedp1 = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
    internal var checkedp2 = intArrayOf(-1, -1, -1, -1, -1, -1, -1, -1, -1)
    //Definisco una gridview: è una visualizzazione a griglia, molto utile per definire il gioco del tris
    internal lateinit var gridView: GridView
    //Context utile al fine di poter utilizzare l'intent
    internal val context: Context = this

    //variabile statica affinché sia visibile a tutte le istanze della classe
    internal var i: Int = 0
    //Definisco un array di Stringhe "vuote" per confrontare le varie caselle del gioco
    internal val values: Array<String> = arrayOf("", "", "", "", "", "", "", "", "")

    @SuppressLint("WrongConstant") //richiesto da AndroidStudio
    //sovrascrivo il metodo onCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        for (k in 0..8) {
            checkedp1[k] = -1
            checkedp2[k] = -1
        }
        //inizializzo i = 0
        i = 0

        super.onCreate(savedInstanceState)
        //imposto la schermata di gioco
        setContentView(R.layout.grid_view_tris)

        //Riprendo le informazioni della schermata precedente, dove erano stati decisi i simboli x e o per i 2 giocatori
        val intent = getIntent()
        p1 = intent.getStringExtra("Player 1")
        p2 = intent.getStringExtra("Player 2")
        //verifico che i 2 giocatori non abbiano scelto lo stesso simbolo
        if (p1.equals(p2, ignoreCase = true)) {
            Toast.makeText(this@Gioco_Tris, "Entrambi i giocatori non possono usare lo stesso simboolo", 2000).show()
            finish()
        } else {
            gridView = findViewById(R.id.gridview_tris)
            /*
         * È possibile utilizzare questo adattatore per fornire views per AdapterView.
         * Ci permette di collegare la griglia con i txt che verranno inseriti su questa
         * I parametri che prende sono: <String> perché andremo ad inserire stringhe,
         * (attuale classe, layout dove metteremo le stringhe, e ciò che useremo per le stringhe
         * ovvero l'array symbol (vuoto) prima definito.
         */
            gridView.adapter = ArrayAdapter<String>(this, R.layout.game_view_tris, values)
            //setAdapter = imposta i dati dentro la view passata come parametro
            //definisco cosa succede ogni volta che si clicca su una posizione

            gridView.setOnItemClickListener{
                parent: AdapterView<*>, view: View, position: Int, id: Long ->

                //definisco un flag int per tenere traccia delle posizioni che hanno o no un simbolo
                var flag = 0
                //txt è l'id dato a grid_view
                t = view.findViewById(R.id.txt)
                /*Lo faccio per 9 volte perché io prima preimposto questa cosa di far apparire
             *il Toast, poi se ci clicco davvero compare.
             */
                for (j in 0..8) {
                    //cosa succede se clicco su una posizione che già ha un simbolo
                    if (checkedp1[position] == 1 || checkedp2[position] == 1) {
                        flag = 1
                        Toast.makeText(context, "Posizione già occupata", 2000).show()
                        break
                    }
                }
                //se invece la posizione è libera:
                if (flag == 0) {
                    //in questo modo stabilisco i turni (i pari tocca ad P1, i dispari a P2)
                    if (i % 2 == 0) {
                        //Turni pari: tocca a p1 ed imposto il simbolo sulla posizione occupata uguale a quello di p1
                        t.setText(p1)
                        //flaggo la posizione scelta con il valore 1
                        checkedp1[position] = 1

                    } else {
                        //se è un turno dispari tocca a p2 ed eseguo le stesse operazioni
                        t.setText(p2)
                        checkedp2[position] = 1
                    }
                    //controllo se qualcuno ha vinto, il metodo check è definito sotto
                    check(checkedp1, checkedp2)
                    //passo al turno successivo
                    i = i + 1

                }
            }
        }
    }

    //metodo che controlla se qualcuno ha vinto: per farlo valuto tutte le posizioni che devono essere occupate
    //dallo stesso simbolo secondo le regole del tris per entrambi i giocatori. Se qualcuno ha vinto parte la schermata
    //di vittoria attraverso gli Intent. Il metodo putExtra in questo caso serve a tenere memoria del giocatore vincitore.
    fun check(p1: IntArray, p2: IntArray) {
        //variabili: winner per far apparire chi ha vinto
        //flag: valore intero che fa scattare l'intent nel caso di vittoria di uno dei 2 giocatori
        lateinit var winner: String
        var flag = 0
        if (p1[0] == 1 && p1[4] == 1 && p1[8] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[2] == 1 && p1[4] == 1 && p1[6] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[0] == 1 && p1[3] == 1 && p1[6] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[1] == 1 && p1[4] == 1 && p1[7] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[2] == 1 && p1[5] == 1 && p1[8] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[0] == 1 && p1[1] == 1 && p1[2] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[3] == 1 && p1[4] == 1 && p1[5] == 1) {
            flag = 1
            winner = "Player 1"
        } else if (p1[6] == 1 && p1[7] == 1 && p1[8] == 1) {
            flag = 1
            winner = "Player 1"
        }

        //player2
        if (p2[0] == 1 && p2[4] == 1 && p2[8] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[2] == 1 && p2[4] == 1 && p2[6] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[0] == 1 && p2[3] == 1 && p2[6] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[1] == 1 && p2[4] == 1 && p2[7] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[2] == 1 && p2[5] == 1 && p2[8] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[0] == 1 && p2[1] == 1 && p2[2] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[3] == 1 && p2[4] == 1 && p2[5] == 1) {
            flag = 1
            winner = "Player 2"
        } else if (p2[6] == 1 && p2[7] == 1 && p2[8] == 1) {
            flag = 1
            winner = "Player 2"
        }

        if (flag == 1) {
            val vic = Intent(this@Gioco_Tris, Vittoria_Tris::class.java)
            vic.putExtra("vincitore", winner)
            startActivity(vic)
        } else if (i == 8)
        //vuol dire che sono finiti i turni e nessuno ha vinto, quindi parte la schermata di pareggio.
        {
            val par = Intent(this@Gioco_Tris, Pareggio_Tris::class.java)
            startActivity(par)
        }
    }
}