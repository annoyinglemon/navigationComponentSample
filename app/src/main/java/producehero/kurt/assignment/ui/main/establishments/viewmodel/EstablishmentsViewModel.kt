package producehero.kurt.assignment.ui.main.establishments.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import producehero.kurt.assignment.model.entity.Establishment
import producehero.kurt.assignment.model.interactor.EstablishmentsInteractor

class EstablishmentsViewModel(private val establishmentsInteractor: EstablishmentsInteractor): ViewModel() {

    var disposable: Disposable? = null

    val establishments = MutableLiveData<List<Establishment>>()


    fun getEstablishments(cityName: String) {
        disposable = establishmentsInteractor
            .getEstablishments(cityName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                establishments.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    class Factory(private val establishmentsInteractor: EstablishmentsInteractor): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(EstablishmentsViewModel::class.java)) {
                return EstablishmentsViewModel(establishmentsInteractor) as T
            }
            else throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}