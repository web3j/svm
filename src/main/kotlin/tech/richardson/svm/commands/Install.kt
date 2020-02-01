package tech.richardson.svm.commands

import org.web3j.sokt.SolcInstance
import org.web3j.sokt.VersionResolver
import tech.richardson.svm.Command
import tech.richardson.svm.Constants
import java.io.File

class Install : Command {
    override fun matches(arg: String): Boolean {
        return arg.trim() == "install"
    }

    override fun execute(args: List<String>) {
        if (args.size == 1) {
            val resolver = VersionResolver(Constants.SVM_PATH)
            resolver.getSolcReleases().filter { it.version.trim() == args.first() }.forEach {
                val instance = SolcInstance(it, Constants.SVM_PATH)
                if (!instance.installed()) {
                    instance.install()
                }
            }
        }
    }

}