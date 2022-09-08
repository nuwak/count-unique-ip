package commands

interface Checker {
    fun check(args: Array<String>): Boolean
}