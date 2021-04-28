package com.example.aggio.giochiriunitikotlin

/**
 * classe per gestione dell'algoritmo di controllo delle caselle e spostamento
 * una volta indicata la matrice, vengono richiamati i metodi in base al pulsante premuto
 * e in base alla posizione attuale, anch'eesa passata per parametro, questa classe restituisce
 * un valore true in caso di mossa valida o false in caso di mossa non valida.
 */
class Gioca_Labirinto constructor(lab: Array<Array<Labirinto>> ) {
    protected val map = lab
    //metodo per movimento verso sinistra, restituisco falso se sono in una delle caselle all'estrema
    // sinistra o nel caso che la casella alla nostra sinistra sia non attraversabile
    fun left(r: Int, c: Int) : Boolean{
        return if (r > 4 || c > 3)
            false
        else if (c == 0)
            false
        else
            return map[r][c - 1].isFree()
    }

    //metodo per movimento verso destra, restituisco falso se sono in una delle caselle all'estrema
    // destra o nel caso che la casella alla nostra destra sia non attraversabile
    fun right(r: Int, c: Int) : Boolean{
        return if (r > 4 || c > 3)
            false
        else if (c == 3)
            false
        else
            return map[r][c + 1].isFree()
    }

    //metodo per movimento verso su, restituisco falso se sono in una delle caselle di riga = 0
    //  o nel caso che la casella sopra di noi sia non attraversabile
    fun up(r: Int, c: Int): Boolean {
        return if (r > 4 || c > 3)
            false
        else if (r == 0)
            false
        else
            return map[r - 1][c].isFree()
    }

    //metodo per movimento verso giu, restituisco falso se sono in una delle caselle di riga finale
    //  o nel caso che la casella sotto di noi sia non attraversabile
    fun down(r: Int, c: Int): Boolean {
        return if (r > 4 || c > 3)
            false
        else if (r == 4)
            false
        else
            return map[r + 1][c].isFree()
    }
}