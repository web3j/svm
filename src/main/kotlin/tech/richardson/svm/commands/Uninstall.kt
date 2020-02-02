package tech.richardson.svm.commands

import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Constants

class Uninstall : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "uninstall" && len == 1
    }

    override fun execute(args: List<String>): String {
            val instance = SolcInstance(SolcRelease(args.first().trim()), Constants.SVM_PATH)
            return if (instance.installed()) {
                if (instance.uninstall()) {
                    "Version ${instance.solcRelease.version} uninstalled successfully."
                } else {
                    "The uninstall operation failed"
                }
            } else {
                "The version ${instance.solcRelease.version} is not installed."
            }
    }
}
