package codes.zaak.dagger2showcase.answer.di

import codes.zaak.dagger2showcase.answer.data.AnswerApi
import codes.zaak.dagger2showcase.answer.data.AnswerRepositoryImpl
import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.usecase.AnswerUseCase
import codes.zaak.dagger2showcase.utils.RxSchedulers
import io.mockk.mockkClass
import retrofit2.Retrofit


class TestAnswerModule(
    private val answerApi: AnswerApi = mockkClass(AnswerApi::class),
    private val answerRepository: AnswerRepository = AnswerRepositoryImpl(answerApi),
    private val answerUseCase: AnswerUseCase = AnswerUseCase(answerRepository, RxSchedulers())
) : AnswerModule() {
    override fun answerApi(retrofit: Retrofit): AnswerApi {
        return answerApi
    }

    override fun answerRepository(answerApi: AnswerApi): AnswerRepository {
        return answerRepository
    }

    override fun answerUseCase(
        answerRepository: AnswerRepository,
        rxSchedulers: RxSchedulers
    ): AnswerUseCase {
        return answerUseCase
    }
}