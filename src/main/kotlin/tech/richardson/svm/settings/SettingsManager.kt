package tech.richardson.svm.settings

import java.io.File
import java.nio.file.Paths
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import tech.richardson.svm.Constants

class SettingsManager {
    companion object {
        private val settingsFile: File =
            Paths.get(
                System.getProperty("user.home"),
                Constants.SVM_PATH,
                "settings.json"
            ).toFile()

        fun loadSettings(): Settings {
            return if (settingsFile.exists()) {
                Json(JsonConfiguration.Stable).parse(Settings.serializer(), settingsFile.readText())
            } else {
                Settings()
            }
        }

        fun saveSettings(settings: Settings) {
            settingsFile.parentFile.mkdirs()
            settingsFile.writeText(Json(JsonConfiguration.Stable).stringify(Settings.serializer(), settings))
        }
    }
}
