package com.example.aggio.giochiriunitikotlin

/*
 * Classe Punteggio: è una classe che definisce in che modo viene assegnato il punteggio
 * in base a come viene data la risposta; viene impostato di defaul = 0, per ogni
 * risposta esatta vengono assegnati 10 punti, per ogni risposta sbagliata ne tolgo 10.
 */

class Punteggio_Impiccato(private var valore: Int) {
    init {
        valore = 0
    }
    fun risposta_esatta() {
        valore = valore + 10
    }

    fun risposta_sbagliata() {
        valore = valore - 10
    }

    fun getPunteggio(): Int {
        return valore
    }
}