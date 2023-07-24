package domain.util

import presentation.text.Strings

fun String?.errorOrDefault(): String = this ?: Strings.get("something_wrong")
