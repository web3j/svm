# svm [![Build Status](https://travis-ci.org/josh-richardson/svm.svg?branch=master)](https://travis-ci.org/josh-richardson/svm)

Solidity Version Manager inspired by nvm & jabba. Written in Kotlin & Java, but available with no dependencies as a native image thanks to GraalVM.

Allows for you to easily install & switch between different versions of the Solidity compiler (solc) from the Terminal. Supports Linux and macOS, Windows support coming soon. Unlike other version managers for Solidity, svm is not a wrapper, has no dependencies, and is able to download native images to run directly on Linux, macOS and Windows, without any extra compilation required.

### Installation:
Linux & macOS:
```bash
curl -L https://github.com/josh-richardson/svm/raw/master/install.sh | bash && source ~/.svm/svm.sh
```

Windows:
```
coming soon :)
```


### Usage:
```
Solidity Version Manager (https://github.com/josh-richardson/svm).

Usage:
  svm [command]

Available Commands:
  install <version>         Download and install Solidity
  uninstall <version>       Uninstall Solidity
  use <version>             Modify PATH to use specific Solidity version
  current                   Display currently 'use'ed version
  ls                        List installed versions
  ls-remote                 List remote versions available for install
  alias <name> <version>    Resolve or update an alias
  unalias <name>            Delete an alias
  deactivate                Deactivates svm in the current shell
```