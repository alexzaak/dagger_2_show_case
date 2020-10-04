package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.main.ui.MainFragment
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface MainFragmentSubcomponent : AndroidInjector<MainFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment>
}