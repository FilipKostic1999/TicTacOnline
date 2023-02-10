package com.example.tictaconline

import com.google.firebase.firestore.DocumentId

data class username(@DocumentId var DocumentId: String? = null, var name : String? = null)
