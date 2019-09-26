package producehero.kurt.assignment.model.interactor_impl

import io.reactivex.Single
import producehero.kurt.assignment.datasource.DataSource
import producehero.kurt.assignment.model.entity.Route
import producehero.kurt.assignment.model.interactor.RoutesInteractor

class RoutesInteractorImpl(private val dataSource: DataSource): RoutesInteractor {

    override fun getRoutes(): Single<List<Route>> {
        return dataSource.getRoutes()
    }

}