package com.example.aggio.giochiriunitikotlin


class Gioco_Impiccato {
    //definisco varibili statiche: voglio che siano visibili a tutte le istanze della classe
    //per poter essere aggiornata di volta in volta; le varibili sono di tipo Punteggio e ParolaDaIndovinare
    internal var genera = Generatore_Parole_Impiccato()
    internal lateinit var score: Punteggio_Impiccato
    internal lateinit var wordToGuess: ParolaDaIndovinare_Impiccato //variabile della parola che verrà scelta casualmente da GeneratoreParole

    //inizializzazione del costruttore
    init {
        score = Punteggio_Impiccato(0)
        wordToGuess = ParolaDaIndovinare_Impiccato(genera.generaParola())
    }
    //definisco il metodo della classe per visualizzare il punteggio, getPunteggio() definito in Punteggio
    fun get_score() : Int {
        return score.getPunteggio()
    }
    //come suggerisce il nome, serve a visualizzare la parola completa, return_parola definito in ParolaDaIndovinare
    fun visualizza_parola_completa(): String {
        return wordToGuess.return_parola()
    }
    //meotodo per visualizzare lo stato corrente del gioco, definito in ParolaDaIndovinare
    fun get_display_word():String {
        return wordToGuess.mostra_parola()
    }
    //meotdo per capire se il gioco è finito: anche questo è definito in ParolaDaIndovinare
    fun parola_completata(): Boolean {
        return wordToGuess.parolaCompletata()
    }
    /*inserimento_lettera: questo metodo usa cinque metodi della classe ParolaDaIndovinare. Ovvero con i primi due
    *controlla se la lettera si trova nella lettera e se non è stata già selezionata, se queste due condizioni
    * sono verificate, allora usa il terzo metodo per inseire la lettera nella/e posizione/e giusta/e.
    * Successivamente aggiorna il punteggio con +10 punti.
    * Infine l'ultimo metodo si usa quando almeno una delle due condizioni prima specificate non sono
    * soddisfatte: in tal caso diminuisce il punteggio del giocatore di 10 punti.
     */
    fun inserimento_lettera(lettera_scelta: String): Boolean {
        if (wordToGuess.letteraSiTrovaNellaParola(lettera_scelta) && !wordToGuess.letteraGiaSelezionata(lettera_scelta)) {
            wordToGuess.insert_letter(lettera_scelta)
            score.risposta_esatta()
            return true
        } else {
            if (wordToGuess.letteraSiTrovaNellaParola(lettera_scelta)) {
                return true
            } else {
                score.risposta_sbagliata()
                return false
            }
        }
    }
}