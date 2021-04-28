package com.example.aggio.giochiriunitikotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.util.*


//Classe principale
class Principale_Puzzle15: AppCompatActivity() {

    //Metodo principale
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principale__puzzle15)
        val randomArray:Array<String> //Definisco il mio array casuale
        val CountField = findViewById<TextView>(R.id.countShow) //Associo a una variabile di tipo TextView il countShow definito in activity_main
        val reloadBtn = findViewById<Button>(R.id.reloadBtn) //Associo a una variabile di tipo Button il reloadBtn definito in activity_main
        //Costruisco il mio array di confronto
        val startArray = arrayOf<String>("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "0")
        if (nextTurnArray == null)
        {
            // Creo e ritorno il mio array randomizzato
            randomArray = RandomizeArray(startArray)
        }
        else
        {
            randomArray = nextTurnArray as Array<String> //L'array ottenuto è l'array randomizzato
            turnCount += 1 //Incremento il numero di turni
            CountField.setText("Count of turns: " + (turnCount).toString()) //Stampo il numero di turni
            //Controllo se l'array randomizzato è uguale all'array di confronto
            if (Arrays.equals(startArray, randomArray))
            {
                CountField.setText("You win!!! You make " + (turnCount).toString() + " turns") //Nel caso che entrambi coincidano stampo "You win + numero di turni"
                reloadBtn.setVisibility(View.VISIBLE) //Rendo visibile il pulsante di reload
                reloadBtn.setOnClickListener(object: View.OnClickListener {
                    override fun onClick(v: View) {
                        finish() //Se viene premuto il pulsante di reload termino l'activity
                        turnCount = -1 //Resetto il contatore dei turni
                        RandomizeArray(randomArray) //Randomizzo il mio array di nuovo
                        startActivity(getIntent())//Riinizio l'activity
                    }
                })
            }
        }
        // Generazione del campo di gioco e restituzione dell'ID del pulsante zero.
        val zeroBtnID = GameFieldGenerator(randomArray)
        // Impostazione dei 4 tasti selezionabili e risistemazione dell'array dopo il tasto premuto.
        SetPressedKeys(zeroBtnID, randomArray)
    }

    //Crea il nuovo array randomizzato per inizializzare il gioco.
    fun RandomizeArray(startArray:Array<String>):Array<String> {
        val randomArray = startArray
        val random = Random()
        for (i in randomArray.size - 1 downTo 1) {
            val j = random.nextInt(i + 1)
            val temp = randomArray[i]
            randomArray[i] = randomArray[j]
            randomArray[j] = temp
        }
        return randomArray
    }

    //Genera il nuovo campo di gioco con l'array randomizzato
    fun GameFieldGenerator(randomArray:Array<String>):String {
        var numberButton = 0
        var firstIndex = 1
        var zeroBtnID = "0"
        //Attraverso un doppio ciclo for inizializzo il mio campo di gioco di dimensione 4x4
        for (i in 0..3)
        {
            var j = 0
            while (j < 4)
            {
                val secondIndex = j + 1
                val buttonID = "c" + ((firstIndex).toString()) + "x" + ((secondIndex).toString())
                val resID = getResources().getIdentifier(buttonID, "id", getPackageName())
                val btnID = findViewById<Button>(resID)
                btnID.setText(randomArray[numberButton])
                if (Integer.valueOf(randomArray[numberButton]) == 0)
                {
                    btnID.setVisibility(View.INVISIBLE)//Rendo invisibile il bottone con numero 0
                    zeroBtnID = buttonID//Salvo l'id del bottone 0
                }
                numberButton++
                j++
            }
            firstIndex++
        }
        return zeroBtnID
    }

    //Impostazione dei pulsanti
    fun SetPressedKeys(zeroBtnID:String, randomArray:Array<String>) {
        var aroundButtonH1 = "0"
        var aroundButtonW1 = "0"
        var aroundButtonH2 = "0"
        var aroundButtonW2 = "0"
        //Controllo la posizione del zeroBtn e verifico i bottoni circostanti
        if (zeroBtnID != "0")
        {
            val firstIndex = (zeroBtnID.get(1)).toString()
            val secondIndex = (zeroBtnID.get(3)).toString()
            val aroundCellH1 = Integer.valueOf(secondIndex) - 1
            val aroundCellH2 = Integer.valueOf(secondIndex) + 1
            val aroundCellW1 = Integer.valueOf(firstIndex) - 1
            val aroundCellW2 = Integer.valueOf(firstIndex) + 1
            if (aroundCellH1 < 5 && aroundCellH1 > 0)
            {
                aroundButtonH1 = "c" + firstIndex + "x" + aroundCellH1
            }
            if (aroundCellH2 < 5 && aroundCellH2 > 0)
            {
                aroundButtonH2 = "c" + firstIndex + "x" + aroundCellH2
            }
            if (aroundCellW1 < 5 && aroundCellW1 > 0)
            {
                aroundButtonW1 = "c" + aroundCellW1 + "x" + secondIndex
            }
            if (aroundCellW2 < 5 && aroundCellW2 > 0)
            {
                aroundButtonW2 = "c" + aroundCellW2 + "x" + secondIndex
            }
        }
        val aroundButtons = arrayOf<String>(aroundButtonW1, aroundButtonH1, aroundButtonW2, aroundButtonH2)
        //Cambio posizione al bottone premuto.
        var n = 0
        while (n < aroundButtons.size)
        {
            val stringID = getResources().getIdentifier(aroundButtons[n], "id", getPackageName())
            val ButtonNumID = findViewById<Button>(stringID)
            if (aroundButtons[n] != "0")
            {
                val keyIndex = n
                ButtonNumID.setOnClickListener(object: View.OnClickListener {
                    override fun onClick(v: View) {
                        ChangePosition(aroundButtons[keyIndex], randomArray)
                    }
                })
            }
            n++
        }
    }

    //Metodo per cambiare posizione dei bottoni
    fun ChangePosition(pressedKeyName:String, randomArray:Array<String>) {
        val valuePressedKey:String
        var zeroKeyPos: Int? = null
        var pressedKeyPos: Int? = null
        val pressedID = getResources().getIdentifier(pressedKeyName, "id", getPackageName())
        val pressedBtn = findViewById<Button>(pressedID)
        valuePressedKey = pressedBtn.text.toString()//Mi salvo il valore del bottone premuto
        //Tramite il ciclo for e relative condizioni if ricompongo il nuovo campo di gioco con le posizioni cambiate
        var posNum = 0
        for (n in randomArray.indices)
        {
            if (randomArray[n] == valuePressedKey)
            {
                pressedKeyPos = posNum
            }
            if (randomArray[n] == "0")
            {
                zeroKeyPos = posNum
            }
            posNum++
        }
        if (pressedKeyPos != null && zeroKeyPos != null)
        {
            val temp = randomArray[pressedKeyPos]
            randomArray[pressedKeyPos] = randomArray[zeroKeyPos]
            randomArray[zeroKeyPos] = temp
        }
        nextTurnArray = randomArray
        recreate()
    }
    companion object {
        var nextTurnArray: Array<String>? = null //definisco un array di tipo String globale
        private var turnCount = 0 //definisco la variabile globale che utilizzo per contare il numero di turni
    }
}