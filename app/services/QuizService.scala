package services

import java.security.SecureRandom

import DTOs.QuizItemPayload
import javax.inject.Singleton
import models.DictionaryItem

@Singleton
class QuizService {


  def getQuizItem(): QuizItemPayload = {
    val seed = new SecureRandom nextDouble;

    val items: List[DictionaryItem] = List();
    val options: List[String] = items map (_.definition);
    val word: String = items(1) definition;

    QuizItemPayload(word, options, seed);
  }
}
