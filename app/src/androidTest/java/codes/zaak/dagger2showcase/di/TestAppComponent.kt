package codes.zaak.dagger2showcase.di

import codes.zaak.dagger2showcase.answer.di.AnswerModule
import codes.zaak.dagger2showcase.answer.di.AnswerViewModelModule
import codes.zaak.dagger2showcase.main.di.MainModule
import codes.zaak.dagger2showcase.main.di.MainViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        MainActivityModule::class,
        ViewModelFactoryModule::class,
        MainViewModelModule::class,
        AnswerViewModelModule::class,
        MainModule::class,
        AppModule::class,
        AnswerModule::class
    ]
)
interface TestAppComponent : AppComponent