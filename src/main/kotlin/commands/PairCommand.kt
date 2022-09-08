package commands

import IpCounter
import storages.PairStorage

class PairCommand(private val args: Array<String>) : Command {
    companion object : Checker {
        const val FLAG = "pair"
        const val DESCRIPTION = "Команда считает количество уникальных IP. Формат `$FLAG filename.txt`"
        override fun check(args: Array<String>): Boolean = (args[0] == FLAG) and args[1].isNotEmpty()
    }

    override fun execute() {
        IpCounter(args[1], PairStorage()).count()
            .also { log.info("Найдено уникальных IP адресов: $it") }
    }
}