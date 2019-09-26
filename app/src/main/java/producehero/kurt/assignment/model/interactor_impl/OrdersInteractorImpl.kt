package producehero.kurt.assignment.model.interactor_impl

import io.reactivex.Single
import producehero.kurt.assignment.datasource.DataSource
import producehero.kurt.assignment.model.entity.OrderItem
import producehero.kurt.assignment.model.interactor.OrdersInteractor

class OrdersInteractorImpl(private val dataSource: DataSource): OrdersInteractor {

    override fun getOrders(establishmentName: String): Single<List<OrderItem>> {
        return dataSource.getOrders(establishmentName)
    }
}