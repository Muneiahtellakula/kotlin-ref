package com.muneiah.myshopdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLogin.setOnClickListener {
            val email=edtEmail.text.toString();
            val password=edtPassword.text.toString();
            var intent= Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
