package bio.kat.kokyaku.data.network.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JishoResponse(
    @Json(name = "meta") val meta: Meta,
    @Json(name = "data") val data: List<Datum>
)

@JsonClass(generateAdapter = true)
data class Meta(
    @Json(name = "status") val status: String
)

data class Datum (
    @Json(name = "slug") val slug: String,
    @Json(name = "is_common") val isCommon: Boolean,
    @Json(name = "tags") val tags: List<String>,
    @Json(name = "jlpt") val jlpt: List<Jlpt>,
    @Json(name = "japanese") val japanese: List<Japanese>,
    @Json(name = "senses") val senses: List<Sense>,
    @Json(name = "attribution") val attribution: Attribution
)

data class Attribution (
    val jmdict: Boolean,
    val jmnedict: Boolean,
    val dbpedia: Dbpedia
)

sealed class Dbpedia {
    class BoolValue(val value: Boolean)  : Dbpedia()
    class StringValue(val value: String) : Dbpedia()
}

data class Japanese (
    val word: String,
    val reading: String
)

enum class Jlpt {
    JlptN1,
    JlptN2,
    JlptN3,
    JlptN4,
    JlptN5
}

data class Sense (
    @Json(name = "english_definitions") val englishDefinitions: List<String>,
    @Json(name = "parts_of_speech") val partsOfSpeech: List<String>,
    @Json(name = "links") val links: List<Link>,
    @Json(name = "tags")  val tags: List<String>,
    @Json(name = "restrictions") val restrictions: List<String>,
    @Json(name = "see_also") val seeAlso: List<String>,
    // TODO: add these later
//    val source: List<Any?>,
//    val info: List<Any?>,
//    val sentences: List<Any?>? = null
)

data class Link (
    val text: String,
    val url: String
)