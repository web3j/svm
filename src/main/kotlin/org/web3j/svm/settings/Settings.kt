package org.web3j.svm.settings

import kotlinx.serialization.Serializable

@Serializable
class Settings {
    var lastUsed: String = ""
    val aliases = mutableMapOf<String, String>()
}
