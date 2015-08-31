

## Apps

Install the installer

```sh
$ open http://brew.sh/
$ open http://caskroom.io/
# brew install caskroom/cask/brew-cask
```

Favorite apps installed by brew or brew cask

```sh
$ brew list
autojump
brew-cask
ctags
git
maven
mysql
node
wget
zsh

$ brew cask list
android-studio
atom
dash
divvy
firefox
geekbench
github
intellij-idea
iterm2
mysqlworkbench
sts
sublime-text
sourcetree
libreoffice
virtualbox
slack
genymotion
transmission
hipchat
anki
darteditor
skype
etrecheck
```

Apps that can not be install by brew/brew cask

- [FlyCut](https://itunes.apple.com/fr/app/flycut-clipboard-manager/id442160987?mt=12)
- [Noizio](https://itunes.apple.com/us/app/noizio/id928871589)

## Shell

Copy & adapt the content from [.bash_profile]

```sh
$ config    ## open .bash_profile
## hack it
$ reload    ## curent shell has the changes
```

## Configuration

Screenshots shall not clutter the desktop

```bash
$ defaults write com.apple.screencapture location $HOME/Downloads;killall SystemUIServer
```