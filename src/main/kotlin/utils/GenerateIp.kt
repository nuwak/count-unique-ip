package utils

import java.io.File
import java.lang.StringBuilder

class GenerateIp {
    fun generate(size: Int) {
//        todo нужен ли здесь StringBuilder
        val ips = StringBuilder()
        (0 until size).forEach { _ ->
            val ip = getRandomIP()
            (0..(0..2).random()).forEach { _ ->
                ips.append(ip + "\n")
            }
        }

        File("ips$size.txt").writeText(ips.toString())
    }

    private fun getRandomIP(): String =
        (0..3).map { (0..255).random() }.joinToString(".")
}

fun main() = GenerateIp().generate(1000_000)
