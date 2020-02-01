package tech.richardson.svm.commands

import tech.richardson.svm.Command
import tech.richardson.svm.Constants

class Ls : Command {
    override fun matches(arg: String): Boolean {
        return arg.trim() == "ls"
    }

    override fun execute(args: List<String>) {
        Constants.SOLC_INSTALL_DIR.walk().filter { it.isDirectory }.drop(1).forEach {
            println(it)
        }
    }

}