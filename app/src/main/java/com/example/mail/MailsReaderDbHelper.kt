package com.example.mail

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.mail.presentation.model.MailHolderUiModel
import com.example.mail.presentation.model.SenderUiModel
import com.example.mail.utls.DateUtil
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MailsReaderDbHelper(context: Context) :
    SQLiteOpenHelper(context, "Mail.db", null, 2) {

    private val SQL_DELETE_ENTRIES_MAILS = "DROP TABLE IF EXISTS mails"
    private val SQL_DELETE_ENTRIES_USERS = "DROP TABLE IF EXISTS users"

    override fun onCreate(db: SQLiteDatabase) {
        val tableMails = "mails"
        val tableUsers = "users"

//        val CREATE_MAILS = "CREATE TABLE $tableMails (" +
//                "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
//                "senderId INTEGER," +
//                "messageTitle TEXT," +
//                "message TEXT," +
//                "isBookmarked INTEGER," +
//                "date INTEGER," +
//                "isRead INTEGER" +
//                ")"
//
//        val CREATE_USERS = "CREATE TABLE $tableUsers (" +
//                "id INTEGER UNIQUE PRIMARY KEY NOT NULL," +
//                "name TEXT," +
//                "avatarUrl TEXT" +
//                ")"
//
//
//        val valuesMail = ContentValues().apply {
//            put("id", 1001)
//            put("senderId", 2)
//            put("messageTitle", "График собраний")
//            put("message", "Проверь, пожалуйста, новую версию документа.")
//            put("isBookmarked", 1)
//            put("date", 1704208722416)
//            put("isRead", 0)
//        }
//
//        val valuesUser = ContentValues().apply {
//            put("id", 2)
//            put("name", "Борис Петров")
//            putNull("avatarUrl")
//        }
        db.execSQL(
            """
        CREATE TABLE IF NOT EXISTS $tableUsers (
            id INTEGER PRIMARY KEY NOT NULL UNIQUE,
            name TEXT,
            avatarUrl TEXT
        )
    """.trimIndent()
        )

        db.execSQL(
            """
        CREATE TABLE IF NOT EXISTS $tableMails (
            id INTEGER PRIMARY KEY NOT NULL UNIQUE,
            senderId INTEGER,
            messageTitle TEXT,
            message TEXT,
            isBookmarked INTEGER,
            date INTEGER,
            isRead INTEGER,
            FOREIGN KEY (senderId) REFERENCES $tableUsers(id)
        )
    """.trimIndent()
        )
//        db.execSQL(CREATE_MAILS)
//        db.execSQL(CREATE_USERS)
        db.execSQL(
            """
        INSERT INTO $tableUsers (id, name, avatarUrl) VALUES
        (1, 'Анна Иванова', 'https://i.pravatar.cc/200?img=1'),
        (2, 'Борис Петров', 'https://i.pravatar.cc/200?img=2'),
        (3, 'Светлана Кузнецова', 'https://i.pravatar.cc/200?img=3'),
        (4, 'Даниил Смирнов', 'https://i.pravatar.cc/200?img=4'),
        (5, 'Екатерина Орлова', 'https://i.pravatar.cc/200?img=5'),
        (6, 'Фёдор Новиков', 'https://i.pravatar.cc/200?img=6'),
        (7, 'Мария Соколова', 'https://i.pravatar.cc/200?img=7'),
        (8, 'Георгий Лебедев', 'https://i.pravatar.cc/200?img=8'),
        (9, 'Людмила Морозова', 'https://i.pravatar.cc/200?img=9'),
        (10, 'Александр Козлов', 'https://i.pravatar.cc/200?img=10'),
        (11, 'Ирина Федорова', 'https://i.pravatar.cc/200?img=11'),
        (12, 'Юрий Попов', 'https://i.pravatar.cc/200?img=12'),
        (13, 'Ольга Семенова', 'https://i.pravatar.cc/200?img=13'),
        (14, 'Михаил Волков', 'https://i.pravatar.cc/200?img=14'),
        (15, 'Наталья Зайцева', 'https://i.pravatar.cc/200?img=15'),
        (16, 'Роман Егоров', 'https://i.pravatar.cc/200?img=16'),
        (17, 'Татьяна Никитина', 'https://i.pravatar.cc/200?img=17'),
        (18, 'Виктор Макаров', 'https://i.pravatar.cc/200?img=18'),
        (19, 'Елена Андреева', 'https://i.pravatar.cc/200?img=19'),
        (20, 'Сергей Тихонов', 'https://i.pravatar.cc/200?img=20'),
        (21, 'Валерия Гаврилова', 'https://i.pravatar.cc/200?img=21'),
        (22, 'Григорий Данилов', 'https://i.pravatar.cc/200?img=22'),
        (23, 'Василиса Жукова', 'https://i.pravatar.cc/200?img=23'),
        (24, 'Павел Киселёв', 'https://i.pravatar.cc/200?img=24'),
        (25, 'Алиса Литвинова', 'https://i.pravatar.cc/200?img=25'),
        (26, 'Денис Мельников', 'https://i.pravatar.cc/200?img=26'),
        (27, 'Вера Назарова', 'https://i.pravatar.cc/200?img=27'),
        (28, 'Игорь Осипов', 'https://i.pravatar.cc/200?img=28'),
        (29, 'Полина Павлова', 'https://i.pravatar.cc/200?img=29'),
        (30, 'Аркадий Романов', 'https://i.pravatar.cc/200?img=30')
    """.trimIndent()
        )

        db.execSQL(
            """
        INSERT INTO $tableMails (id, senderId, messageTitle, message, isBookmarked, date, isRead) VALUES
        (1001, 2, 'График собраний', 'Проверь, пожалуйста, новую версию документа.', 1, 1704208722416, 0),
        (1002, 3, 'Обратная связь', 'Не забудь про встречу завтра.', 1, 1751034265972, 1),
        (1003, 4, 'Старт проекта', 'У нас будет обновление системы в пятницу.', 0, 1691234567890, 0),
        (1004, 5, 'Командный обед', 'Я добавил задачи в Trello, посмотри.', 1, 1724062722416, 0),
        (1005, 6, 'Задачи на неделю', 'Поделись, пожалуйста, своей обратной связью.', 1, 1679149122416, 1),
        (1006, 7, 'Напоминание', 'Файлы прикреплены к письму.', 0, 1731235522416, 0),
        (1007, 8, 'Документы', 'Собрание переносится на 15:00.', 0, 1709321922416, 1),
        (1008, 9, 'Отпуск', 'Нужно срочно обсудить бюджет.', 1, 1682408322416, 0),
        (1009, 10, 'Бюджет проекта', 'Все ли в порядке с макетом?', 0, 1719494722416, 1),
        (1010, 11, 'Важная информация', 'Поздравляем с успешной сдачей этапа!', 0, 1701581122416, 1),
        (1011, 12, 'Обновление дизайна', 'Есть идея по улучшению проекта.', 0, 1722667522416, 1),
        (1012, 13, 'Согласование', 'Отправь, пожалуйста, отчёт к вечеру.', 1, 1689753922416, 0),
        (1013, 14, 'Сбор данных', 'Коллеги, не забудьте заполнить форму.', 0, 1711840322416, 1),
        (1014, 15, 'Интервью', 'Доступ к проекту открыт.', 1, 1704926722416, 1),
        (1015, 16, 'Финальный отчёт', 'Спасибо за отличную работу!', 0, 1698013122416, 0),
        (1016, 17, 'Уведомление', 'Финальная версия готова.', 1, 1720099522416, 0),
        (1017, 18, 'Встреча', 'Созвонимся по Zoom в 11:00.', 0, 1720185922416, 1),
        (1018, 19, 'Обновление системы', 'Принято, вношу изменения.', 1, 1685272322416, 0),
        (1019, 20, 'Релиз', 'Жду подтверждения по документам.', 0, 1720358722416, 1),
        (1020, 21, 'План работ', 'Проверь, пожалуйста, расписание.', 0, 1713445122416, 1),
        (1021, 22, 'Согласование бюджета', 'Жду твои комментарии по смете.', 1, 1706531522416, 0),
        (1022, 23, 'Вопрос по задаче', 'Можешь уточнить детали по задаче?', 0, 1720617922416, 1),
        (1023, 24, 'Ревью кода', 'Посмотри, пожалуйста, мой pull request.', 1, 1693704322416, 0),
        (1024, 25, 'Встреча перенесена', 'Встреча переносится на завтра.', 0, 1720790722416, 1),
        (1025, 26, 'Тестирование', 'Тесты прошли успешно.', 1, 1682877122416, 0),
        (1026, 27, 'Обновление документации', 'Документация обновлена.', 0, 1720963522416, 1),
        (1027, 28, 'Вопрос по проекту', 'Когда будет готова новая версия?', 1, 1711049922416, 0),
        (1028, 29, 'Сдача отчёта', 'Отчёт отправлен на почту.', 0, 1701136322416, 1),
        (1029, 30, 'Планёрка', 'Планёрка начнётся в 10:00.', 1, 1721222722416, 0),
        (1000, 1, 'Добро пожаловать', 'Привет! Рад видеть тебя в команде.', 0, 17098723416, 1)
    """.trimIndent()
        )
//        db.insert(tableMails, null, valuesMail)
//        db.insert(tableUsers, null, valuesUser)
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

    fun setBookmarked(mailId: Long, isBookmarked: Boolean) {
        val cv = ContentValues().apply {
            put("isBookmarked", if (isBookmarked) 1 else 0)
        }
        writableDatabase.update(
            "mails",
            cv,
            "id = ?",
            arrayOf(mailId.toString())
        )
    }
}

