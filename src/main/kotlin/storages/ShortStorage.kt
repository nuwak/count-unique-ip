package storages

import utils.IpParser
import java.nio.ByteBuffer

class ShortStorage: Storage {
    private val store = Array<MutableList<Short>>(256*256) { mutableListOf() }
    private var counter = 0L
    override fun add(ip: ByteArray) {
        val index: Int = IpParser.getInt(byteArrayOf(0, 0) + byteArrayOf(ip[0], ip[1]))
        val value = ByteBuffer.wrap(byteArrayOf(ip[2], ip[3])).short
        if (value !in store[index]) {
            store[index].add(value)
            counter++
        }
    }

    override fun count(): Long {
        return counter
    }
}