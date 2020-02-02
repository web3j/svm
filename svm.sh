svm() {
  temporaryFile=$(mktemp /tmp/svm-eval.XXXXXX)
  TEMPFILE=$temporaryFile java -jar ./build/libs/svm-1.0-SNAPSHOT-all.jar "$@"
  local exit_code=$?
  eval "$(cat "$temporaryFile")"
  rm -f "$temporaryFile"
  return ${exit_code}
}

svm setup 1>/dev/null