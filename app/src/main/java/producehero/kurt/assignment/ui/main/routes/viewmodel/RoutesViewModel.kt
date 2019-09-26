package producehero.kurt.assignment.ui.main.routes.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import producehero.kurt.assignment.model.entity.Route
import producehero.kurt.assignment.model.interactor.RoutesInteractor

class RoutesViewModel(private val routesInteractor: RoutesInteractor): ViewModel() {

    var disposable: Disposable? = null

    val routesList = MutableLiveData<List<Route>>()


    fun getRoutes() {
        disposable = routesInteractor
            .getRoutes()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                routesList.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    class Factory(private val routesInteractor: RoutesInteractor): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RoutesViewModel::class.java)) {
                return RoutesViewModel(routesInteractor) as T
            }
            else throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}