import storages.*
import utils.IpParser
import utils.Log
import java.io.File

class IpCounter(filePath: String, private val storage: Storage) : Log {
    private val file: File

    init {
        file = File(filePath)
        require(file.isFile) { "$filePath is not file.".also { log.error(it) } }
    }

    fun count(): Long {
        file.forEachLine { ip ->
            IpParser
                .getBytes(ip)
                .also(storage::add)
        }
        return storage.count()
    }
}