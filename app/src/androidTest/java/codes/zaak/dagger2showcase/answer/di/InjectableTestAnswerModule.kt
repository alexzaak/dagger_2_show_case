package codes.zaak.dagger2showcase.answer.di

import codes.zaak.dagger2showcase.answer.data.AnswerApi
import codes.zaak.dagger2showcase.answer.data.AnswerRepositoryImpl
import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.usecase.AnswerUseCase
import codes.zaak.dagger2showcase.utils.RxSchedulers
import dagger.Module
import dagger.Provides
import io.mockk.mockkClass
import javax.inject.Singleton

@Module
class InjectableTestAnswerModule(
    private val answerApi: AnswerApi = mockkClass(AnswerApi::class),
    private val answerRepository: AnswerRepository = AnswerRepositoryImpl(answerApi),
    private val answerUseCase: AnswerUseCase = AnswerUseCase(answerRepository, RxSchedulers())
) {
    @Provides
    @Singleton
    fun answerApi() = answerApi

    @Provides
    @Singleton
    fun answerRepository() = answerRepository

    @Provides
    @Singleton
    fun answerUseCase() = answerUseCase
}