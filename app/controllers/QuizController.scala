package controllers

import java.security.SecureRandom

import DTOs.QuizItemPayload
import javax.inject._
import models.DictionaryItem
import play.api._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import services.QuizService

@Singleton
class QuizController @Inject()(cc: ControllerComponents, quizService: QuizService) extends AbstractController(cc) {

  def getQuizItem(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val payload: QuizItemPayload = quizService getQuizItem()
    val json: JsValue = Json.toJson(payload)
    Ok(json);
  }
  def submitAnswer(): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    Ok();
  }

}
