package com.github.lppedd.cc.completion.providers

import com.github.lppedd.cc.api.CommitFooterValueProvider
import com.github.lppedd.cc.api.ProviderPresentation
import com.github.lppedd.cc.completion.Priority
import com.github.lppedd.cc.configuration.CCConfigService
import com.intellij.openapi.project.Project
import org.jetbrains.annotations.ApiStatus

/**
 * @author Edoardo Luppi
 */
@ApiStatus.Internal
internal class FooterValueProviderWrapper(
    project: Project,
    private val provider: CommitFooterValueProvider,
) : ProviderWrapper {
  private val config = CCConfigService.getInstance(project)

  override fun getId(): String =
    provider.getId()

  override fun getPresentation(): ProviderPresentation =
    provider.getPresentation()

  override fun getPriority() =
    Priority(config.getProviderOrder(provider))
}