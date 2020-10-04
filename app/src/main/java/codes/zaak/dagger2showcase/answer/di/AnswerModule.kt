package codes.zaak.dagger2showcase.answer.di

import codes.zaak.dagger2showcase.answer.data.AnswerApi
import codes.zaak.dagger2showcase.answer.data.AnswerRepositoryImpl
import codes.zaak.dagger2showcase.answer.domain.AnswerRepository
import codes.zaak.dagger2showcase.answer.domain.usecase.AnswerUseCase
import codes.zaak.dagger2showcase.utils.RxSchedulers
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
open class AnswerModule {
    @Provides
    @Singleton
    open fun answerApi(retrofit: Retrofit): AnswerApi = retrofit.create(AnswerApi::class.java)

    @Provides
    @Singleton
    open fun answerRepository(answerApi: AnswerApi): AnswerRepository = AnswerRepositoryImpl(answerApi)

    @Provides
    @Singleton
    open fun answerUseCase(answerRepository: AnswerRepository, rxSchedulers: RxSchedulers) =
        AnswerUseCase(answerRepository, rxSchedulers)
}
