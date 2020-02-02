package tech.richardson.svm.commands

import tech.richardson.svm.Constants

class Ls : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "ls" && len == 0
    }

    override fun execute(args: List<String>): String {
        Constants.SOLC_INSTALL_DIR.walk().filter { it.isDirectory }.drop(1).forEach {
            println(it.name)
        }
        return "The command completed successfully."
    }
}
