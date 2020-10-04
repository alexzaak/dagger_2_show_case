package codes.zaak.dagger2showcase.answer.data

import codes.zaak.dagger2showcase.answer.data.model.AnswerDto
import io.reactivex.Single
import retrofit2.http.GET

interface AnswerApi {
    @GET(API)
    fun getAnswer(): Single<AnswerDto>

    companion object {
        const val API = "/api"
    }
}