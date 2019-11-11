package id.kotlin.belajar.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val name: String,
    val age: Int
) : Parcelable