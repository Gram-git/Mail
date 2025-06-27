package com.mail.impl

import com.mail.api.model.MailDto
import com.mail.api.model.UserDto

internal val mockMails = listOf(
    MailDto(
        id = 1001L,
        sender = UserDto(2L, "Борис", "Петров", avatarUrl = null),
        messageTitle = "График собраний",
        message = "Проверь, пожалуйста, новую версию документа.",
        isBookmarked = true,
        dateTimeMillis = 1704208722416, // 2 января 2024, 09:18
        isRead = false
    ),
    MailDto(
        id = 1002L,
        sender = UserDto(3L, "Светлана", "Кузнецова", avatarUrl = null),
        messageTitle = "Обратная связь",
        message = "Не забудь про встречу завтра.",
        isBookmarked = true,
        dateTimeMillis = 1751034265972, // 27 июня 2025, 19:24
        isRead = true
    ),
    MailDto(
        id = 1003L,
        sender = UserDto(4L, "Даниил", "Смирнов", avatarUrl = null),
        messageTitle = "Старт проекта",
        message = "У нас будет обновление системы в пятницу.",
        isBookmarked = false,
        dateTimeMillis = 1691234567890, // 5 августа 2023, 17:22
        isRead = false
    ),
    MailDto(
        id = 1004L,
        sender = UserDto(5L, "Екатерина", "Орлова", avatarUrl = null),
        messageTitle = "Командный обед",
        message = "Я добавил задачи в Trello, посмотри.",
        isBookmarked = true,
        dateTimeMillis = 1724062722416, // 19 августа 2024, 13:47
        isRead = false
    ),
    MailDto(
        id = 1005L,
        sender = UserDto(6L, "Фёдор", "Новиков", avatarUrl = null),
        messageTitle = "Задачи на неделю",
        message = "Поделись, пожалуйста, своей обратной связью.",
        isBookmarked = true,
        dateTimeMillis = 1679149122416, // 18 марта 2023, 08:38
        isRead = true
    ),
    MailDto(
        id = 1006L,
        sender = UserDto(7L, "Мария", "Соколова", avatarUrl = null),
        messageTitle = "Напоминание",
        message = "Файлы прикреплены к письму.",
        isBookmarked = false,
        dateTimeMillis = 1731235522416, // 11 ноября 2024, 19:05
        isRead = false
    ),
    MailDto(
        id = 1007L,
        sender = UserDto(8L, "Георгий", "Лебедев", avatarUrl = null),
        messageTitle = "Документы",
        message = "Собрание переносится на 15:00.",
        isBookmarked = false,
        dateTimeMillis = 1709321922416, // 1 марта 2024, 16:58
        isRead = true
    ),
    MailDto(
        id = 1008L,
        sender = UserDto(9L, "Людмила", "Морозова", avatarUrl = null),
        messageTitle = "Отпуск",
        message = "Нужно срочно обсудить бюджет.",
        isBookmarked = true,
        dateTimeMillis = 1682408322416, // 25 апреля 2023, 21:18
        isRead = false
    ),
    MailDto(
        id = 1009L,
        sender = UserDto(10L, "Александр", "Козлов", avatarUrl = null),
        messageTitle = "Бюджет проекта",
        message = "Все ли в порядке с макетом?",
        isBookmarked = false,
        dateTimeMillis = 1719494722416, // 27 июня 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1010L,
        sender = UserDto(11L, "Ирина", "Федорова", avatarUrl = null),
        messageTitle = "Важная информация",
        message = "Поздравляем с успешной сдачей этапа!",
        isBookmarked = false,
        dateTimeMillis = 1701581122416, // 3 декабря 2023, 22:25
        isRead = true
    ),
    MailDto(
        id = 1011L,
        sender = UserDto(12L, "Юрий", "Попов", avatarUrl = null),
        messageTitle = "Обновление дизайна",
        message = "Есть идея по улучшению проекта.",
        isBookmarked = false,
        dateTimeMillis = 1722667522416, // 3 августа 2024, 07:45
        isRead = true
    ),
    MailDto(
        id = 1012L,
        sender = UserDto(13L, "Ольга", "Семенова", avatarUrl = null),
        messageTitle = "Согласование",
        message = "Отправь, пожалуйста, отчёт к вечеру.",
        isBookmarked = true,
        dateTimeMillis = 1689753922416, // 19 июля 2023, 18:25
        isRead = false
    ),
    MailDto(
        id = 1013L,
        sender = UserDto(14L, "Михаил", "Волков", avatarUrl = null),
        messageTitle = "Сбор данных",
        message = "Коллеги, не забудьте заполнить форму.",
        isBookmarked = false,
        dateTimeMillis = 1711840322416, // 30 марта 2024, 12:12
        isRead = true
    ),
    MailDto(
        id = 1014L,
        sender = UserDto(15L, "Наталья", "Зайцева", avatarUrl = null),
        messageTitle = "Интервью",
        message = "Доступ к проекту открыт.",
        isBookmarked = true,
        dateTimeMillis = 1704926722416, // 11 января 2024, 15:45
        isRead = true
    ),
    MailDto(
        id = 1015L,
        sender = UserDto(16L, "Роман", "Егоров", avatarUrl = null),
        messageTitle = "Финальный отчёт",
        message = "Спасибо за отличную работу!",
        isBookmarked = false,
        dateTimeMillis = 1698013122416, // 23 октября 2023, 22:25
        isRead = false
    ),
    MailDto(
        id = 1016L,
        sender = UserDto(17L, "Татьяна", "Никитина", avatarUrl = null),
        messageTitle = "Уведомление",
        message = "Финальная версия готова.",
        isBookmarked = true,
        dateTimeMillis = 1720099522416, // 4 июля 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1017L,
        sender = UserDto(18L, "Виктор", "Макаров", avatarUrl = null),
        messageTitle = "Встреча",
        message = "Созвонимся по Zoom в 11:00.",
        isBookmarked = false,
        dateTimeMillis = 1720185922416, // 5 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1018L,
        sender = UserDto(19L, "Елена", "Андреева", avatarUrl = null),
        messageTitle = "Обновление системы",
        message = "Принято, вношу изменения.",
        isBookmarked = true,
        dateTimeMillis = 1685272322416, // 28 мая 2023, 06:12
        isRead = false
    ),
    MailDto(
        id = 1019L,
        sender = UserDto(20L, "Сергей", "Тихонов", avatarUrl = null),
        messageTitle = "Релиз",
        message = "Жду подтверждения по документам.",
        isBookmarked = false,
        dateTimeMillis = 1720358722416, // 7 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1020L,
        sender = UserDto(21L, "Валерия", "Гаврилова", avatarUrl = null),
        messageTitle = "План работ",
        message = "Проверь, пожалуйста, расписание.",
        isBookmarked = false,
        dateTimeMillis = 1713445122416, // 18 апреля 2024, 20:38
        isRead = true
    ),
    MailDto(
        id = 1021L,
        sender = UserDto(22L, "Григорий", "Данилов", avatarUrl = null),
        messageTitle = "Согласование бюджета",
        message = "Жду твои комментарии по смете.",
        isBookmarked = true,
        dateTimeMillis = 1706531522416, // 29 января 2024, 11:12
        isRead = false
    ),
    MailDto(
        id = 1022L,
        sender = UserDto(23L, "Василиса", "Жукова", avatarUrl = null),
        messageTitle = "Вопрос по задаче",
        message = "Можешь уточнить детали по задаче?",
        isBookmarked = false,
        dateTimeMillis = 1720617922416, // 10 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1023L,
        sender = UserDto(24L, "Павел", "Киселёв", avatarUrl = null),
        messageTitle = "Ревью кода",
        message = "Посмотри, пожалуйста, мой pull request.",
        isBookmarked = true,
        dateTimeMillis = 1693704322416, // 3 сентября 2023, 18:45
        isRead = false
    ),
    MailDto(
        id = 1024L,
        sender = UserDto(25L, "Алиса", "Литвинова", avatarUrl = null),
        messageTitle = "Встреча перенесена",
        message = "Встреча переносится на завтра.",
        isBookmarked = false,
        dateTimeMillis = 1720790722416, // 12 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1025L,
        sender = UserDto(26L, "Денис", "Мельников", avatarUrl = null),
        messageTitle = "Тестирование",
        message = "Тесты прошли успешно.",
        isBookmarked = true,
        dateTimeMillis = 1682877122416, // 30 апреля 2023, 15:12
        isRead = false
    ),
    MailDto(
        id = 1026L,
        sender = UserDto(27L, "Вера", "Назарова", avatarUrl = null),
        messageTitle = "Обновление документации",
        message = "Документация обновлена.",
        isBookmarked = false,
        dateTimeMillis = 1720963522416, // 14 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1027L,
        sender = UserDto(28L, "Игорь", "Осипов", avatarUrl = null),
        messageTitle = "Вопрос по проекту",
        message = "Когда будет готова новая версия?",
        isBookmarked = true,
        dateTimeMillis = 1711049922416, // 21 марта 2024, 21:38
        isRead = false
    ),
    MailDto(
        id = 1028L,
        sender = UserDto(29L, "Полина", "Павлова", avatarUrl = null),
        messageTitle = "Сдача отчёта",
        message = "Отчёт отправлен на почту.",
        isBookmarked = false,
        dateTimeMillis = 1701136322416, // 28 ноября 2023, 08:12
        isRead = true
    ),
    MailDto(
        id = 1029L,
        sender = UserDto(30L, "Аркадий", "Романов", avatarUrl = null),
        messageTitle = "Планёрка",
        message = "Планёрка начнётся в 10:00.",
        isBookmarked = true,
        dateTimeMillis = 1721222722416, // 17 июля 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1000L,
        sender = UserDto(1L, "Анна", "Иванова", avatarUrl = null),
        messageTitle = "Добро пожаловать",
        message = "Привет! Рад видеть тебя в команде.",
        isBookmarked = false,
        dateTimeMillis = 17098723416, // 19 июня 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1001L,
        sender = UserDto(2L, "Борис", "Петров", avatarUrl = null),
        messageTitle = "График собраний",
        message = "Проверь, пожалуйста, новую версию документа.",
        isBookmarked = true,
        dateTimeMillis = 1704208722416, // 2 января 2024, 09:18
        isRead = false
    ),
    MailDto(
        id = 1002L,
        sender = UserDto(3L, "Светлана", "Кузнецова", avatarUrl = null),
        messageTitle = "Обратная связь",
        message = "Не забудь про встречу завтра.",
        isBookmarked = true,
        dateTimeMillis = 1718889922416, // 20 июня 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1003L,
        sender = UserDto(4L, "Даниил", "Смирнов", avatarUrl = null),
        messageTitle = "Старт проекта",
        message = "У нас будет обновление системы в пятницу.",
        isBookmarked = false,
        dateTimeMillis = 1691234567890, // 5 августа 2023, 17:22
        isRead = false
    ),
    MailDto(
        id = 1004L,
        sender = UserDto(5L, "Екатерина", "Орлова", avatarUrl = null),
        messageTitle = "Командный обед",
        message = "Я добавил задачи в Trello, посмотри.",
        isBookmarked = true,
        dateTimeMillis = 1719062722416, // 22 июня 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1005L,
        sender = UserDto(6L, "Фёдор", "Новиков", avatarUrl = null),
        messageTitle = "Задачи на неделю",
        message = "Поделись, пожалуйста, своей обратной связью.",
        isBookmarked = true,
        dateTimeMillis = 1679149122416, // 18 марта 2023, 08:38
        isRead = true
    ),
    MailDto(
        id = 1006L,
        sender = UserDto(7L, "Мария", "Соколова", avatarUrl = null),
        messageTitle = "Напоминание",
        message = "Файлы прикреплены к письму.",
        isBookmarked = false,
        dateTimeMillis = 1719235522416, // 24 июня 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1007L,
        sender = UserDto(8L, "Георгий", "Лебедев", avatarUrl = null),
        messageTitle = "Документы",
        message = "Собрание переносится на 15:00.",
        isBookmarked = false,
        dateTimeMillis = 1709321922416, // 1 марта 2024, 16:58
        isRead = true
    ),
    MailDto(
        id = 1008L,
        sender = UserDto(9L, "Людмила", "Морозова", avatarUrl = null),
        messageTitle = "Отпуск",
        message = "Нужно срочно обсудить бюджет.",
        isBookmarked = true,
        dateTimeMillis = 1719408322416, // 26 июня 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1009L,
        sender = UserDto(10L, "Александр", "Козлов", avatarUrl = null),
        messageTitle = "Бюджет проекта",
        message = "Все ли в порядке с макетом?",
        isBookmarked = false,
        dateTimeMillis = 1719494722416, // 27 июня 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1010L,
        sender = UserDto(11L, "Ирина", "Федорова", avatarUrl = null),
        messageTitle = "Важная информация",
        message = "Поздравляем с успешной сдачей этапа!",
        isBookmarked = false,
        dateTimeMillis = 1701581122416, // 3 декабря 2023, 22:25
        isRead = true
    ),
    MailDto(
        id = 1011L,
        sender = UserDto(12L, "Юрий", "Попов", avatarUrl = null),
        messageTitle = "Обновление дизайна",
        message = "Есть идея по улучшению проекта.",
        isBookmarked = false,
        dateTimeMillis = 1719667522416, // 29 июня 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1012L,
        sender = UserDto(13L, "Ольга", "Семенова", avatarUrl = null),
        messageTitle = "Согласование",
        message = "Отправь, пожалуйста, отчёт к вечеру.",
        isBookmarked = true,
        dateTimeMillis = 1689753922416, // 19 июля 2023, 18:25
        isRead = false
    ),
    MailDto(
        id = 1013L,
        sender = UserDto(14L, "Михаил", "Волков", avatarUrl = null),
        messageTitle = "Сбор данных",
        message = "Коллеги, не забудьте заполнить форму.",
        isBookmarked = false,
        dateTimeMillis = 1719840322416, // 1 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1014L,
        sender = UserDto(15L, "Наталья", "Зайцева", avatarUrl = null),
        messageTitle = "Интервью",
        message = "Доступ к проекту открыт.",
        isBookmarked = true,
        dateTimeMillis = 1704926722416, // 11 января 2024, 15:45
        isRead = true
    ),
    MailDto(
        id = 1015L,
        sender = UserDto(16L, "Роман", "Егоров", avatarUrl = null),
        messageTitle = "Финальный отчёт",
        message = "Спасибо за отличную работу!",
        isBookmarked = false,
        dateTimeMillis = 1720013122416, // 3 июля 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1016L,
        sender = UserDto(17L, "Татьяна", "Никитина", avatarUrl = null),
        messageTitle = "Уведомление",
        message = "Финальная версия готова.",
        isBookmarked = true,
        dateTimeMillis = 1720099582316, // 4 июля 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1017L,
        sender = UserDto(18L, "Виктор", "Макаров", avatarUrl = null),
        messageTitle = "Встреча",
        message = "Созвонимся по Zoom в 11:00.",
        isBookmarked = false,
        dateTimeMillis = 1720185922416, // 5 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1018L,
        sender = UserDto(19L, "Елена", "Андреева", avatarUrl = null),
        messageTitle = "Обновление системы",
        message = "Принято, вношу изменения.",
        isBookmarked = true,
        dateTimeMillis = 1720272322416, // 6 июля 2024, 10:25
        isRead = false
    ),
    MailDto(
        id = 1019L,
        sender = UserDto(20L, "Сергей", "Тихонов", avatarUrl = null),
        messageTitle = "Релиз",
        message = "Жду подтверждения по документам.",
        isBookmarked = false,
        dateTimeMillis = 1720358722416, // 7 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1020L,
        sender = UserDto(21L, "Валерия", "Гаврилова", avatarUrl = null),
        messageTitle = "План работ",
        message = "Проверь, пожалуйста, расписание.",
        isBookmarked = false,
        dateTimeMillis = 1720445122416, // 8 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1021L,
        sender = UserDto(22L, "Григорий", "Данилов", avatarUrl = null),
        messageTitle = "Согласование бюджета",
        message = "Жду твои комментарии по смете.",
        isBookmarked = true,
        dateTimeMillis = 1706531522416, // 29 января 2024, 11:12
        isRead = false
    ),
    MailDto(
        id = 1022L,
        sender = UserDto(23L, "Василиса", "Жукова", avatarUrl = null),
        messageTitle = "Вопрос по задаче",
        message = "Можешь уточнить детали по задаче?",
        isBookmarked = false,
        dateTimeMillis = 1720617922416, // 10 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1023L,
        sender = UserDto(24L, "Павел", "Киселёв", avatarUrl = null),
        messageTitle = "Ревью кода",
        message = "Посмотри, пожалуйста, мой pull request.",
        isBookmarked = true,
        dateTimeMillis = 1693704322416, // 3 сентября 2023, 18:45
        isRead = false
    ),
    MailDto(
        id = 1024L,
        sender = UserDto(25L, "Алиса", "Литвинова", avatarUrl = null),
        messageTitle = "Встреча перенесена",
        message = "Встреча переносится на завтра.",
        isBookmarked = false,
        dateTimeMillis = 1720790722416, // 12 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1025L,
        sender = UserDto(26L, "Денис", "Мельников", avatarUrl = null),
        messageTitle = "Тестирование",
        message = "Тесты прошли успешно.",
        isBookmarked = true,
        dateTimeMillis = 1682877122416, // 30 апреля 2023, 15:12
        isRead = false
    ),
    MailDto(
        id = 1026L,
        sender = UserDto(27L, "Вера", "Назарова", avatarUrl = null),
        messageTitle = "Обновление документации",
        message = "Документация обновлена.",
        isBookmarked = false,
        dateTimeMillis = 1720963522416, // 14 июля 2024, 10:25
        isRead = true
    ),
    MailDto(
        id = 1027L,
        sender = UserDto(28L, "Игорь", "Осипов", avatarUrl = null),
        messageTitle = "Вопрос по проекту",
        message = "Когда будет готова новая версия?",
        isBookmarked = true,
        dateTimeMillis = 1711049922416, // 21 марта 2024, 21:38
        isRead = false
    ),
    MailDto(
        id = 1028L,
        sender = UserDto(29L, "Полина", "Павлова", avatarUrl = null),
        messageTitle = "Сдача отчёта",
        message = "Отчёт отправлен на почту.",
        isBookmarked = false,
        dateTimeMillis = 1701136322416, // 28 ноября 2023, 08:12
        isRead = true
    ),
    MailDto(
        id = 1029L,
        sender = UserDto(30L, "Аркадий", "Романов", avatarUrl = null),
        messageTitle = "Планёрка",
        message = "Планёрка начнётся в 10:00.",
        isBookmarked = true,
        dateTimeMillis = 1721222722416, // 17 июля 2024, 10:25
        isRead = false
    )
)