package tech.richardson.svm

import java.io.File
import java.nio.file.Paths

class Constants {
    companion object {
        const val SVM_PATH = ".svm"
        val SOLC_INSTALL_DIR: File = Paths.get(System.getProperty("user.home"), ".svm", "solc").toAbsolutePath().toFile()
        val USAGE = """
            Solidity Version Manager (https://github.com/josh-richardson/svm).

            Usage:
              svm [command]

            Available Commands:
              install <version>         Download and install Solidity
              uninstall <version>       Uninstall Solidity
              use <version>             Modify PATH to use specific Solidity version
              current                   Display currently 'use'ed version
              ls                        List installed versions
              ls-remote                 List remote versions available for install
              alias <name> <version>    Resolve or update an alias
              unalias <name>            Delete an alias
              deactivate                Deactivates svm in the current shell
        """.trimIndent()

        private val EXISTING_PATH_FRAGMENT = Paths.get(SVM_PATH, "solc").toString() + File.separator

        val PATH_MATCH_REGEX = Regex(".*.$EXISTING_PATH_FRAGMENT(\\d|.)*")
    }
}
