package producehero.kurt.assignment.model.interactor_impl

import io.reactivex.Single
import producehero.kurt.assignment.datasource.DataSource
import producehero.kurt.assignment.model.entity.Establishment
import producehero.kurt.assignment.model.interactor.EstablishmentsInteractor

class EstablishmentsInteractorImpl(private val dataSource: DataSource): EstablishmentsInteractor {

    override fun getEstablishments(cityName: String): Single<List<Establishment>> {
        return dataSource.getEstablishments(cityName)
    }

}