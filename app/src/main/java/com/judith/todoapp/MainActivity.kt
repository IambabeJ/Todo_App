package com.judith.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val validuserName : String = "Admin"
    val validpassword : String = "Admin"

    private lateinit var userNameInput : EditText
    private lateinit var passwordInput : EditText
    private lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        userNameInput = findViewById(R.id.userNameInput)
        passwordInput = findViewById(R.id.passwordInput)
        submitButton = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val userName = userNameInput.text.toString()
            val password = passwordInput.text.toString()
            login(userName,password)
        }




    }
    fun login(userName : String, password : String){
        if(isValidCredentials(userName, password)){
            val intent : Intent = Intent(this,HomeActivity:: class.java)
            intent.putExtra("username",userName)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext,"Wrong Password", Toast.LENGTH_SHORT).show()
        }
    }
    private fun isValidCredentials(userName: String, password: String) : Boolean{
        return (userName ==validuserName && password == validpassword)
    }


}