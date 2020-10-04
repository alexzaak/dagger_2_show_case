package codes.zaak.dagger2showcase.di

import androidx.lifecycle.ViewModelProvider
import codes.zaak.dagger2showcase.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}