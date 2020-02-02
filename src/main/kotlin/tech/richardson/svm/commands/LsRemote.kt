package tech.richardson.svm.commands

import org.web3j.sokt.VersionResolver

class LsRemote : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "ls-remote" && len == 0
    }

    override fun execute(args: List<String>): String {
        VersionResolver().getSolcReleases().filter { it.isCompatibleWithOs() }.map { it.version }.forEach { println(it) }
        return "The command completed successfully"
    }
}
