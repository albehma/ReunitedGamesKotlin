package com.example.aggio.giochiriunitikotlin

/**
 * Tiene in considerazione delle coordinate in pixel della posizione del pulsante della risposta
 * corretta
 */

class Coordinate_Differenze(X : Int, Y : Int, name1: Int, name2 : Int){
    //coordinate per la posizione dell'errore sull'immagine
    val x = X
    val y = Y
    //nome dell'immagine senza soluzione e con la soluzione
    val name = name1
    val nameC = name2

    //nameC sta ad indicare l'immagine con la correzione cerchiata
    //questi metodi ritornano le informazioni richieste
    fun giveX() : Int{
        return x
    }
    fun giveY() : Int{
        return y
    }
    fun giveName() : Int{
        return name
    }
    fun giveNameC() : Int{
        return nameC
    }
}