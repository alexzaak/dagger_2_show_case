package codes.zaak.dagger2showcase.di

import codes.zaak.dagger2showcase.MainActivityTestByInjection
import codes.zaak.dagger2showcase.answer.di.AnswerModule
import codes.zaak.dagger2showcase.answer.di.AnswerViewModelModule
import codes.zaak.dagger2showcase.main.di.MainViewModelModule
import codes.zaak.dagger2showcase.main.di.InjectableTestMainModule
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
        InjectableTestMainModule::class,
        AppModule::class,
        AnswerModule::class
    ]
)
interface TestInjectionAppComponent : AppComponent {
    fun inject(mainActivityTestByInjection: MainActivityTestByInjection)
}