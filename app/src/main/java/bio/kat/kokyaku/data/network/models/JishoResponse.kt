package bio.kat.kokyaku.data.network.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JishoResponse(
    val meta: Meta,
)

@JsonClass(generateAdapter = true)
data class Meta(
    val status: String
)

data class Datum (
    val slug: String,
    val isCommon: Boolean,
    val tags: List<String>,
    val jlpt: List<Jlpt>,
    val japanese: List<Japanese>,
    val senses: List<Sense>,
    val attribution: Attribution
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
    val englishDefinitions: List<String>,
    val partsOfSpeech: List<String>,
    val links: List<Link>,
    val tags: List<Any?>,
    val restrictions: List<Any?>,
    val seeAlso: List<Any?>,
    val antonyms: List<Any?>,
    val source: List<Any?>,
    val info: List<Any?>,
    val sentences: List<Any?>? = null
)

data class Link (
    val text: String,
    val url: String
)