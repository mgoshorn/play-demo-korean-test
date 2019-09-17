package DTOs

import play.api.libs.json.Json

case class QuizItemPayload(word: String, options: List[String], seed: Double)
object QuizItemPayload {
  implicit val jsonFormat = Json.writes[QuizItemPayload]
}
