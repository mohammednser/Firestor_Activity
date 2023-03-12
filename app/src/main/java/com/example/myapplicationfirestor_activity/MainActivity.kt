package com.example.myapplicationfirestor_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        btn_save.setOnClickListener {
            val name = pt_pname.text.toString()
            val id = pt_pid.text.toString()
            val age = pt_page.text.toString()

            val Person = hashMapOf(
                "name" to name,
                "id" to id,
                "age" to age
            )
            db.collection("Person")
                .add(Person)
                .addOnSuccessListener { documentReference ->
                    Toast.makeText(applicationContext, documentReference.id, Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(applicationContext, "$e", Toast.LENGTH_SHORT).show()
                }

        }
    }
}