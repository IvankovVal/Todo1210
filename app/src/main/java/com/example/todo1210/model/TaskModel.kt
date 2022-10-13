package com.example.todo1210.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class TaskModel (
    @SerializedName("id") @Expose
    var id: Int? = null,
    @SerializedName("name") @Expose
    var name: String? = null,
    @SerializedName("status") @Expose
    var status: Boolean? = null
)