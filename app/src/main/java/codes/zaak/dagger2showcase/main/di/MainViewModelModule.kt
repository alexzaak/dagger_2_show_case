package codes.zaak.dagger2showcase.main.di

import androidx.lifecycle.ViewModel
import codes.zaak.dagger2showcase.di.ViewModelKey
import codes.zaak.dagger2showcase.main.ui.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class MainViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindProfileViewModel(viewModel: MainViewModel): ViewModel
}