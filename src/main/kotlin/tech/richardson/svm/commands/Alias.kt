package tech.richardson.svm.commands

import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Constants
import tech.richardson.svm.settings.Settings

class Alias(private var settings: Settings) : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "alias" && (len == 2 || len == 0)
    }

    override fun execute(args: List<String>): String {
        if (args.isEmpty()) {
            return settings.aliases.map { "${it.key}: ${it.value}" }.joinToString(System.lineSeparator())
        }

        val instance = SolcInstance(SolcRelease(args[1].trim()), Constants.SVM_PATH)
        if (instance.installed()) {
            settings.aliases[args[0].trim()] = instance.solcRelease.version
            return "Alias added successfully."
        }
        return "The version ${instance.solcRelease.version} is not installed."
    }
}
