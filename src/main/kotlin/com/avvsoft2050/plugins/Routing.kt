package com.avvsoft2050.plugins

import com.avvsoft2050.servises.PrimesGenerator
import io.ktor.server.application.*
import io.ktor.server.freemarker.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.util.*

fun Application.configureRouting() {
    var length = 20
    var fivePrimesRangesLists = PrimesGenerator.getFivePrimesRanges(length, PrimesGenerator.firstPrimes)
    routing {
        // ...
        get("/") {
            call.respondRedirect("primes")
        }

        get("primes/j") {
            call.respond(PrimesGenerator.getRandomSixPrimesLists(fivePrimesRangesLists))
        }
        route("primes") {
            var randomSixPrimesLists = PrimesGenerator.getRandomSixPrimesLists(fivePrimesRangesLists)
            println(randomSixPrimesLists)

            get {
                randomSixPrimesLists = PrimesGenerator.getRandomSixPrimesLists(fivePrimesRangesLists)
                call.respond(
                    FreeMarkerContent(
                        "primes.ftl",
                        mapOf("randomSixPrimesLists" to randomSixPrimesLists.toString())
                    )
                )
            }


            post {
                val formParameters = call.receiveParameters()
                length = formParameters.getOrFail<Int>("length").toInt()
                fivePrimesRangesLists = PrimesGenerator.getFivePrimesRanges(length, PrimesGenerator.firstPrimes)
                randomSixPrimesLists = PrimesGenerator.getRandomSixPrimesLists(fivePrimesRangesLists)
                call.respond(
                    FreeMarkerContent(
                        "primes.ftl",
                        mapOf("randomSixPrimesLists" to randomSixPrimesLists.toString())
                    )
                )
                println(length)
            }


//            get("/{length}") {
//                length = call.parameters.getOrFail<Int>("length").toInt()
//                val client = HttpClient(CIO) {
//                    install(WebSockets) {
//                        contentConverter = KotlinxWebsocketSerializationConverter(Json)
//                    }
//                }
//                runBlocking {
//                    client.webSocket(method = HttpMethod.Get, host = "127.0.0.1", port = 8080, path = "/primes") {
//                        sendSerialized(FivePrimesRanges(PrimesGenerator.getRandomSixPrimesLists(fivePrimesRangesLists)))
//                    }
//                }
//                client.close()
//            }

        }
    }
}
