package codes.zaak.dagger2showcase.main.domain

import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
open class GetSuperPowerUseCase @Inject constructor() {

    private val superPowerList = listOf(
        "Anatomical Liberation",
        "Ash Secretion",
        "Temporal Duplication",
        "Teleportation",
        "Vibration Manipulation",
        "Control Microwaves",
        "Control Water",
        "Hope Projection", " Vibration Emission",
        "Cyborg Body Part Replacements",
        "Ecological Empathy",
        "Sense Fear",
        "Martial Arts Mastery",
        "Concussion Beams",
        " Super Climbing",
        "Vertigo Manipulation",
        " Organ Enhancement",
        " Control Ice",
        "Enhanced Craftsmanship",
        "Control The Elements"
    )

    fun execute(): String {
        return superPowerList[Random.nextInt(superPowerList.size)]
    }
}