package storages

import utils.IpParser

/**
 * Максимальный размер Set это Int.MAX_VALUE = 2147483647
 * IP адресов может быть 256*256*256*256 = 4294967296, что в два раза больше.
 * Поэтому сделано два сета для положительных и отрицательных чисел.
 */
class SetStorage : Storage {
    private val positiveStore: MutableSet<Int> = mutableSetOf()
    private val negativeStore: MutableSet<Int> = mutableSetOf()

    override fun add(ip: ByteArray) {
        val ipInt = IpParser.getInt(ip)
        if (ipInt > 0)
            positiveStore.add(ipInt)
        else
            negativeStore.add(ipInt)

    }

    override fun count(): Long = positiveStore.size.toLong() + negativeStore.size.toLong()
}