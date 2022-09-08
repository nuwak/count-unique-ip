package commands

import utils.Log

interface Command: Log {
    fun execute()
}