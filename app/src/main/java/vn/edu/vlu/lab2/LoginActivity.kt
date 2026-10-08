package vn.edu.vlu.lab2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.lab2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            handleLogin()
        }

        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.forgot_password_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun handleLogin() {

        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString()

        binding.edtEmail.error = null
        binding.edtPassword.error = null
        binding.tvStatus.text = ""

        when {

            email.isEmpty() || password.isEmpty() -> {

                binding.tvStatus.text =
                    getString(R.string.status_missing)

                Toast.makeText(
                    this,
                    getString(R.string.msg_missing_info),
                    Toast.LENGTH_SHORT
                ).show()
            }

            !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {

                binding.edtEmail.error =
                    getString(R.string.err_email_invalid)

                binding.edtEmail.requestFocus()
            }

            password.length < 6 -> {

                binding.edtPassword.error =
                    getString(R.string.err_password_short)

                binding.edtPassword.requestFocus()
            }

            else -> {

                binding.tvStatus.text =
                    getString(R.string.status_login_ok, email)

                val intent =
                    Intent(this, ProfileActivity::class.java)

                intent.putExtra(
                    ProfileActivity.EXTRA_EMAIL,
                    email
                )

                startActivity(intent)
            }
        }
    }
}