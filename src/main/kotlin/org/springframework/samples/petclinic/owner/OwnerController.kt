package org.springframework.samples.petclinic.owner

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.features.StatusPages
import io.ktor.features.ContentNegotiation
import io.ktor.gson.gson
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun Application.module() {
    install(ContentNegotiation) {
        gson {
            setPrettyPrinting()
        }
    }
    install(StatusPages) {
        exception<Throwable> { cause ->
            call.respond(HttpStatusCode.InternalServerError, cause.localizedMessage)
        }
    }
    routing {
        route("/owners") {
            get("/new") {
                call.respond(HttpStatusCode.OK, "New owner form")
            }
            post("/new") {
                call.respond(HttpStatusCode.Created, "Owner created")
            }
            get("/find") {
                call.respond(HttpStatusCode.OK, "Find owner form")
            }
            get("/{ownerId}/edit") {
                call.respond(HttpStatusCode.OK, "Edit owner form")
            }
            post("/{ownerId}/edit") {
                call.respond(HttpStatusCode.OK, "Owner updated")
            }
            get("/{ownerId}") {
                call.respond(HttpStatusCode.OK, "Owner details")
            }
        }
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}
