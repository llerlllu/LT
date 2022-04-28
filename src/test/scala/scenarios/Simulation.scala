package scenarios

import io.gatling.core.Predef.scenario
import requests.Request.{postOrder}

object Simulation {
  def postOrdersScen = scenario("first scenario")
    .exec(postOrder)
}

