package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.MainActivity
import codes.zaak.dagger2showcase.main.ui.MainFragment
import dagger.Subcomponent

@Subcomponent(modules = [MainModule::class])
interface MainComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(mainFragment: MainFragment)

    @Subcomponent.Builder
    interface Builder {
        fun mainModule(module: MainModule): Builder
        fun build(): MainComponent
    }
}