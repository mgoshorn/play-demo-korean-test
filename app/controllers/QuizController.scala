package controllers

import dtos.{QuizItemAnswer, QuizItemPayload}
import javax.inject._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import services.QuizService

@Singleton
class QuizController @Inject()(cc: ControllerComponents, quizService: QuizService) extends AbstractController(cc) {

  def requestQuizItem(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val payload: QuizItemPayload = quizService.retrieveQuizItem()
    val json: JsValue = Json.toJson(payload)
    Ok(json);
  }
  def submitAnswer(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val body: AnyContent = request.body;
    val jsonBody: Option[JsValue] = body.asJson
    val answer: QuizItemAnswer = Json.fromJson[QuizItemAnswer](jsonBody.get).get
    val correct: Boolean = quizService.validateCorrect(answer);
    if (correct) {
      Ok("Correct")
    } else {
      Ok("Incorrect")
    }
  }

}
