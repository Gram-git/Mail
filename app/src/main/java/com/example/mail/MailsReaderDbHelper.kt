package com.example.mail

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mail.presentation.model.MailHolderUiModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MailsReaderDbHelper(context: Context) :
    SQLiteOpenHelper(context, "Mail.db", null, 1) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)
    private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS table_name"

    override fun onCreate(db: SQLiteDatabase) {
        db.insert(table_name, null, values)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    suspend fun getMails(): List<MailHolderUiModel> = withContext(Dispatchers.IO) {
        return@withContext emptyList()
    }
}

val table_name = "mails"

val CREATE_QUERY = "CREATE TABLE $table_name (" +
        "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
        "senderId INTEGER," +
        "messageTitle TEXT," +
        "message TEXT," +
        "isBookmarked NUMERIC," +
        "date INTEGER," +
        "isRead NUMERIC," +
        ""

val CREATE_QUERY2 = "CREATE TABLE $table_name (" +
        "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
        "name TEXT," +
        "avatarUrl TEXT," +
        ""


val values = ContentValues().apply {
    put("id", "1001L")
    put("senderId", "2L")
    put("messageTitle", "График собраний")
    put("message", "Проверь, пожалуйста, новую версию документа.")
    put("isBookmarked", "true")
    put("date", "1704208722416")
    put("isRead", "false")
}