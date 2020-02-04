#!/bin/bash
set -e
curl -sL https://github.com/shyiko/jabba/raw/master/install.sh | bash && . ~/.jabba/jabba.sh
jabba install graalvm@19.3.1
gu install native-image

ls
./generate_native_image.sh
source ./svm_dev.sh
svm ls-remote
svm install 0.5.11
svm use 0.5.11
solc --version

exit 0