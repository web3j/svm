package tech.richardson.svm.commands

import org.web3j.sokt.SolcInstance
import org.web3j.sokt.VersionResolver
import tech.richardson.svm.Command
import tech.richardson.svm.Constants

class Install : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "install" && len == 1
    }

    override fun execute(args: List<String>): String {
        val resolver = VersionResolver(Constants.SVM_PATH)
        val query = args.first()
        resolver.getSolcReleases().filter { it.version.trim() == query }.forEach {
            val instance = SolcInstance(it, Constants.SVM_PATH)
            return if (!instance.installed()) {
                if (instance.install()) {
                    "Version ${it.version} installed successfully."
                } else {
                    "The installation failed to complete successfully."
                }
            } else {
                "This version is already installed!"
            }
        }
        return "No remote version could be found for the query: $query"
    }
}
