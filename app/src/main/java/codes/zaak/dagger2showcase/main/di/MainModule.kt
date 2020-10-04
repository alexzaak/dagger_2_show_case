package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase
import dagger.Module
import dagger.Provides

@Module
open class MainModule {

    @Provides
    open fun getHeroNamesUseCase(): GetHeroNamesUseCase {
        return GetHeroNamesUseCase()
    }

    @Provides
    open fun getSuperPowerUseCase(): GetSuperPowerUseCase {
        return GetSuperPowerUseCase()
    }
}