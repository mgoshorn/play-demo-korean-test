package controllers

import dtos.QuizItemPayload
import javax.inject._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import services.QuizService

@Singleton
class QuizController @Inject()(cc: ControllerComponents, quizService: QuizService) extends AbstractController(cc) {

  def requestQuizItem(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val payload: QuizItemPayload = quizService.getQuizItem()
    val json: JsValue = Json.toJson(payload)
    Ok(json);
  }
  def submitAnswer(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok("Hello");
  }

}
