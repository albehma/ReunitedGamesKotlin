package com.example.aggio.giochiriunitikotlin

import java.util.*
import kotlin.properties.Delegates

class ParolaDaIndovinare_Impiccato(var word: String) {
    //parola: parola selezionata completa senza trattini
    internal var parola: String by Delegates.notNull()
    var cursore: String = "" //inizializzo la stringa vuota, sulla quale verranno inserite le lettere.
    init {
        parola = word //inizializzo la parola con word che viene generata dalla classe GeneratoreParole
        for (i in 0 until parola.length)
        //per tutte le posizioni della parola:
            cursore = cursore + "_" //cursore alla fine sarà = _ _ _ ..."
        val r = Random() //creo un nuovo oggetto Random
        /*
             * Adesso faccio in modo che la parola all'inizio del gioco contenga già delle lettere
             * di suggerimento: in questo modo viene diminuita la difficoltà del gioco, ma dato
             * che ho impostato 0 come punteggio iniziale, è tutto equilibrato.
             */
        val i1 = r.nextInt(parola.length - 1) //scegli un int a caso tra tutte le posizioni della parola

        insert_letter(parola.substring(i1, i1 + 1)) //la inserisce
    }
    fun insert_letter(letter: String) { //prende come parametro una sola lettera
        for (i in 0 until parola.length)
        //per tutta la lunghezza della parola scelta:
        {
            val c: Char = parola.toLowerCase().get(i) //seleziona tutti i caratteri della parola
            if (c == letter.toLowerCase().toCharArray()[0])
            //se c corrisponde all'unica lettera presa come parametro ([0])
            {
                cursore = cursore.substring(0, i) + c + cursore.substring(i + 1, cursore.length) //la inserisce al posto giusto
            }
        }
    }

    //metodo di controllo che uso nella classe Gioco al fine di poter inserire o no la lettera
    fun letteraSiTrovaNellaParola(lettera: String): Boolean { //metodo per controllare se la lettera scelta è presente nella parola;
        // successivamente dichiarerò che se è presente, allora potrà essere
        val c: Char                                           //essere aggiunta nel cursore.
        c = lettera.toLowerCase().toCharArray()[0] //trasformo la lettera in char

        for (i in 0 until parola.length) {
            val d: Char = parola.toLowerCase()[i] //analizzo tutti i caratteri presenti nella parola
            if (d == c)
            //se c'è corrispondenza
            {
                return true //allora è vero che la lettera è già presente;
            }
        }
        return false //altrimenti non è già presente
    }

    //metodo di controllo che uso nella classe Gioco al fine di poter inserire o no la lettera
    fun letteraGiaSelezionata(letter: String): Boolean { //metodo di controllo; se la lettera è stata già scelta in precedenza
        //restituisce true, altrimenti false.
        val c: Char
        c = letter.toLowerCase().toCharArray()[0] //come prima: trasformo la lettera in un charArray

        for (i in 0 until cursore.length)
        //e per tutta la lunghezza della parola verifico che non sia già stata selezionata
        {
            val w: Char = cursore.toLowerCase()[i]
            if (w == c) {
                return true
            }
        }
        return false
    }

    fun mostra_parola(): String { //questo metodo serve per visualizzare lo stato corrente del gioco:

        //stringa temporanea
        var temp: String = ""
        //per tutta la lunghezza della stringa cursore (che sarebbe quella sulla quale sto giocando)
        for (i in 0 until cursore.length) {
            temp = temp + " " + cursore[i] + " " //restituisci il valore di tutte le posizioni
        }
        temp = temp.substring(1, temp.length - 1)
        return temp
    }

    fun return_parola(): String {
        return parola
    } //restituisce la parola intera

    fun parolaCompletata(): Boolean { //metodo finale per valutare se l'utente ha vinto.
        return cursore.equals(parola)
    } //verifica che la parola corrisponda con cursore, ovvero verifica se le lettere sono state indovinate tutte.
}