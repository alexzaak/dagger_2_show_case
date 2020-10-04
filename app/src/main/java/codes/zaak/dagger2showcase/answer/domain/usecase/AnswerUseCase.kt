package codes.zaak.dagger2showcase.answer.domain.usecase

import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.model.AnswerDomainModel
import codes.zaak.dagger2showcase.utils.RxSchedulers
import io.reactivex.Single
import javax.inject.Inject

class AnswerUseCase
@Inject constructor(
    private val answerRepository: AnswerRepository,
    private val rxSchedulers: RxSchedulers
) {
    fun execute(): Single<AnswerDomainModel> =
        answerRepository.getAnswer().subscribeOn(rxSchedulers.io())
}