### $HOME/.bash_profile

# EDITORS
export EDITOR=vim
VISUAL=subl
which "$VISUAL" > /dev/null && export VISUAL

CONFIGFILE=$HOME/.bash_profile
e() {
	if [ -s $VISUAL ] ;
	then
		$EDITOR "$1"
	else
		$VISUAL "$1"
	fi
}
config() {
	echo "Editing $CONFIGFILE"
	echo "$ reload  # when you are done"
	e "$CONFIGFILE"
}
reload() {
	source $CONFIGFILE
}

# homebrew : /usr/local/bin before
export PATH=/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin

## Configure folders
# export DEV=$HOME/Dev
# export ANDROID_HOME=$DEV/android-sdk-macosx
# export PATH=${PATH}:$ANDROID_HOME/tools:$ANDROID_HOME/platform-tools
# export STUDIO_JDK=/Library/Java/JavaVirtualMachines/jdk1.7.0_71.jdk