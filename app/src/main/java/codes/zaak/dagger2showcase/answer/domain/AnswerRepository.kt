package codes.zaak.dagger2showcase.answer.domain

import codes.zaak.dagger2showcase.answer.domain.model.AnswerDomainModel
import io.reactivex.Single

interface AnswerRepository {
    fun getAnswer(): Single<AnswerDomainModel>
}