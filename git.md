
Lessoons learned

- Use the github desktop client, it's great
- Use github.com a lot
- Android Studio / Intellij client has improved
- Git sub-modules are a pain
- When I am stuck, a good solution is simply to delete the local branch
-
```
git_update_gitignore() {
	git ls-files --ignored --exclude-standard | xargs git rm --cached
}
```
