package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase
import dagger.Module
import dagger.Provides
import io.mockk.mockkClass
import javax.inject.Singleton

@Module
class InjectableTestMainModule {
    @Provides
    @Singleton
    fun getHeroNamesUseCase(): GetHeroNamesUseCase {
        return mockkClass(GetHeroNamesUseCase::class)
    }

    @Provides
    @Singleton
    fun getSuperPowerUseCase(): GetSuperPowerUseCase {
        return mockkClass(GetSuperPowerUseCase::class)
    }
}