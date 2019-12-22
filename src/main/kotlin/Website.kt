import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.cio.CIO
import io.ktor.server.engine.applicationEngineEnvironment
import io.ktor.server.engine.connector
import io.ktor.server.engine.embeddedServer

fun main() {
    val environment = applicationEngineEnvironment {
        module {
            main()
        }
        
        connector {
            host = "0.0.0.0"
            port = 7000
        }
    }
    
    val website = embeddedServer(CIO, environment)
    
    website.start(wait = true)
}


fun Application.main() {
    routing {
        get("/") {
            println(call.request.headers["Host"])
            call.request.headers.forEach { h, v -> println("$h: $v") }
            call.respondText { "Hello World" }
        }
        
        get("/test") {
            println(call.request.headers["Host"])
            call.request.headers.forEach { h, v -> println("$h: $v") }
            call.respondText { "Hello World test" }
        }
    }
    
    println("Website running")
}
