package storages

interface Storage {
    fun add(ip: ByteArray)
    fun count(): Long
}