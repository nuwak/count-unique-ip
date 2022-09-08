package stores

import utils.IpParser

class MatrixStore : Store {
    private val store = arrayOf(
        Array(256) { 0 },
        Array(256) { 0 },
        Array(256) { 0 },
        Array(256) { 0 }
    )

    private var count = 0L

    override fun add(ip: ByteArray) {
        val check = IntArray(4) { 0 }
        val ipInt = IpParser.toIntArray(ip)
        (0 until 4).forEach {
            check[it] = store[it][ipInt[it]]
        }
        val checkSize = check.toSet().size
        if ((check.sum() == 0) or (checkSize > 1)) {
            (0..3).forEach {
                store[it][ipInt[it]]++
            }
            count++
        }
    }

    // todo мы можем выйти зи диапазона
    override fun count(): Long {
        return count
    }
}