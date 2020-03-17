package org.web3j.svm.commands

import org.web3j.svm.settings.Settings

class Setup(private val settings: Settings) : Command {

    override fun matches(arg: String, len: Int): Boolean {
        return arg == "setup" && len == 0
    }

    override fun execute(args: List<String>): String {
        val default = settings.aliases.getOrDefault("default", settings.lastUsed)
        if (!default.isBlank()) {
            return Use(settings).execute(arrayListOf(default))
        }
        return ""
    }
}
