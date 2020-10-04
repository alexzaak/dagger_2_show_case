package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.di.AppComponent
import codes.zaak.dagger2showcase.di.AppModule
import codes.zaak.dagger2showcase.di.MainActivityModule
import codes.zaak.dagger2showcase.di.ViewModelFactoryModule
import codes.zaak.dagger2showcase.answer.di.AnswerViewModelModule
import codes.zaak.dagger2showcase.answer.di.InjectableTestAnswerModule
import codes.zaak.dagger2showcase.main.ui.MainFragmentTestByInjection
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
        InjectableTestAnswerModule::class
    ]
)
interface MainAppComponent : AppComponent {
    fun inject(mainFragmentTestByInjection: MainFragmentTestByInjection)
}