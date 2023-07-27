package com.nekofar.milad.intellij.qwik.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.qwik.QwikBundle.message
import com.nekofar.milad.intellij.qwik.QwikIcons

class QwikCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "create-qwik"
    private val npxCommand = "create-qwik"

    override fun getName() = message("qwik.project.generator.name")

    override fun getDescription() = message("qwik.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName() = packageName

    override fun presentablePackageName() = message("qwik.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, npxCommand))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project, baseDir: VirtualFile) = arrayOf("basic", project.name)

    override fun getIcon() = QwikIcons.ProjectGenerator
}
