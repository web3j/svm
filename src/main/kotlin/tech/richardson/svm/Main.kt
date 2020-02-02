package tech.richardson.svm

import kotlin.system.exitProcess
import tech.richardson.svm.commands.Alias
import tech.richardson.svm.commands.Install
import tech.richardson.svm.commands.Ls
import tech.richardson.svm.commands.LsRemote
import tech.richardson.svm.commands.Setup
import tech.richardson.svm.commands.Unalias
import tech.richardson.svm.commands.Uninstall
import tech.richardson.svm.commands.Use

fun main(vararg args: String) {
    if (args.isEmpty()) {
        println(Constants.USAGE)
        exitProcess(1)
    }

    val commands = arrayListOf(Alias(), Unalias(), Setup(), LsRemote(), Ls(), Install(), Uninstall(), Use())

    val result = commands.firstOrNull { it.matches(args.first().toLowerCase().trim(), args.drop(1).size) }?.execute(args.drop(1))
    if (result != null) {
        println(result)
    } else {
        println("Invalid command. Available commands are as follows:")
        println(Constants.USAGE)
    }
}
