package simform.gitexcercise.android.ui.auth.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import simform.gitexcercise.android.R
import simform.gitexcercise.android.databinding.ActivityLoginBinding
import simform.gitexcercise.android.ui.profile.activity.ProfileActivity
import simform.gitexcercise.android.utils.FakeCredentials.defaultMail
import simform.gitexcercise.android.utils.FakeCredentials.defaultPassword
import simform.gitexcercise.android.utils.showToast

class LoginActivity : AppCompatActivity() {

    private lateinit var loginActivityBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginActivityBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginActivityBinding.root)
        setUpVerification()
        setUpRegisterButton()
        setUpForgotPasswordButton()
    }

    private fun setUpVerification() {
        loginActivityBinding.apply {
            buttonLogin.setOnClickListener {
                if (editTextEmail.text.toString() == defaultMail
                    && editTextPassword.text.toString() == defaultPassword) {
                    startActivity(Intent(this@LoginActivity, ProfileActivity::class.java))
                    showToast(this@LoginActivity, getString(R.string.info_login_success))
                } else {
                    showToast(this@LoginActivity,
                        getString(R.string.error_credential_invalid))
                }
            }
        }
    }

    private fun setUpRegisterButton() {
        loginActivityBinding.buttonRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity,
                RegistrationActivity::class.java))
        }
    }

    private fun setUpForgotPasswordButton() {
        loginActivityBinding.buttonForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity,
                ForgotPasswordActivity::class.java))
        }
    }
}