package simulations

import io.gatling.core.Predef._
import io.gatling.http.Predef.http
import scenarios.Simulation.postOrdersScen

class LoadTest2 extends Simulation {

  val httpConf = http.baseUrl("http://localhost:8091")
  setUp(
    postOrdersScen.inject(
      /*
      heavisideUsers(1000) during(10)
      */


      //rampUsers(1000) during(50) //rate равномерное распределение на during
      //constantUsersPerSec(10).during(120)//каждую during будут появлятся rate
      //rampUsersPerSec(100).to(150).during(30).randomized // Пользователи будут вводиться с рандомизированными интервалами
      //constantUsersPerSec(100).during(10).randomized //Пользователи будут вводиться с рандомизированными интервалами
      //atOnceUsers(1000)//одновременно
      //heavisideUsers(9000) during(60)// rate поднимается постепенно в течении during

      /*
      rampUsersPerSec(0).to(100).during(60),
      constantUsersPerSec(100).during(120)
      */

      /*
      incrementUsersPerSec(1)
       .times(10)
       .eachLevelLasting(10)
       .separatedByRampsLasting(1)
       .startingFrom(0)
      */

      /*
      //
      rampUsersPerSec(0).to(140).during(60),
      constantUsersPerSec(140).during(120),

      nothingFor(30),

      rampUsersPerSec(0).to(140).during(60),
      constantUsersPerSec(140).during(120)
      */

      //
      rampUsersPerSec(0).to(50).during(10),
      constantUsersPerSec(50).during(60),

      nothingFor(10),

      rampUsersPerSec(0).to(100).during(10),
      constantUsersPerSec(100).during(60),

      nothingFor(10),

      rampUsersPerSec(0).to(150).during(10),
      constantUsersPerSec(150).during(60),

      nothingFor(10),

      rampUsersPerSec(0).to(200).during(10),
      constantUsersPerSec(200).during(60)

    ).protocols(httpConf)

  )

}
