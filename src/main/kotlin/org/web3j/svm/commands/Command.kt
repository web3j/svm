package org.web3j.svm.commands

interface Command {

    fun matches(arg: String, len: Int): Boolean

    fun execute(args: List<String>): String
}
