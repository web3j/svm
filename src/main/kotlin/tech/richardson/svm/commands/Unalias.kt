package tech.richardson.svm.commands

import tech.richardson.svm.settings.Settings

class Unalias(private val settings: Settings) : Command {
    override fun matches(arg: String, len: Int): Boolean {
        return arg == "unalias" && len == 1
    }

    override fun execute(args: List<String>): String {
        if (settings.aliases.containsKey(args.first().trim())) {
            settings.aliases.remove(args.first().trim())
            return "Alias removed."
        }
        return "Alias not found."
    }
}
