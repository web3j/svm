package tech.richardson.svm

import java.io.File
import java.nio.file.Paths

class Constants {
    companion object {
        const val SVM_PATH = ".svm"
        val SOLC_INSTALL_DIR: File = Paths.get(System.getProperty("user.home"), ".svm", "solc").toAbsolutePath().toFile()
    }
}
