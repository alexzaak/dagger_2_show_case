package codes.zaak.dagger2showcase.answer.data

import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.model.AnswerDomainModel
import io.reactivex.Single
import javax.inject.Inject

class AnswerRepositoryImpl
@Inject constructor(private val answerApi: AnswerApi) :
    AnswerRepository {

    override fun getAnswer(): Single<AnswerDomainModel> {
        return answerApi.getAnswer().map { AnswerDomainModel(it.answer, it.image) }
    }
}