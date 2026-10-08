package vn.edu.vlu.lab2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import vn.edu.vlu.lab2.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận email từ màn hình Login
        binding.tvValueEmail.text =
            intent.getStringExtra(EXTRA_EMAIL).orEmpty()

        // Nút đăng xuất quay lại Login
        binding.btnLogout.setOnClickListener {
            finish()
        }

        binding.btnEdit.setOnClickListener {
            Toast.makeText(
                this,
                getString(R.string.profile_edit_message),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        const val EXTRA_EMAIL = "extra_email"
    }
}