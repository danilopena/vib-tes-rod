package br.com.rodrigolmti.vibbra.data.factory

import br.com.rodrigolmti.vibbra.domain.model.*
import java.util.*

class MockDataFactory {
    companion object {
        private val fakeLocation = Location(
            address = "Rua andiroba",
            city = "Dos Anjos",
            latitude = 120.40333,
            longitude = -140.222,
            state = "Wakanda",
            zipCode = 30360280
        )

        val fakeUser = User(
            email = "rodrigolmti@gmail.com",
            login = "rodrigolmti@gmail.com",
            token = "l4kjl23j4l2kj34l2",
            name = "Rodrigo Martins",
            location = fakeLocation
        )

        val fakeDeals = listOf(
            Deal(
                type = DealType.sell,
                value = 100.0,
                description = "Selling a new car",
                tradingFor = "A car",
                location = fakeLocation,
                urgency = DealUrgency.low,
                limitDate = Date(),
                photos = listOf(
                    "https://s3.us-east-2.amazonaws.com/prod.mm.com/img/projectcars/IMG_0743.jpg"
                )
            ),
            Deal(
                type = DealType.desire,
                value = 100.0,
                description = "Wanting a new car",
                tradingFor = "A car",
                location = fakeLocation,
                urgency = DealUrgency.high,
                limitDate = Date(),
                photos = listOf(
                    "https://fws-shared.s3.amazonaws.com/uploads/website/auctions/items/large/4024501_1.jpg"
                )
            ),
            Deal(
                type = DealType.trade,
                value = 100.0,
                description = "Trading a switch",
                tradingFor = "Nothing",
                location = fakeLocation,
                urgency = DealUrgency.medium,
                limitDate = Date(),
                photos = listOf(
                    "https://s3.us-east-2.amazonaws.com/prod.mm.com/img/projectcars/IMG_0743.jpg"
                )
            ),
            Deal(
                type = DealType.desire,
                value = 100.0,
                description = "Wanting a new car",
                tradingFor = "A car",
                location = fakeLocation,
                urgency = DealUrgency.high,
                limitDate = Date(),
                photos = listOf(
                    "https://fws-shared.s3.amazonaws.com/uploads/website/auctions/items/large/4024501_1.jpg"
                )
            ),
        )
    }
}