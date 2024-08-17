package example.com.route

import example.com.repositories.history.HistoryRepository
import example.com.repositories.history.HistoryRepositoryImpl
import example.com.repositories.history.model.HistoryDraft
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.historyRoute() {
    val productRepository: HistoryRepository = HistoryRepositoryImpl()
    routing {
        get("/histories"){
            call.respond(productRepository.getAllProducts())
        }
        get("/history/{id}"){
            val id = call.parameters["id"]?.toIntOrNull()
            if(id == null) {
                call.respond(HttpStatusCode.BadRequest, "ID parameter has set number")
                return@get
            }

            val product = productRepository.getProduct(id)
            if(product == null){
                call.respond(HttpStatusCode.NotFound, "product not found")
                return@get
            }

            call.respond(product)
        }
        post("/history") {
            val historyDraft = call.receive<HistoryDraft>()
            val history = productRepository.addHistory(historyDraft)
            call.respond(history)
        }
    }
}