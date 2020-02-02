package tech.richardson.svm.commands

import java.io.File
import java.nio.file.Paths
import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Command
import tech.richardson.svm.Constants

class Use : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "use" && len == 1
    }

    override fun execute(args: List<String>): String {
        val instance = SolcInstance(SolcRelease(args.first().trim()), Constants.SVM_PATH)
        if (instance.installed()) {
            val instanceDirectoryName = instance.solcFile.parent

            val potentialExistingPathFragment = Paths.get(Constants.SVM_PATH, "solc").toString() + File.separator

            val pathMatchRegex = Regex(".*.$potentialExistingPathFragment(\\d|.)*")

            val path = instanceDirectoryName + ":" + System.getenv("PATH").split(":").filter { !it.matches(pathMatchRegex) }.joinToString(":")
            return "export PATH=$path"
        }

        return "The version ${instance.solcRelease.version} is not installed."
    }
}
