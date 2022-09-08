package stores

import utils.IpParser
import kotlin.math.absoluteValue

class LongArrayStore : Store {
    private val store: LongArray = LongArray(Int.MAX_VALUE + Int.MIN_VALUE.absoluteValue)

    override fun add(ip: ByteArray) {
        store[IpParser.getUInt(ip)] = 1
    }

    override fun count() = store.sum()
}