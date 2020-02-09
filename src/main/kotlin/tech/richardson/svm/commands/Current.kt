package tech.richardson.svm.commands

import java.nio.file.Paths
import tech.richardson.svm.Constants
import java.io.File

class Current : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "current" && len == 0
    }

    override fun execute(args: List<String>): String {
        return System.getenv("PATH").split(File.pathSeparator).firstOrNull { it.matches(Constants.PATH_MATCH_REGEX) }
            .let { if (it == null) "svm is not active" else Paths.get(it).fileName.toString() }
    }
}
