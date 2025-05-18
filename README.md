Get the latest code and switch to the 2025.04 branch:
git fetch
git checkout 2025.04
git pull

Create your own branch from 2025.04:
git checkout -b john-login-page 2025.04
(Replace "john-login-page" with your name and what you're working on)
Make your changes and commit regularly:
# Make some code changes
git add .
git commit -m "Added login form"

# Make more changes
git add .
git commit -m "Fixed button styling"

Keep your branch updated with 2025.04 (do this occasionally):
git checkout 2025.04
git pull
git checkout john-login-page
git merge 2025.04

Push your branch to the remote repository:
git push -u origin john-login-page

Create a Pull Request to merge into 2025.04:

Go to your repository website
Create a new PR
Set the base branch as "2025.04"
Set your branch (john-login-page) as the source


After approval, your code will be merged into the 2025.04 branch.

The main idea is that you branch from 2025.04, do your work, and then merge back to 2025.04 (not main/master).
