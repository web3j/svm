package tech.richardson.svm.commands

import java.nio.file.Paths
import tech.richardson.svm.Constants

class Ls : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "ls" && len == 0
    }

    override fun execute(args: List<String>): String {
        val currentlyUsedVersion = System.getenv("PATH").split(":")
            .firstOrNull { it.matches(Constants.PATH_MATCH_REGEX) }?.let { Paths.get(it).fileName.toString() }

        Constants.SOLC_INSTALL_DIR.walk().filter { it.isDirectory }.drop(1).forEach { installed ->
            println(installed.name + (installed.name == currentlyUsedVersion).let { if (it) { " (current)" } else "" })
        }
        return "The command completed successfully."
    }
}
