package org.web3j.svm

import kotlin.system.exitProcess
import org.web3j.svm.commands.Alias
import org.web3j.svm.commands.Current
import org.web3j.svm.commands.Deactivate
import org.web3j.svm.commands.Install
import org.web3j.svm.commands.Ls
import org.web3j.svm.commands.LsRemote
import org.web3j.svm.commands.Setup
import org.web3j.svm.commands.Unalias
import org.web3j.svm.commands.Uninstall
import org.web3j.svm.commands.Use
import org.web3j.svm.settings.SettingsManager

fun main(vararg args: String) {
    if (args.isEmpty()) {
        println(Constants.USAGE)
        exitProcess(1)
    }
    val settings = SettingsManager.loadSettings()

    val commands = arrayListOf(Alias(settings), Unalias(settings), Setup(settings), LsRemote(), Ls(), Install(settings), Uninstall(), Use(settings), Deactivate(), Current())

    val result = commands.firstOrNull { it.matches(args.first().toLowerCase().trim(), args.drop(1).size) }?.execute(args.drop(1))
    if (result != null) {
        println(result)
    } else {
        println("Invalid command. Available commands are as follows:")
        println(Constants.USAGE)
    }

    SettingsManager.saveSettings(settings)
}
