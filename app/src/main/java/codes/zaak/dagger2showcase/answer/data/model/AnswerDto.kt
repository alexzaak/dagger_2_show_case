package codes.zaak.dagger2showcase.answer.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AnswerDto(
    @field:Json(name = "answer")
    val answer: String,
    @field:Json(name = "image")
    val image: String
)
