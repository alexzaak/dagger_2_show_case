package codes.zaak.dagger2showcase.main.di

import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase


class TestMainModule(
    private val getHeroNamesUseCase: GetHeroNamesUseCase = GetHeroNamesUseCase(),
    private val getSuperPowerUseCase: GetSuperPowerUseCase = GetSuperPowerUseCase(),
) : MainModule() {

    override fun getHeroNamesUseCase(): GetHeroNamesUseCase {
        return getHeroNamesUseCase
    }

    override fun getSuperPowerUseCase(): GetSuperPowerUseCase {
        return getSuperPowerUseCase
    }
}