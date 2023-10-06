package simform.gitexcercise.android.ui.auth.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityRegistrationBinding
import simform.gitexcercise.android.utils.FakeCredentials.updateCredential
import simform.gitexcercise.android.utils.showToast

class RegistrationActivity : AppCompatActivity() {

    private lateinit var registrationActivityBinding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registrationActivityBinding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(registrationActivityBinding.root)
        setUpNewRegistration()
    }

    private fun setUpNewRegistration() {
        registrationActivityBinding.buttonRegister.setOnClickListener {
            verifyAndRegister()
        }
    }

    private fun verifyAndRegister() {
        registrationActivityBinding.apply {
            val email = editTextEmail.text
            val password = editTextPassword.text
            val confirmPassword = editTextConfirmPassword.text
            if (!email.isNullOrEmpty() && !password.isNullOrEmpty()
                && !confirmPassword.isNullOrEmpty() &&
                confirmPassword.toString() == password.toString()) {
                updateCredential(email.toString(), password.toString())
                showToast(this@RegistrationActivity,
                    getString(R.string.info_registered_successfully))
            } else {
                showToast(this@RegistrationActivity,
                    getString(R.string.error_field_empty_password_mismatch))
            }
        }
    }
}