package com.team17.fintech_team_17.Firebase_Connect

import android.content.ContentValues
import android.util.Log
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseConnect {

    companion object fbDB {

    private val db = FirebaseFirestore.getInstance()

    private var user: HashMap<String, Any> = HashMap()

    fun putUser(id: String, name: String, email: String, password: String) {
        user.put("id", id)
        user.put("name", name)
        user.put("email", email)
        user.put("password", password)

    }

    fun addUser() {
        db.collection("users")
            .add(user)
            .addOnSuccessListener(OnSuccessListener<DocumentReference>() {
                @Override
                fun onSuccess(documentReference: DocumentReference) {
                    Log.d(
                        ContentValues.TAG,
                        "DocumentSnapshot added with ID: " + documentReference.getId()
                    );
                }
            })
            .addOnFailureListener(OnFailureListener() {
                @Override
                fun onFailure(e: Exception) {
                    Log.w(ContentValues.TAG, "Error adding document", e);
                }
            })

    }

}
}