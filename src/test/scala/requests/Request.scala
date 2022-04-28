package requests

import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Request {

  def postOrder = {
    exec(
      http("new order")
        .post("/login")
        .header("content-type", "application/json")
        .body(StringBody("{\"login\": \"admin\",\"password\": \"password\"}"))
        .check(status.is(200))
    )
  }
}

