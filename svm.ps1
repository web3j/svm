Function svm {
  $temporaryFile=New-TemporaryFile
  $env:TEMPFILE=$temporaryFile; java -jar $env:USERPROFILE\.svm\svm-1.0-SNAPSHOT-all.jar $args
  Remove-Item Env:\TEMPFILE
  $result = Get-Content "$temporaryFile"
  if ($result) {
    $result = $result.replace("export PATH=", "`$env:PATH=`"") + "`""
    Invoke-Expression $result
  }
}

svm setup | Out-Null