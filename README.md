# Проект по Съвременни Devops Практики
![image](https://github.com/dragontwiz/pro_lexyan/assets/92438692/27a9ad87-ba14-4e33-b16b-6b37a6cf04aa)
### Current Version is Epsilon 0.5 
# Overview
The Calculator project is a simple Java Swing-based calculator application. It provides basic arithmetic operations, including addition, subtraction, multiplication, and division, along with additional features such as square root and power of 2.
## About the Branching
This branching strategy ensures a structured and controlled development process. It allows for parallel feature development, continuous integration, and quick resolution of critical issues through hotfix branches. The main branch always represents the stable and production-ready codebase, while the develop branch serves as a staging area for ongoing development efforts.
### Main Branch:

- Branch Name: main
- Purpose: Represents the latest stable version of the code.
- Merge Source: Develop branch.
- Merge Destination: None. Merges into this branch only when a release is ready.
### Develop Branch:

- Branch Name: develop
- Purpose: Serves as the integration branch for ongoing development work.
- Merge Source: Feature branches and hotfix branches.
- Merge Destination: Main branch.
### Feature Branches:

- Branch Naming Convention: feature-{feature-name}
- Purpose: Dedicated branches for developing new features.
- Merge Source: Developed independently.
- Merge Destination: Develop branch.
### Hotfix Branches:

- Branch Naming Convention: hotfix-{issue-number}
- Purpose: Created to address critical issues in the main/develop branch.
- Merge Source: Developed independently.
- Merge Destination: Main/Develop branch.

## Branching Strategy Workflow
### Feature Development:

- Developers create feature branches from the develop branch to work on new features.
- Feature branches are merged back into the develop branch upon completion.
### Code Review:

- Before merging into the develop branch, feature branches undergo code review to maintain code quality.
### Release Preparation:

- When a set of features is ready for release, the develop branch is merged into the main branch.
### Hotfixing:

- If critical issues are identified in the main branch, hotfix branches are created.
- Hotfix branches are merged into both the main and develop branches.

## About the CI/CD
### Linter Job:

- Runs Super-Linter to perform linting on the codebase.
- Echoes a simple message and additional instructions.
### Trivy Job:

- Depends on the Linter job.
- Checks out the code.
- Builds a Docker image.
- Runs Trivy vulnerability scanner on the Docker image.
### Docker Job:

- Depends on the Trivy job.
- Sets up QEMU and Docker Buildx.
- Logs in to Docker Hub.
- Builds and pushes the Docker image.
### Kubernetes-Azure Job:

- Depends on the Trivy job.
- Checks out the code.
- Logs in to Azure Container Registry.
- Builds and pushes the Docker image.
- Sets up Kubectl and configures the Kubernetes context.
- Creates a secret for Kubernetes deployment.
- Deploys to Kubernetes using manifests.

## About the Security
 The security of the project acts on two different occasions. The first one occurs when pushing or merging into the developer or other sub-branches. The second is when pushing or merging from other branches into the main branch. That way, no errors or security vulnerabilities can be pushed or merged into the sub-branches. The second security check is for security vulnerabilities when merging two branches.

## About the Docker deploy

## About the Kubernetes cluster
# Version Alpha 0.1

# Version Beta 0.2

# Version Gamma 0.3

# Version Delta 0.4

# Version Epsilon 0.5

# TO DO
- Figure out a way that everything works, without building so many different docker images.
- To host online on a site packages for online downloading.
