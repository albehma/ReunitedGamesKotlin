package com.example.aggio.giochiriunitikotlin

/*
Questa classe gestisce il labirinto, specificando le coordinate di ogni casella nello schermo
e definendo se quest'ultima è attraveersabile o meno.
 */

class Labirinto constructor(y: Int, x: Int, value: Boolean) {
    //le coordinate x e y indicano lo spostamento nella casella selezionata
    protected val X = x
    protected val Y = y
    //la variabile free indica se la casella è attraversabile o meno
    protected val free = value

    //questi metodi restituiscono l'informazione richiesta
    public fun giveX(): Int {
        return X
    }

    public fun giveY(): Int {
        return Y
    }

    public fun isFree(): Boolean {
        return free
    }
}