package com.example.jogo

import kotlin.random.Random

class Jogo(private var numeroMenor: Int, private var numeroMaior: Int) {

    private var numeroEscolhido: Int = sortear()

    private var status: String = "Novo jogo, escolha um número"

    fun sortear(): Int {
        return Random.nextInt(numeroMenor, numeroMaior + 1)
    }

    fun getStatus(): String {
        return status
    }

    fun chute(numero: Int) {
        if (numero < numeroMenor || numero > numeroMaior) {
            status = "Game Over"
        } else if (numero > numeroEscolhido) {
            numeroMaior = numero
            status = "O número que você chutou é maior do que o número sorteado, tente novamente!"
        } else if (numero < numeroEscolhido) {
            numeroMenor = numero
            status = "O número que você chutou é menor que o número sorteado, tente novamente!"
        } else {
            status = "Você Ganhou!"
        }
    }
}
