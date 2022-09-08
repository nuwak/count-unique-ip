package stores

class PairStore : Store {
    private val store: MutableList<Pair<Byte, MutableList<Pair<Byte, MutableList<Pair<Byte, MutableList<Byte>>>>>>> =
        mutableListOf()

    private var counter = 0L

    override fun add(ip: ByteArray) {
        val byte0 = store.find { (byte, _) -> byte == ip[0] }?.second
        if (byte0 == null) {
            store.add(ip[0] to mutableListOf(ip[1] to mutableListOf(ip[2] to mutableListOf(ip[3]))))
            counter++
            return
        }
        val byte1 = byte0.find { (byte, _) -> byte == ip[1] }?.second
        if (byte1 == null) {
            byte0.add(ip[1] to mutableListOf(ip[2] to mutableListOf(ip[3])))
            counter++
            return
        }
        val byte2 = byte1.find { (byte, _) -> byte == ip[2] }?.second
        if (byte2 == null) {
            byte1.add(ip[2] to mutableListOf(ip[3]))
            counter++
            return
        }
        byte2.find { byte -> byte == ip[3] } ?: run {
            byte2.add(ip[3])
            counter++
        }
    }

    override fun count(): Long {
        return counter
    }
}