package tech.richardson.svm.commands

import java.io.File
import java.nio.file.Paths
import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Command
import tech.richardson.svm.Constants

class Alias : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "alias" && len == 2
    }

    override fun execute(args: List<String>): String {
        val instance = SolcInstance(SolcRelease(args.first().trim()), Constants.SVM_PATH)

        return "The version ${instance.solcRelease.version} is not installed."
    }
}
