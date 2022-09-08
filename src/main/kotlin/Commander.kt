import commands.Command
import commands.CountCommand
import commands.GenerateCommand
import utils.measure

class Commander(private val args: Array<String>) : Command {
    private val commands = mapOf(
        CountCommand.FLAG to CountCommand.DESCRIPTION,
        GenerateCommand.FLAG to GenerateCommand.DESCRIPTION,
    )

    override fun execute() {
        if (args.size < 2) {
            log.error("Необходимо передать минимум два аргумента")
            listCommands()
            return
        }
        measure {
            when {
                CountCommand.check(args) -> CountCommand(args).execute()
                GenerateCommand.check(args) -> GenerateCommand(args).execute()
                else -> log
                    .warn("Команда не найдена: " + args.joinToString(" "))
                    .also { listCommands() }
            }
        }
    }

    private fun listCommands() {
        commands
            .map { (flag, desc) -> "$flag - $desc" }
            .joinToString("\n")
            .also{ println(it) }
    }
}