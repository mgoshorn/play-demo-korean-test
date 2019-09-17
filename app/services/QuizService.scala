package services

import java.security.SecureRandom

import daos.QuizDao
import dtos.{QuizItemAnswer, QuizItemPayload}
import javax.inject.{Inject, Singleton}
import models.DictionaryItem

@Singleton
class QuizService @Inject()(quizDao: QuizDao){


  def retrieveQuizItem(): QuizItemPayload = {
    val seed = new SecureRandom().nextDouble

    val items: List[DictionaryItem] = quizDao.getQuizItems(seed)
    val options: List[String] = items.map(_.word)
    val word: String = items(1).definition

    QuizItemPayload(word, options, seed)
  }

  def validateCorrect(answer: QuizItemAnswer): Boolean = {
    val items: List[DictionaryItem] = quizDao.getQuizItems(answer.seed)
    items(1).word.equals(answer.word)
  }
}
