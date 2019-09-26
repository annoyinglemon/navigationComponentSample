package producehero.kurt.assignment.datasource

import io.reactivex.Single
import producehero.kurt.assignment.model.entity.Coordinates
import producehero.kurt.assignment.model.entity.Establishment
import producehero.kurt.assignment.model.entity.OrderItem
import producehero.kurt.assignment.model.entity.Route

class DataSource {

    fun getRoutes(): Single<List<Route>> {
        return Single.just(
            mutableListOf(Route("Toronto"), Route("Waterloo"), Route("Guelph"))
        )
    }

    fun getEstablishments(cityName: String): Single<List<Establishment>> {
       val establishments = when (cityName) {
            "Toronto" -> createEstablishmentsForToronto()
            "Waterloo" -> createEstablishmentsForWaterloo()
            else -> createEstablishmentsForGuelph()
        }

        return Single.just(establishments)
    }

    fun getOrders(establishmentName: String): Single<List<OrderItem>> {
        return Single.just(createOrders())
    }

    private fun createEstablishmentsForToronto(): List<Establishment> {

        val establishment1 = Establishment(
            "Boston Pizza",
            "250 Front St West, Toronto, ON M5V 3G5",
            Coordinates(43.6443392,-79.3899457),
            true
        )
        val establishment2 = Establishment(
            "Kinton Ramen",
            "90 Eglinton Ave E, Toronto, ON M4P 2Y3",
            Coordinates(43.7930648,-79.3272262),
            true
        )
        val establishment3 = Establishment(
            "The Burgernator",
            "269 Augusta Ave, Toronto, ON M5T 2M1",
            Coordinates(43.6599578,-79.4058909),
            false
        )
        val establishment4 = Establishment(
            "Jack Astor's Bar & Grill",
            "2 Bloor St E, Toronto, ON M4W 1A8",
            Coordinates(43.670952,-79.3890137),
            false
        )

        return mutableListOf(establishment1, establishment2, establishment3, establishment4)
    }

    private fun createEstablishmentsForWaterloo(): List<Establishment> {

        val establishment1 = Establishment(
            "The Bauer Kitchen",
            "187 King St S #102, Waterloo, ON N2J 1R1",
            Coordinates(43.4602416,-80.5243225),
            true
        )
        val establishment2 = Establishment(
            "Solé Restaurant and Wine Bar",
            "83 Erb St W Building Two, Waterloo, ON N2L 6C2",
            Coordinates(43.4631197,-80.5288636),
            false
        )
        val establishment3 = Establishment(
            "Loloan Lobby Bar",
            "14 Princess St W, Waterloo, ON N2L 2X8",
            Coordinates(43.4661531,-80.5247449),
            false
        )

        return mutableListOf(establishment1, establishment2, establishment3)
    }

    private fun createEstablishmentsForGuelph(): List<Establishment> {

        val establishment1 = Establishment(
            "Artisanale French Country Cooking",
            "214 Woolwich St, Guelph, ON N1H 3V6",
            Coordinates(43.5266128,-80.2736198),
            true
        )
        val establishment2 = Establishment(
            "Earth to Table: Bread Bar",
            "105 Gordon St, Guelph, ON N1H 4H7",
            Coordinates(43.5266708,-80.2738645),
            false
        )

        return mutableListOf(establishment1, establishment2)
    }

    private fun createOrders(): List<OrderItem> {
        return mutableListOf(
            OrderItem("Order Item 1", 6.0, 10),
            OrderItem("Order Item 2", 5.0, 20),
            OrderItem("Order Item 3", 4.0, 30),
            OrderItem("Order Item 4", 3.0, 40),
            OrderItem("Order Item 5", 2.0, 50),
            OrderItem("Order Item 6", 1.0, 60)
        )
    }


}