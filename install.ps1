Set-StrictMode -Version Latest
$ErrorActionPreference = "Stop"
$PSDefaultParameterValues['*:ErrorAction']='Stop'
[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12
$ProgressPreference = 'SilentlyContinue'

$svm_version="0.1.2"
$svm_home="$env:USERPROFILE\.svm"
New-Item -Force -ItemType directory -Path $svm_home | Out-Null
Write-Host "Downloading svm version $svm_version"
Invoke-WebRequest https://github.com/josh-richardson/svm/releases/download/${svm_version}/svm-windows.zip -UseBasicParsing -OutFile $svm_home\svm.zip
Write-Host "Extracting svm version $svm_version"
Expand-Archive -Path "${env:USERPROFILE}\.svm\svm.zip" -DestinationPath $svm_home -Force

$sourceSvm="if (Test-Path `"$svm_home\svm.ps1`") { . `"$svm_home\svm.ps1`" }"

if (-not $(Test-Path $profile))
{
  New-Item -path $profile -type file -force | Out-Null
}

if ("$(Get-Content $profile | Select-String "\\svm.ps1")" -eq "")
{
  Write-Host "Adding source string to $profile"
  echo "`n$sourceSvm`n" >> "$profile"
}
else
{
  Write-Host "Skipped update of $profile (source string already present)"
}

. "$svm_home\svm.ps1"

svm setup | Out-Null

Write-Host ""
Write-Host "Installation completed"

