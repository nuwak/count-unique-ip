package utils

import java.io.File
import java.lang.StringBuilder

class GenerateIp {
    fun generate(size: Int) {
        val ips = StringBuilder()
        (0 until size).forEach { _ ->
            (0..(0..2).random()).forEach { _ ->
                ips.append(getRandomIP() + "\n")
            }
        }

        File("ips$size.txt").writeText(ips.toString())
    }

    private fun getRandomIP(): String =
        (0..3).map { (0..255).random() }.joinToString(".")
}
