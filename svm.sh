beginswith() { case $2 in "$1"*) true;; *) false;; esac; }

svm() {
  output=$(java -jar ./build/libs/svm-1.0-SNAPSHOT-all.jar "$@")


  if beginswith "export" "$output"; then
    eval "$output"
  else
    echo "$output"
  fi
}

setup() {
  output=$(java -jar ./build/libs/svm-1.0-SNAPSHOT-all.jar setup)
  eval "$output"
}

setup