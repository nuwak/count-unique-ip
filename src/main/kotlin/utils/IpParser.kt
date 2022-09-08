package utils

import java.nio.ByteBuffer

object IpParser {
    fun getBytes(str: String): ByteArray {
        val ip = str.split(".")
        require(ip.size == 4) { "IP должен быть в формате x.x.x.x" }
        return ByteArray(4).mapIndexed { i, _ ->
            ip[i]
                .toInt()
                .also { require(it <= 255) { "Кажется это не IP адрес" } }
                .toByte()
        }.toByteArray()
    }

    fun getInt(str: String): Int = ByteBuffer.wrap(getBytes(str)).int
    fun getInt(ipBytes: ByteArray): Int = ByteBuffer.wrap(ipBytes).int
    fun getLong(ipBytes: ByteArray): Long = ByteBuffer.wrap(byteArrayOf(0, 0, 0, 0).plus(ipBytes)).long
    fun getUInt(ipBytes: ByteArray): Int = ByteBuffer.wrap(byteArrayOf(0, 0, 0, 0).plus(ipBytes)).long.toInt()
    fun toIntArray(ipBytes: ByteArray): IntArray = ipBytes.map { it.toInt() and 0xFF }.toIntArray()
}