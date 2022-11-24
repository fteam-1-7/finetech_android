package com.team17.fintech_team_17.data

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.team17.fintech_team_17.data.model.LoggedInUser
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    private val auth = Firebase.auth
    fun login(email: String, password: String): Result<LoggedInUser> {
        try {
            auth.signInWithEmailAndPassword(email, password)
            var fakeUser: LoggedInUser
            val user = auth.currentUser
            user?.let {
                val mail = user.email
                val uid = user.uid
                fakeUser = LoggedInUser(uid, mail!!)
                return Result.Success(fakeUser)
            }
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
        return Result.Error(IOException("Error logging in"))
    }

    fun logout() {
        // TODO: revoke authentication
    }
}