package utils

import java.nio.ByteBuffer

object IpParser {
    fun getBytes(str: String): ByteArray {
        val addrs = str.split(".")
        require(addrs.size == 4) { "ip should be a x.x.x.x" }
        return ByteArray(4).mapIndexed { i, _ ->
            addrs[i]
                .toInt()
                .also { require(it <= 255) { "not a legal ip address" } }
                .toByte()
        }.toByteArray()
    }

    fun getInt(str: String): Int = ByteBuffer.wrap(getBytes(str)).int
    fun getInt(ipBytes: ByteArray): Int = ByteBuffer.wrap(ipBytes).int
    fun getUInt(ipBytes: ByteArray): Int = ByteBuffer.wrap(byteArrayOf(0, 0, 0, 0).plus(ipBytes)).long.toInt()
    fun toIntArray(ipBytes: ByteArray): IntArray = ipBytes.map { it.toInt() and 0xFF }.toIntArray()
}