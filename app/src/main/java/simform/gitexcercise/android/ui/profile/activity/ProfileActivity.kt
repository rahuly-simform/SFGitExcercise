package simform.gitexcercise.android.ui.profile.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import simform.gitexcercise.android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileActivityBinding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        profileActivityBinding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(profileActivityBinding.root)
    }
}