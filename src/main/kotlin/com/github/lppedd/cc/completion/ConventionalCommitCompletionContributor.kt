package com.github.lppedd.cc.completion

import com.intellij.codeInsight.completion.CompletionContributor
import com.intellij.codeInsight.completion.CompletionType
import com.intellij.openapi.fileTypes.PlainTextLanguage
import com.intellij.patterns.PlatformPatterns

/**
 * @author Edoardo Luppi
 */
class ConventionalCommitCompletionContributor : CompletionContributor() {
  init {
    extend(
      CompletionType.BASIC,
      PlatformPatterns.psiElement().withLanguage(PlainTextLanguage.INSTANCE),
      ConventionalCommitCompletionProvider()
    )
  }
}
