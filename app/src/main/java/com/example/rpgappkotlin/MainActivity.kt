package com.example.rpgappkotlin


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


//    fun sortear(view: View){
//        val textResultado = findViewById<TextView>(R.id.text_resultado)
//        val numero = Array<Int>(9) { 0 }
//        val results = arrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
//
//        results.forEach { textResultado.setText(numero.joinToString()) }

//        textResultado.setText(numero.joinToString())

    fun sortear(view: View) {
        val textResultado = findViewById<TextView>(R.id.text_resultado)
        val textAllRolls = findViewById<TextView>(R.id.text_allrolls)

        // Sorteia 10 números entre 0 e 10
        val results = Array(10) { (0..10).random() }

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
            textAllRolls.text = results.joinToString()

            //text_allrolls
        }
    }



}