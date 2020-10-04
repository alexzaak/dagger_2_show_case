package codes.zaak.dagger2showcase.answer.di

import androidx.lifecycle.ViewModel
import codes.zaak.dagger2showcase.di.ViewModelKey
import codes.zaak.dagger2showcase.answer.ui.AnswerViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AnswerViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(AnswerViewModel::class)
    abstract fun bindFeatureViewModel(viewModel: AnswerViewModel): ViewModel
}