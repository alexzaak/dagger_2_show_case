package codes.zaak.dagger2showcase.di

import codes.zaak.dagger2showcase.MainActivity
import codes.zaak.dagger2showcase.main.di.MainFragmentModule
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainFragmentModule::class])
interface MainActivitySubcomponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}