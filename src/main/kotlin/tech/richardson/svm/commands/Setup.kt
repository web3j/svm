package tech.richardson.svm.commands

import tech.richardson.svm.Command


class Setup : Command {


    override fun matches(arg: String, len: Int): Boolean {
        return arg == "setup" && len == 0
    }

    override fun execute(args: List<String>): String {

        return "Executed setup"
    }
}
