package org.web3j.svm.commands

import java.io.File
import org.web3j.svm.Constants

class Deactivate : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "deactivate" && len == 0
    }

    override fun execute(args: List<String>): String {
        val path = System.getenv("PATH").split(File.pathSeparator).filter { !it.matches(Constants.PATH_MATCH_REGEX) }.joinToString(File.pathSeparator)
        File(System.getenv("TEMPFILE")).writeText("export PATH=$path")
        return "svm has been decativated."
    }
}
