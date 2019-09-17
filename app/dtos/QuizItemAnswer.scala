package dtos

import play.api.libs.json.{Json, Reads}

case class QuizItemAnswer(seed: Double, word: String)
object QuizItemAnswer {
  implicit val jsonRead: Reads[QuizItemAnswer] = Json.reads[QuizItemAnswer]
}
