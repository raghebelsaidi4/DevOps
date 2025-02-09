# Git
Git is a distributed version control system designed to handle everything from small to very large projects with speed and efficiency. It allows multiple developers to work on a project simultaneously without interfering with each other's work. Each developer works on their own branch, and changes are merged into the main branch after review.
## Key Concepts

- **Repository (Repo)**: A directory where Git has been initialized to track file changes.
- **Branch**: A parallel version of the repository. It allows you to work on different features or fixes independently.
- **Commit**: A snapshot of the repository at a specific point in time.
- **Merge**: Combining changes from different branches.
- **Pull**: Fetching changes from a remote repository and merging them into the current branch.
- **Push**: Uploading local repository content to a remote repository.

## Git Workflow

1. **Initialize a Repository**:
   ```bash
   git init
   ```

2. **Add Files to Staging Area**:
   ```bash
   git add <file_name>
   ```

3. **Check Status**:
   ```bash
   git status
   ```

4. **Commit Changes**:
   ```bash
   git commit -m "Your commit message"
   ```

5. **View Commit History**:
   ```bash
   git log
   ```

6. **Create a New Branch**:
   ```bash
   git branch <branch_name>
   ```

7. **Switch to a Branch**:
   ```bash
   git checkout <branch_name>
   ```

8. **Merge Branches**:
   ```bash
   git merge <branch_name>
   ```

9. **Push Changes to Remote Repository**:
   ```bash
   git push origin <branch_name>
   ```

10. **Pull Changes from Remote Repository**:
    ```bash
    git pull origin <branch_name>
    ```

## Example Workflow

### Initializing a Repository
```bash
mkdir my_project
cd my_project
git init
```

### Adding and Committing Files
```bash
echo "Hello, World!" > README.md
git add README.md
git commit -m "Initial commit with README.md"
```

### Creating and Switching Branches
```bash
git branch feature-branch
git checkout feature-branch
```

### Making Changes and Pushing to Remote
```bash
echo "New feature" > feature.txt
git add feature.txt
git commit -m "Add new feature"
git push origin feature-branch
```

### Merging Branches
```bash
git checkout main
git merge feature-branch
git push origin main
```

## Git with CI/CD via Jenkins

Integrating Git with Jenkins for Continuous Integration and Continuous Deployment (CI/CD) involves setting up a Jenkins job to monitor your Git repository. Here’s a basic example:

1. **Install Jenkins**: Follow the official Jenkins installation guide.
2. **Create a New Job**:
  - Go to Jenkins dashboard.
  - Click on "New Item".
  - Enter a name for your job and select "Freestyle project".
3. **Configure Source Code Management**:
  - Select "Git".
  - Enter the repository URL.
4. **Build Triggers**:
  - Select "Poll SCM" and set the schedule (e.g., `H/5 * * * *` to poll every 5 minutes).
5. **Build Steps**:
  - Add build steps like running tests or building the project.
6. **Save and Run**:
  - Save the configuration and run the job.

## Popular Git Servers

1. **GitHub**: [https://github.com](https://github.com)
2. **Bitbucket**: [https://bitbucket.org](https://bitbucket.org)
3. **GitLab**: [https://gitlab.com](https://gitlab.com)

## Advanced Git Commands

- **Stashing Changes**:
  ```bash
  git stash
  git stash apply
  ```

- **Rebasing**:
  ```bash
  git rebase <branch_name>
  ```

- **Tagging**:
  ```bash
  git tag <tag_name>
  git push origin <tag_name>
  ```

- **Resetting**:
  ```bash
  git reset --hard HEAD
  ```

## Real-World Example

### Scenario: Collaborative Feature Development

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/username/repo.git
   cd repo
   ```

2. **Create a Feature Branch**:
   ```bash
   git checkout -b feature-login
   ```

3. **Develop the Feature**:
   ```bash
   echo "Login feature" > login.txt
   git add login.txt
   git commit -m "Add login feature"
   ```

4. **Push the Feature Branch**:
   ```bash
   git push origin feature-login
   ```

5. **Create a Pull Request**:
  - Go to GitHub/Bitbucket/GitLab.
  - Create a pull request from `feature-login` to `main`.

6. **Review and Merge**:
  - Team lead reviews the code.
  - If approved, merge the pull request.

7. **Update Local Repository**:
   ```bash
   git checkout main
   git pull origin main
   ```

## Conclusion

Git is an essential tool for modern software development, enabling efficient collaboration and version control. By mastering Git commands and workflows, developers can significantly improve their productivity and code quality. Integrating Git with CI/CD pipelines further enhances the development process, ensuring continuous integration and deployment.

For more detailed information, refer to the official [Git documentation](https://git-scm.com/doc).

---