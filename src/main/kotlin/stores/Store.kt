package stores

interface Store {
    fun add(ip: ByteArray)
    fun count(): Long
}