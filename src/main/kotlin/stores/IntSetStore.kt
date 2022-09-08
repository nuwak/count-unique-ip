package stores

import utils.IpParser

class IntSetStore : Store {
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