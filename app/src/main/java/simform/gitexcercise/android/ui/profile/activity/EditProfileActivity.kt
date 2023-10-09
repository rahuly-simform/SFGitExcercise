package simform.gitexcercise.android.ui.profile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import simform.gitexcercise.android.databinding.ActivityEditProfileBinding
import simform.gitexcercise.android.utils.userName

class EditProfileActivity : AppCompatActivity() {

    private lateinit var editProfileBinding: ActivityEditProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        editProfileBinding = ActivityEditProfileBinding.inflate(layoutInflater)
        setContentView(editProfileBinding.root)
        setUpSaveButton()
    }

    private fun setUpSaveButton() {
        editProfileBinding.buttonSave.setOnClickListener {
            val intent = Intent(this@EditProfileActivity, ProfileActivity::class.java)
            intent.putExtra(userName, editProfileBinding.editTextName.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}