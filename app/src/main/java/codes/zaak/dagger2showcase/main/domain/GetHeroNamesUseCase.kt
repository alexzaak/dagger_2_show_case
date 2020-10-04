package codes.zaak.dagger2showcase.main.domain

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
open class GetHeroNamesUseCase @Inject constructor() {

    private val randomHeroName = listOf(
        "The Gentle Mage",
        "The Orange Master",
        "The Infamous Doctor",
        "The Giant Macaw",
        "Commander Thundering Swan",
        "Awesome Lord",
        "Steel Conjurer",
        "Chief Swift Hawk",
        "Dragonloom",
        "Snow Storm",
        "Fog Shadow",
        "Dream Hex",
        "Commander Flamingo",
        "The Phenomenal Avenger",
        "Web Hex",
        "Wolf Puma",
        "Fog Man",
        "Muscle Puma",
        "Professor Mantis",
        "The Indigo Thinker",
        "Mr Hornet",
        "Wolf Cat",
        "Neuron Boy",
        "Hydro Cat",
        "Hydro Cat",
        "The Awesome Laser",
        "The Neon Creature",
        "The Silver Steak",
        "The Lightning Brain",
        "Flea Shadow"
    )

    fun execute(): String {
        return randomHeroName[Random.nextInt(randomHeroName.size)]
    }
}