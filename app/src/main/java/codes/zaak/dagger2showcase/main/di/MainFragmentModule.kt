package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.main.ui.MainFragment
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module(subcomponents = [MainFragmentSubcomponent::class])
abstract class MainFragmentModule {
    @Binds
    @IntoMap
    @ClassKey(MainFragment::class)
    abstract fun bindMainFragmentInjectorFactory(factory: MainFragmentSubcomponent.Factory): AndroidInjector.Factory<*>
}