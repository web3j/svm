svm_version="0.1.0"

install_svm() {

  echo "Downloading svm..."
  mkdir -p "$HOME/.svm"


  case "$OSTYPE" in
    darwin*)
    BINARY_URL=https://github.com/josh-richardson/svm/releases/download/v${svm_version}/svm-${svm_version}-darwin.tar
    ;;
    linux*)
    BINARY_URL=https://github.com/josh-richardson/svm/releases/download/v${svm_version}/svm-${svm_version}-linux.tar
    ;;
    *)
    echo "Unsupported Operating System"
    exit 1
    ;;
  esac

  if [ "$(curl --write-out "%{http_code}" --silent --output /dev/null "https://github.com/josh-richardson/svm/releases/download/v${svm_version}/svm-${svm_version}.tar")" -eq 302 ]; then
    curl -# -L -o "$HOME/.svm/svm-${svm_version}.tar" "https://github.com/josh-richardson/svm/releases/download/v${svm_version}/svm-${svm_version}.tar"
    echo "Installing svm..."
    tar -xf "$HOME/.svm/svm-${svm_version}.tar" -C "$HOME/.svm"
    echo "Removing downloaded archive..."
    rm "$HOME/.svm/svm-${svm_version}.tar"
  else
    echo "Looks like there was an error while trying to download svm"
    exit 0
  fi
}


install_svm