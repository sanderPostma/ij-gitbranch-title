# Git Branch in Window Title

[![Build](https://github.com/sanderPostma/ij-gitbranch-title/workflows/Build/badge.svg)](https://github.com/sanderPostma/ij-gitbranch-title/actions)

## Description

<!-- Plugin description -->
This IntelliJ IDEA plugin adds the current Git branch name to your IDE window title bar. It displays the title in the format: `Project Name [Branch Name] - Current File`.

Designed especially for developers who use time tracking applications that capture window titles to associate work with specific tickets or tasks. If you follow a branch naming convention that includes ticket numbers (e.g., `feature/JIRA-123`), this plugin makes it easier for time tracking tools to automatically associate your work with the correct tickets.
<!-- Plugin description end -->

## Features

- Automatically updates the window title with your current Git branch name
- Shows the current file you're working on
- Updates in real-time when switching branches or files
- Lightweight with minimal performance impact

## Use Cases

- Automatic time tracking with tools that capture window titles
- Easier context switching between multiple project windows
- Quick visual reference of which branch you're currently working on

## Installation

- **Using the IDE built-in plugin system:**

  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Git Branch in Window Title"</kbd> >
  <kbd>Install</kbd>

- **Manual Installation:**

  Download the [latest release](https://github.com/sanderPostma/ij-gitbranch-title/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## Requirements

- IntelliJ IDEA 2023.3 or newer (build 233+)
- Git integration enabled in your project

## Feedback and Contributions

- Report issues on the [GitHub issue tracker](https://github.com/sanderPostma/ij-gitbranch-title/issues)
- Pull requests are welcome!

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Developed by [Sander Postma](https://github.com/sanderPostma)

Build with JetBrains [IntelliJ Platform Plugin Template](https://github.com/JetBrains/intellij-platform-plugin-template)