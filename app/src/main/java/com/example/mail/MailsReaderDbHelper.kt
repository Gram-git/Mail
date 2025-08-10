package com.example.mail

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.mail.presentation.model.MailHolderUiModel
import com.example.mail.presentation.model.SenderUiModel
import com.example.mail.utls.DateUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MailsReaderDbHelper(context: Context) :
    SQLiteOpenHelper(context, "Mail.db", null, 1) {

    private val SQL_DELETE_ENTRIES_MAILS = "DROP TABLE IF EXISTS mails"
    private val SQL_DELETE_ENTRIES_USERS = "DROP TABLE IF EXISTS users"

    override fun onCreate(db: SQLiteDatabase) {
        val table_name = "mails"
        val table_name2 = "users"

        val CREATE_QUERY = "CREATE TABLE $table_name (" +
                "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
                "senderId INTEGER," +
                "messageTitle TEXT," +
                "message TEXT," +
                "isBookmarked INTEGER," +
                "date INTEGER," +
                "isRead INTEGER" +
                ")"

        val CREATE_QUERY2 = "CREATE TABLE $table_name2 (" +
                "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
                "name TEXT," +
                "avatarUrl TEXT" +
                ")"


        val values = ContentValues().apply {
            put("id", 1001)
            put("senderId", 2)
            put("messageTitle", "График собраний")
            put("message", "Проверь, пожалуйста, новую версию документа.")
            put("isBookmarked", 1)
            put("date", 1704208722416)
            put("isRead", 0)
        }

        val values2 = ContentValues().apply {
            put("id", 2)
            put("name", "Борис Петров")
            putNull("avatarUrl")
        }
        db.execSQL(CREATE_QUERY)
        db.execSQL(CREATE_QUERY2)
        db.insert(table_name, null, values)
        db.insert(table_name2, null, values2)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES_MAILS)
        db.execSQL(SQL_DELETE_ENTRIES_USERS)
        onCreate(db)
    }

    override fun onDowngrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    suspend fun getMails(): List<MailHolderUiModel> = withContext(Dispatchers.IO) {
        val mails = mutableListOf<MailHolderUiModel>()
        val cursor = readableDatabase.query(
            "mails",
            arrayOf("id", "senderId", "messageTitle", "message", "isBookmarked", "date", "isRead"),
            null,
            null,
            null,
            null,
            null
        )

        with(cursor) {
            while (moveToNext()) {
                val id = getLong(0)
                val senderId = getLong(1)
                val title = getString(2)
                val message = getString(3)
                val isBookmarked = getInt(4) == 1
                val date = getLong(5)
                val isRead = getInt(6) == 1

                val selection = "id = ?"
                val selectionArgs = arrayOf("$senderId")

                var mail = MailHolderUiModel(
                    id = id,
                    sender = null,
                    messageTitle = title,
                    message = message,
                    isBookmarked = isBookmarked,
                    date = DateUtil.formatPrettyDate(date),
                    isRead = isRead
                )

                val userCursor = readableDatabase.query(
                    "users",
                    arrayOf("id", "name", "avatarUrl"),
                    selection, selectionArgs, null, null, null
                )

                while (userCursor.moveToNext()) {
                    val userId = userCursor.getLong(0)
                    val name = userCursor.getString(1)
                    val avatarUrl = userCursor.getString(2)

                    val sender = SenderUiModel(
                        id = userId,
                        name = name,
                        avatarUrl = avatarUrl
                    )

                    userCursor.close()

                    if (sender.id != 2L) {
                        mail = mail.copy(sender = sender)
                    }
                }

                mails += mail
            }
        }

        cursor.close()

        return@withContext mails
    }
}

