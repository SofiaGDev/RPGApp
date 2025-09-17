package com.example.rpgappkotlin

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AppRoll : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_app_roll)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun change_roll_activity(view: View) {
        val changeToRollPage = findViewById<Button>(R.id.change_roll_activity)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun sortear(view: View) {
        val textResultado = findViewById<TextView>(R.id.text_resultado2)
//        val textAllRolls = findViewById<TextView>(R.id.text_allrolls2)
        val warningText = findViewById<TextView>(R.id.warning_text2)
        val inputText = findViewById<EditText>(R.id.input_text4)

        //val inputInt = inputText.text.toString().toInt()
        var inputInt = 0
        if (inputText.text.toString() != "")
        {
            inputInt = inputText.text.toString().toInt()
            if (inputInt > 20){
                warningText.text = "You cannot roll more than 20 dices, your pool was changed to 20"
            }else {
                warningText.text = ""
            }

        }
        else inputInt = 0


        // Sorteia o numero escolhido


        val results = Array(inputInt) { (0..10).random() }

        // Agrupa e conta quantas vezes cada número diferente de 0 aparece
        val contagem = results.filter { it != 0 }
            .groupingBy { it }
            .eachCount()

        // Verifica se houve algum número diferente de 0
        if (contagem.isEmpty()) {
            textResultado.text = "Nenhum número sorteado"
        } else {
            // Ordena por quantidade
            val resultadoOrdenado = contagem.entries
                .sortedByDescending { it.value } // Ordena pelo valor (quantidade)
                .map { "${it.value}x${it.key}" } // Formata como "NxNúmero"

            // Exibe no TextView


            textResultado.text = resultadoOrdenado.joinToString(", ")
//            textAllRolls.text = results.joinToString()

            //text_allrolls
        }
    }





}