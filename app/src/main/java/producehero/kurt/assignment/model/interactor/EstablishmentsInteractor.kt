package producehero.kurt.assignment.model.interactor

import io.reactivex.Single
import producehero.kurt.assignment.model.entity.Establishment

interface EstablishmentsInteractor {

    fun getEstablishments(cityName: String): Single<List<Establishment>>

}