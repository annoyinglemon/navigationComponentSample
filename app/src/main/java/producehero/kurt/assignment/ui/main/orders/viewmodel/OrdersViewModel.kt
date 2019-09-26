package producehero.kurt.assignment.ui.main.orders.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import producehero.kurt.assignment.model.entity.OrderItem
import producehero.kurt.assignment.model.interactor.OrdersInteractor

class OrdersViewModel(private val ordersInteractor: OrdersInteractor): ViewModel() {

    var disposable: Disposable? = null

    val orderItems = MutableLiveData<List<OrderItem>>()


    fun getOrders(establishmentName: String) {
        disposable = ordersInteractor
            .getOrders(establishmentName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
                orderItems.value = it
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

    class Factory(private val ordersInteractor: OrdersInteractor): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(OrdersViewModel::class.java)) {
                return OrdersViewModel(ordersInteractor) as T
            }
            else throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}