package tech.richardson.svm

import tech.richardson.svm.commands.Install
import tech.richardson.svm.commands.Ls
import tech.richardson.svm.commands.LsRemote
import kotlin.system.exitProcess

fun main(vararg args: String) {
    if (args.isEmpty()) {
        exitProcess(1);
    }

    val commands = arrayListOf(LsRemote(), Ls(), Install())

    commands.firstOrNull { it.matches(args.first()) }?.execute(args.drop(1))

}