svm_version="0.1.2"

install_svm() {

  echo "Downloading svm..."
  mkdir -p "$HOME/.svm"


  case "$OSTYPE" in
    darwin*)
    BINARY_URL=https://github.com/web3j/svm/releases/download/${svm_version}/svm-darwin.tar
    ;;
    linux*)
    BINARY_URL=https://github.com/web3j/svm/releases/download/${svm_version}/svm-linux.tar
    ;;
    *)
    echo "Unsupported Operating System"
    exit 1
    ;;
  esac

  echo $BINARY_URL
  if [ "$(curl --write-out "%{http_code}" --silent --output /dev/null "$BINARY_URL")" -eq 302 ]; then
    curl -# -L -o "$HOME/.svm/svm.tar" "$BINARY_URL"
    echo "Installing svm..."
    tar -xf "$HOME/.svm/svm.tar" -C "$HOME/.svm"
    echo "Removing downloaded archive..."
    rm "$HOME/.svm/svm.tar"
  else
    echo "Looks like there was an error while trying to download svm"
    exit 0
  fi
}


source_svm() {
  SOURCE_WEB3J="\n[ -s \"$HOME/.svm/svm.sh\" ] && source \"$HOME/.svm/svm.sh\""
  if [ -f "$HOME/.bashrc" ]; then
    bash_rc="$HOME/.bashrc"
    touch "${bash_rc}"
    if ! grep -qc '.svm/svm.sh' "${bash_rc}"; then
      echo "Adding source string to ${bash_rc}"
      printf "${SOURCE_WEB3J}\n" >>"${bash_rc}"
    else
      echo "Skipped update of ${bash_rc} (source string already present)"
    fi
  fi
  if [ -f "$HOME/.bash_profile" ]; then
    bash_profile="${HOME}/.bash_profile"
    touch "${bash_profile}"
    if ! grep -qc '.svm/svm.sh' "${bash_profile}"; then
      echo "Adding source string to ${bash_profile}"
      printf "${SOURCE_WEB3J}\n" >>"${bash_profile}"
    else
      echo "Skipped update of ${bash_profile} (source string already present)"
    fi
  fi
  if [ -f "$HOME/.bash_login" ]; then
    bash_login="$HOME/.bash_login"
    touch "${bash_login}"
    if ! grep -qc '.svm/svm.sh' "${bash_login}"; then
      echo "Adding source string to ${bash_login}"
      printf "${SOURCE_WEB3J}\n" >>"${bash_login}"
    else
      echo "Skipped update of ${bash_login} (source string already present)"
    fi
  fi
  if [ -f "$HOME/.profile" ]; then
    profile="$HOME/.profile"
    touch "${profile}"
    if ! grep -qc '.svm/svm.sh' "${profile}"; then
      echo "Adding source string to ${profile}"
      printf "$SOURCE_WEB3J\n" >>"${profile}"
    else
      echo "Skipped update of ${profile} (source string already present)"
    fi
  fi

  if [ -f "$(command -v zsh 2>/dev/null)" ]; then
    file="$HOME/.zshrc"
    touch "${file}"
    if ! grep -qc '.svm/svm.sh' "${file}"; then
      echo "Adding source string to ${file}"
      printf "$SOURCE_WEB3J\n" >>"${file}"
    else
      echo "Skipped update of ${file} (source string already present)"
    fi
  fi
}

install_svm
source_svm
