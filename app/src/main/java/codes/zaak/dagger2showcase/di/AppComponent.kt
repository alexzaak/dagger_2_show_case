package codes.zaak.dagger2showcase.di

import android.app.Application
import codes.zaak.dagger2showcase.App
import codes.zaak.dagger2showcase.MainActivity
import codes.zaak.dagger2showcase.answer.di.AnswerModule
import codes.zaak.dagger2showcase.answer.di.AnswerViewModelModule
import codes.zaak.dagger2showcase.main.di.MainModule
import codes.zaak.dagger2showcase.main.di.MainViewModelModule
import codes.zaak.dagger2showcase.main.ui.MainFragment
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
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
interface AppComponent : AndroidInjector<App> {

    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }
}