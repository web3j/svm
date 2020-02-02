# tested with graalvm 19.3.1
./gradlew spotlessApply
./gradlew build
./gradlew shadowJar
cd "build/libs" || exit
native-image -cp svm-1.0-SNAPSHOT-all.jar tech.richardson.svm.MainKt --no-fallback --enable-https