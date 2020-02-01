package tech.richardson.svm.commands

import tech.richardson.svm.Command
import org.web3j.sokt.VersionResolver

class LsRemote : Command {
    override fun matches(arg: String): Boolean {
        return arg.trim() == "ls-remote"
    }

    override fun execute(args: List<String>) {
        val resolver = VersionResolver()
        resolver.getSolcReleases().filter { it.isCompatibleWithOs() }.map { it.version }.forEach { println(it) }
    }
}