Function svm {
  $temporaryFile=New-TemporaryFile
  $env:TEMPFILE=$temporaryFile; java -jar build/libs/svm-1.0-SNAPSHOT-all.jar $args
  $exit_code=$?
  Remove-Item Env:\TEMPFILE
  $result = Get-Content "$temporaryFile"
  Invoke-Expression $result
  return ${exit_code}
}

svm setup | Out-Null
