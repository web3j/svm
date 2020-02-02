package tech.richardson.svm

interface Command {

    fun matches(arg: String, len: Int): Boolean

    fun execute(args: List<String>): String
}
