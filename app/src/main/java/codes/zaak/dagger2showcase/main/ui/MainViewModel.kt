package codes.zaak.dagger2showcase.main.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import codes.zaak.dagger2showcase.main.domain.GetHeroNamesUseCase
import codes.zaak.dagger2showcase.main.domain.GetSuperPowerUseCase
import javax.inject.Inject

class MainViewModel
@Inject constructor(
    private val getHeroNamesUseCase: GetHeroNamesUseCase,
    private val getSuperPowerUseCase: GetSuperPowerUseCase
) : ViewModel() {

    private val _heroNames: MutableLiveData<String> = MutableLiveData()
    val heroNames: LiveData<String> = _heroNames

    private val _superPower: MutableLiveData<String> = MutableLiveData()
    val superPower: LiveData<String> = _superPower

    fun getRandomHeroName() {
        _heroNames.value = getHeroNamesUseCase.execute()
    }

    fun getSuperPower() {
        _superPower.value = getSuperPowerUseCase.execute()
    }
}