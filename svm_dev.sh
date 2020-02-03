svm() {
  temporaryFile=$(mktemp /tmp/svm-eval.XXXXXX)
  TEMPFILE=$temporaryFile ./build/libs/tech.richardson.svm.mainkt "$@"
  local exit_code=$?
  eval "$(cat "$temporaryFile")"
  rm -f "$temporaryFile"
  return ${exit_code}
}

svm setup 1>/dev/null