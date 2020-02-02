package tech.richardson.svm

import java.util.prefs.Preferences

class Aliases {
    private val prefs: Preferences = Preferences.userNodeForPackage(this.javaClass)

    fun getAliases(): MutableMap<String, String> {
        val aliasesMap = mutableMapOf<String, String>()
        prefs.keys().filter { it.startsWith("alias_") }.forEach { aliasesMap[it.substring(6)] = prefs.get(it, "") }
        return aliasesMap
    }

    fun setAlias(alias: String, version: String) {
        prefs.put("alias_$alias", version)
    }

    fun removeAlias(alias: String): Boolean {
        return if (prefs.get("alias_$alias", null) != null) {
            prefs.remove("alias_$alias")
            true
        } else {
            false
        }
    }
}
