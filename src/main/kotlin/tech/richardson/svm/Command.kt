package tech.richardson.svm

interface Command {

    fun matches(arg: String): Boolean

    fun execute(args: List<String>)
}