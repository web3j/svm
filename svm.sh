svm() {
  temporaryFile=$(mktemp /tmp/svm-eval.XXXXXX)
  TEMPFILE=$temporaryFile ~/.svm/svm "$@"
  local exit_code=$?
  eval "$(cat "$temporaryFile")"
  rm -f "$temporaryFile"
  return ${exit_code}
}

svm setup 1>/dev/null