package codes.zaak.dagger2showcase.utils

import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class RxSchedulers
@Inject constructor() {
    open fun io() = Schedulers.io()
}