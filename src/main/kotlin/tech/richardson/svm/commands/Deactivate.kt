package tech.richardson.svm.commands

import java.io.File
import java.nio.file.Paths
import tech.richardson.svm.Constants

class Deactivate : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "deactivate" && len == 0
    }

    override fun execute(args: List<String>): String {
        val potentialExistingPathFragment = Paths.get(Constants.SVM_PATH, "solc").toString() + File.separator
        val pathMatchRegex = Regex(".*.$potentialExistingPathFragment(\\d|.)*")
        val path = System.getenv("PATH").split(":").filter { !it.matches(pathMatchRegex) }.joinToString(":")
        File(System.getenv("TEMPFILE")).writeText("export PATH=$path")

        return "Svm has been decativated."
    }
}
