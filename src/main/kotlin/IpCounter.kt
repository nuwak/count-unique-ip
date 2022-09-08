import stores.*
import utils.IpParser
import utils.Log
import java.io.File

class IpCounter(args: Array<String>) : Log {
    private lateinit var file: File
    private lateinit var store: Store

    init {
        if (args.size == 1) {
            file = File(args[0])
            if (!file.isFile) {
                log.error("${args[0]} is not file.")
            }
        }
    }

    fun count(): Long {
//        store = PairStore()
        store = IntSetStore()
        file.forEachLine { ip ->
            IpParser.getBytes(ip)
                .also(store::add)
        }
        return store.count()
    }
}