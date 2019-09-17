package dtos

import play.api.libs.json.{Json, Writes}

case class QuizItemPayload(word: String, options: List[String], seed: Double)
object QuizItemPayload {
  implicit val jsonFormat: Writes[QuizItemPayload] = Json.writes[QuizItemPayload]
}
