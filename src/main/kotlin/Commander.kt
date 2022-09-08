import commands.*
import utils.Measure

class Commander(private val args: Array<String>) : Command, Measure {
    private val commands = mapOf(
        CountCommand.FLAG to CountCommand.DESCRIPTION,
        GenerateCommand.FLAG to GenerateCommand.DESCRIPTION,
        SetCommand.FLAG to SetCommand.DESCRIPTION,
        PairCommand.FLAG to PairCommand.DESCRIPTION,
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
                SetCommand.check(args) -> SetCommand(args).execute()
                PairCommand.check(args) -> PairCommand(args).execute()
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