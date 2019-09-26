package producehero.kurt.assignment.ui.login.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import producehero.kurt.assignment.R
import producehero.kurt.assignment.databinding.ActivityLoginBinding
import producehero.kurt.assignment.ui.main.MainActivity

class LoginActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewBinding = DataBindingUtil.setContentView<ActivityLoginBinding>(this, R.layout.activity_login)
        viewBinding.buttonSignIn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}