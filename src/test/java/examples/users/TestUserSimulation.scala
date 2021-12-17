package examples.users

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._

import scala.concurrent.duration._
import scala.language.postfixOps

class TestUserSimulation extends Simulation {
  val getUser = scenario("getCall").exec(karateFeature("classpath:examples/users/users.feature"))
  setUp(
    getUser.inject(rampUsers(10) during (5 seconds))
  )
}
