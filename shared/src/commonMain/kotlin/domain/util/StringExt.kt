package domain.util

import presentation.text.Strings

fun String?.errorOrDefault(): String = this ?: Strings.get("something_wrong")

private const val EMAIL_REGEX = "^(.*)(@)(.+)(\\.)(.+)"
val String.isEmailValid: Boolean get() = EMAIL_REGEX.toRegex().matches(this)

private const val PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{8,}$"
val String.isStrongPassword: Boolean
    get() = PASSWORD_REGEX.toRegex().matches(this)
