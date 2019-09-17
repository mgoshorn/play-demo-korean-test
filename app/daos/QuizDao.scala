package daos

import java.sql.{PreparedStatement, ResultSet, Statement}

import javax.inject.{Inject, Singleton}
import models.DictionaryItem
import play.api.db.Database

import scala.collection.mutable.ListBuffer

@Singleton
class QuizDao @Inject()(db: Database) {
  def getQuizItems(seed: Double): List[DictionaryItem] = {
    db.withConnection { conn =>
      conn.setAutoCommit(false)
      val ps: PreparedStatement = conn.prepareStatement("SELECT SETSEED(?)")
      ps.setDouble(1, seed)
      ps.execute()
      val query: Statement = conn.createStatement()
      val result: ResultSet = query.executeQuery("SELECT * FROM dictionary WHERE speech_part_id = 1 ORDER BY random() limit 4;")
      val words: ListBuffer[DictionaryItem] = ListBuffer()
      while(result.next()) {
        words.addOne(DictionaryItem(result.getInt("id"),
          result.getString("word"),
          result.getString("definition"),
          result.getInt("speech_part_id")))
      }
      words.toList
    }
  }
}
