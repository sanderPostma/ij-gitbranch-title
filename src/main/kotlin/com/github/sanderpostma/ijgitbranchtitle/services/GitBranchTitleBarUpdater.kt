package com.github.sanderpostma.ijgitbranchtitle.services

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.WindowManager
import com.intellij.openapi.fileEditor.FileEditorManager
import com.intellij.openapi.fileEditor.FileEditorManagerEvent
import com.intellij.openapi.fileEditor.FileEditorManagerListener
import com.intellij.util.messages.MessageBusConnection
import git4idea.GitUtil
import git4idea.repo.GitRepository
import git4idea.repo.GitRepositoryChangeListener
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.openapi.project.guessProjectDir

class GitBranchTitleBarUpdater(private val project: Project) {

    private lateinit var connection: MessageBusConnection

    fun projectOpened() {
        connection = project.messageBus.connect()

        // Subscribe to Git repository changes
        connection.subscribe(GitRepository.GIT_REPO_CHANGE, GitRepositoryChangeListener {
                updateTitle()
        })

        // Subscribe to file editor changes
        connection.subscribe(FileEditorManagerListener.FILE_EDITOR_MANAGER, object : FileEditorManagerListener {
            override fun selectionChanged(event: FileEditorManagerEvent) {
        updateTitle()
    }
        })

        updateTitle()
    }

    fun projectClosed() {
        if (::connection.isInitialized) {
            connection.disconnect()
        }
    }

    private fun updateTitle() {
        val projectBaseDir = project.guessProjectDir() ?: return
        val repo = GitUtil.getRepositoryManager(project).getRepositoryForFileQuick(projectBaseDir)
        val branch = repo?.currentBranchName ?: "No Branch"
        val frame = WindowManager.getInstance().getFrame(project) ?: return

        val file = FileEditorManager.getInstance(project).selectedEditor?.file
        val fileName = file?.name ?: "No File"

        val newTitle = "${project.name} [$branch] - $fileName"
        frame.title = newTitle
        frame.rootPane?.putClientProperty("Window.title", newTitle)

        // Add logging
        println("GitBranchTitleBarUpdater: Setting title to '$newTitle'")
    }
}
