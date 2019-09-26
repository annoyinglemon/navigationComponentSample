package producehero.kurt.assignment.model.interactor

import io.reactivex.Single
import producehero.kurt.assignment.model.entity.OrderItem

interface OrdersInteractor {

    fun getOrders(establishmentName: String): Single<List<OrderItem>>

}