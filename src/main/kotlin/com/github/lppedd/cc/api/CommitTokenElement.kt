package com.github.lppedd.cc.api

import com.intellij.openapi.editor.Editor
import com.intellij.ui.JBColor
import java.awt.Color
import javax.swing.Icon

/**
 * @author Edoardo Luppi
 */
abstract class CommitTokenElement @JvmOverloads constructor(
    open val text: String,
    open val description: String,
    private val value: String = text,
) {
  open fun getValue(tokenContext: TokenContext): String =
    value

  open fun getRendering(): CommitTokenRendering =
    CommitTokenRendering()

  companion object {
    @JvmField
    val FOREGROUND: JBColor = JBColor.namedColor("CompletionPopup.foreground", JBColor.foreground())
  }

  data class CommitTokenRendering @JvmOverloads constructor(
      val bold: Boolean = false,
      val italic: Boolean = false,
      val strikeout: Boolean = false,
      val foreground: Color = FOREGROUND,
      val type: String? = null,
      val icon: Icon? = null,
  )

  data class TokenContext(
      val completionChar: Char,
      val editor: Editor,
  )
}
