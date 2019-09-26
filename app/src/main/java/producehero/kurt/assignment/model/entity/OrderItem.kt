package producehero.kurt.assignment.model.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class OrderItem(val name: String, val weightInKg: Double, val quantity: Int): Parcelable