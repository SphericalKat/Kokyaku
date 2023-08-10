package bio.kat.kokyaku.data.network.models

import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonDataException
import com.squareup.moshi.ToJson

class JlptAdapter {
    @ToJson
    fun toJson(jlpt: Jlpt): String {
        return when (jlpt) {
            Jlpt.JlptN1 -> "jlpt-n1"
            Jlpt.JlptN2 -> "jlpt-n2"
            Jlpt.JlptN3 -> "jlpt-n3"
            Jlpt.JlptN4 -> "jlpt-n4"
            Jlpt.JlptN5 -> "jlpt-n5"
        }
    }


    @FromJson fun fromJson(jlpt: String): Jlpt {
        if (jlpt.length != 7) throw JsonDataException("Invalid JLPT level $jlpt")

        return when(jlpt.last()) {
            '1' -> Jlpt.JlptN1
            '2' -> Jlpt.JlptN2
            '3' -> Jlpt.JlptN3
            '4' -> Jlpt.JlptN4
            '5' -> Jlpt.JlptN5
            else -> throw JsonDataException("Invalid JLPT level $jlpt")
        }
    }
}