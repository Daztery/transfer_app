package com.daztery.transferapp.data

import android.os.Parcel
import android.os.Parcelable

data class Payment(
    val fullName: String,
    val amount: Double
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readDouble()
    ) {
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.let {
            dest.writeString(fullName)
            dest.writeDouble(amount)
        }
    }

    companion object CREATOR : Parcelable.Creator<Payment> {
        override fun createFromParcel(parcel: Parcel): Payment {
            return Payment(parcel)
        }

        override fun newArray(size: Int): Array<Payment?> {
            return arrayOfNulls(size)
        }
    }
}