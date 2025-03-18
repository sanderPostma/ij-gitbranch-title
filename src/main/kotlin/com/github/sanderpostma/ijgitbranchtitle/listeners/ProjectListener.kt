package com.github.sanderpostma.ijgitbranchtitle.listeners

import com.github.sanderpostma.ijgitbranchtitle.services.GitBranchTitleBarUpdater
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

class ProjectListener : ProjectManagerListener {
    override fun projectOpened(project: Project) {
        project.service<GitBranchTitleBarUpdater>().projectOpened()
    }

    override fun projectClosed(project: Project) {
        project.service<GitBranchTitleBarUpdater>().projectClosed()
    }
}