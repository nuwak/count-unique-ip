package commands

import IpCounter
import storages.ShortStorage

class CountCommand(private val args: Array<String>) : Command {
    companion object : Checker {
        const val FLAG = "f"
        const val DESCRIPTION = "Команда считает количество уникальных IP. Формат `f filename.txt`"
        override fun check(args: Array<String>): Boolean = (args[0] == FLAG) and args[1].isNotEmpty()
    }

    override fun execute() {
        IpCounter(args[1], ShortStorage()).count()
            .also { log.info("Найдено уникальных IP адресов: $it") }
    }
}