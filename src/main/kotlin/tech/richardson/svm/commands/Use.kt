package tech.richardson.svm.commands

import java.io.File
import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Constants
import tech.richardson.svm.settings.Settings

class Use(private val settings: Settings) : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "use" && len == 1
    }

    override fun execute(args: List<String>): String {
        val versionToUse = settings.aliases.getOrDefault(args.first().trim(), args.first().trim())
        val instance = SolcInstance(SolcRelease(versionToUse), Constants.SVM_PATH)
        if (instance.installed()) {
            settings.lastUsed = versionToUse
            val instanceDirectoryName = instance.solcFile.parent

            val path = instanceDirectoryName + ":" + System.getenv("PATH").split(":").filter { !it.matches(Constants.PATH_MATCH_REGEX) }.joinToString(":")
            File(System.getenv("TEMPFILE")).writeText("export PATH=$path")
            return "Version ${instance.solcRelease.version} activated."
        }

        return "The version ${instance.solcRelease.version} is not installed."
    }
}
