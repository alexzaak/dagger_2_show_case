package codes.zaak.dagger2showcase.answer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import codes.zaak.dagger2showcase.answer.domain.model.AnswerDomainModel
import codes.zaak.dagger2showcase.answer.domain.usecase.AnswerUseCase
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class AnswerViewModel @Inject constructor(
    private val answerUseCase: AnswerUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _answer: MutableLiveData<AnswerDomainModel> = MutableLiveData()
    val answer: LiveData<AnswerDomainModel> = _answer

    fun getAnswer() {
        disposables.add(
            answerUseCase.execute().subscribe({
                _answer.postValue(it)
            }, {})
        )
    }

    override fun onCleared() {
        disposables.clear()
        super.onCleared()
    }
}