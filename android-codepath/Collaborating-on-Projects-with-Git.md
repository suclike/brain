## Overview

This is a guide focused on collaborating on Android projects together with teammates using Git. 

## Setup Git

First, you need to properly setup git for your project:

```
git init
```

Next, setup a **.gitignore** file at the **root** with the [contents from this file](https://gist.githubusercontent.com/nesquena/5617544/raw/.gitignore) to ignore files that shouldn't be shared between collaborators.

If you have **already committed files** and need to **remove them after adding the ignore**, you can run this command to remove them before committing.

```
git rm -r --cached . 
```

You can now add the initial files to git using the SourceTree / [Github](https://mac.github.com/) client or by typing:

```
git add .
git commit -am "Initial commit"
```

Next, make sure you have **setup a repository on github** and then add that repo as the origin:

```bash
git remote add origin git@github.com:myusername/reponame.git
```

and now go ahead and push the code to Github with:

```
git push origin master
```

You can also use your favorite Git GUI (for example the [Github](https://mac.github.com/) client) to do a lot of this process as well.

## Importing Shared Projects

When first importing a project generated by another person run the following in Eclipse: 

```
Package Explorer -> Right click the project -> "Android Tools" -> "Fix Project Properties"
Project -> Clean
```

Then review this detailed [[import troubleshooting guide|Troubleshooting-Common-Issues#imported-project-wont-compile]] if you are still running into problems while compiling. This likely involves having to cleanup the dependencies for the project.

## Google Maps Access Across Computers

Often when collaborating on a project with others, you need to have **maps work across multiple computers**. The problem is that the map key fingerprint is different from computer to computer and thus by default maps will only work on the computer that was used to generate the key.

The simplest fix is described in detail within [this stackoverflow post](http://stackoverflow.com/a/9653946/313399) but in short you can get the `debug.keystore` from one of the team members, check that into git and then instruct other team members to replace their `debug.keystore` file with the one from repository. See also [this link](http://groups.google.com/group/android-developers/browse_thread/thread/c9051635ab37f252) and [this guide](http://developer.android.com/guide/publishing/app-signing.html#debugmode). 

## SDK Manager

When working with different teammates that may have different Android Build Tools or SDK versions installed, you might might find it convenient to use Jake Wharton's [SDK Manager plugin](https://github.com/JakeWharton/sdk-manager-plugin) to download these packages automatically. Follow these [[installation instructions|Installing-Android-SDK-Tools#installing-the-android-sdk-automated-way]] for more info.  