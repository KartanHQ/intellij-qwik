package com.nekofar.milad.intellij.qwik.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.qwik.QwikBundle
import com.nekofar.milad.intellij.qwik.QwikIcons
import javax.swing.Icon

class QwikCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "create-qwik"
    private val npxCommand = "create-qwik"

    override fun getName(): String = QwikBundle.message("qwik.project.generator.name")

    override fun getDescription(): String = QwikBundle.message("qwik.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> = emptyArray()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName(): String = packageName

    override fun presentablePackageName(): String =
        QwikBundle.message("qwik.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName, npxCommand))

    override fun generateInTemp(): Boolean = false

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> =
        arrayOf("../" + project?.name.toString())

    override fun getIcon(): Icon = QwikIcons.ProjectGenerator
}
