package simform.gitexcercise.android.utils

object FakeCredentials {
    var defaultMail = "rhlydv@test.com"
    var defaultPassword = "test@123"

    fun updateCredential(mail: String, password: String) {
        defaultMail = mail
        defaultPassword = password
    }
}