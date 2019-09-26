package producehero.kurt.assignment.model.interactor

import io.reactivex.Single
import producehero.kurt.assignment.model.entity.Route

interface RoutesInteractor {

    fun getRoutes(): Single<List<Route>>

}