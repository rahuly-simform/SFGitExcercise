package simform.gitexcercise.android.ui.profile.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import simform.gitexcercise.android.databinding.ActivityProfileBinding
import simform.gitexcercise.android.utils.userName

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileActivityBinding: ActivityProfileBinding
    private val editProfileLauncher = registerForActivityResult(StartActivityForResult()) { result ->
        if (result.resultCode == RESULT_OK) {
            updateEditProfileChanges(result)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileActivityBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileActivityBinding.root)
        setUpEditProfileButton()
    }

    private fun setUpEditProfileButton() {
        profileActivityBinding.buttonEditProfile.setOnClickListener {
            val intent = Intent(this@ProfileActivity,
                EditProfileActivity::class.java)
            editProfileLauncher.launch(intent)
        }
    }

    private fun updateEditProfileChanges(result: ActivityResult) {
        profileActivityBinding.textName.text = result.data?.getStringExtra(userName)
    }
}