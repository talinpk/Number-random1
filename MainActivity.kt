package com.example.jogo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Jogo
    private lateinit var btchute: Button
    private lateinit var menor: TextView
    private lateinit var maior: TextView
    private lateinit var numero: EditText
    private lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        jogo = Jogo(1, 100)
        btchute = findViewById(R.id.btchute)
        menor = findViewById(R.id.menor)
        maior = findViewById(R.id.maior)
        numero = findViewById(R.id.numero)
        status = findViewById(R.id.status)

        btchute.setOnClickListener {
            val chutetext = numero.text.toString()
            if (chutetext.isNotBlank()) {
                val chute = chutetext.toInt()
                jogo.chute(chute)
                status.text = jogo.getStatus()
                menor.text = jogo.getMenor()
                maior.text = jogo.getMaior()
            }
        }

        btchute.setOnLongClickListener {
            val menornum: Int = Random.nextInt(1, 100)
            jogo = Jogo(menornum, menornum + 100)
            jogo.sortear()
            status.text = "Novo jogo, escolha um número"
            menor.text = jogo.getMenor()
            maior.text = jogo.getMaior()
            numero.text.clear()
            true
        }
    }
}
