package tech.richardson.svm.commands

import java.io.File
import org.web3j.sokt.SolcInstance
import org.web3j.sokt.SolcRelease
import tech.richardson.svm.Constants
import tech.richardson.svm.settings.Settings
import kotlin.system.exitProcess

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

            val path = "export PATH=$instanceDirectoryName" + File.pathSeparator + System.getenv("PATH").split(File.pathSeparator)
                .filter { !it.matches(Constants.PATH_MATCH_REGEX) }.joinToString(File.pathSeparator)
            if (Constants.TEMP_FILE?.exists() == true) {
                Constants.TEMP_FILE.writeText(path)
            } else {

                println("Attempted to use a solidity version but did not receive a temporary file to write to. " +
                        "Invocation of sokt should occur from the command-line wrapper function rather than by directly invoking the executable.")
                println("The following should be exported: $path")
                exitProcess(1)
            }

            return "Version ${instance.solcRelease.version} activated."
        }

        return "The version ${instance.solcRelease.version} is not installed."
    }
}
