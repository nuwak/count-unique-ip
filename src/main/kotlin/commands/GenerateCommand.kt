package commands

import utils.GenerateIp

class GenerateCommand(private val args: Array<String>) : Command {
    companion object : Checker {
        const val FLAG = "g"
        const val DESCRIPTION = "Команда генерирует файл со случайными IP адресами. Формат `$FLAG 1000`"
        override fun check(args: Array<String>): Boolean {
            return (args[0] == FLAG) and (args[1].toIntOrNull()?.let { true } ?: false)
        }
    }

    override fun execute() {
        val count = args[1].toInt()
        GenerateIp().generate(count)
            .also { log.info("Сгенерирован файл с IP адресами ips$count.txt") }
    }
}