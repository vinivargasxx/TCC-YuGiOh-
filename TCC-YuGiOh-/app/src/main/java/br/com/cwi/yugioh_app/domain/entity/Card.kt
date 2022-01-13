package br.com.cwi.yugioh_app.domain.entity

import android.os.Parcel
import android.os.Parcelable

class Card(
        var id: Int,
        var name: String,
        var type: String,
        var race: String,
        var attribute: String?,
        var atk: Int?,
        var def: Int?,
        var lvl: Int?,
        var cardImage: String,
        var cardSmallImage: String,
        var description: String,
        var isDeck: Boolean = false
): Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString(),
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readValue(Int::class.java.classLoader) as? Int,
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readByte() != 0.toByte()
        ) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeInt(id)
                parcel.writeString(name)
                parcel.writeString(type)
                parcel.writeString(race)
                parcel.writeString(attribute)
                parcel.writeValue(atk)
                parcel.writeValue(def)
                parcel.writeValue(lvl)
                parcel.writeString(cardImage)
                parcel.writeString(cardSmallImage)
                parcel.writeString(description)
                parcel.writeByte(if (isDeck) 1 else 0)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Card> {
                override fun createFromParcel(parcel: Parcel): Card {
                        return Card(parcel)
                }

                override fun newArray(size: Int): Array<Card?> {
                        return arrayOfNulls(size)
                }
        }
}