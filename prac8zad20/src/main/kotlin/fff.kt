fun main(args: Array<String>) {
    var data = mutableListOf<eyyy>()

    while (true) {
        println("Выберите команду:")
        println("1 - Ввод новых данных")
        println("2 - Поиск данных")
        println("3 - Вывод всех данных")
        println("4 - Фильтрация данных")
        println("5 - Удаление данных")
        println("0 - Выход")

        val cmd = readLine() // Чтение команды от пользователя

        when (cmd) {
            "1" -> {
                // Ввод новых данных
                println("Введите название:")
                val naz = readLine() ?: ""
                println("Введите число операторов:")
                val n1 = readLine()?.toDoubleOrNull() ?: 0.0
                println("Введите число учасников:")
                val n2 = readLine()?.toDoubleOrNull() ?: 0.0

                val z = eyyy(naz, n1, n2)
                data.add(z)
            }
            "2" -> {
                // Поиск данных
                println("Введите фамилию для поиска:")
                val query = readLine() ?: ""

                val results = data.filter { it.naz.contains(query) }
                if (results.isEmpty()) {
                    println("Данные не найдены")
                } else {
                    println("Результаты поиска:")
                    results.forEach {
                        println("Название: ${it.naz}")
                        println("Число операторов: ${it.n1}")
                        println("Число участников: ${it.n2}")
                        println("Q= ${it.q()}")
                    }
                }
            }
            "3" -> {
                // Вывод всех данных
                if (data.isEmpty()) {
                    println("Нет данных для вывода")
                } else {
                    println("Все сохраненные данные:")
                    data.forEach {
                        println("Название: ${it.naz}")
                        println("Число операторов: ${it.n1}")
                        println("Число участников: ${it.n2}")
                        println("Q= ${it.q()}")
                    }
                }
            }
            "4" -> {
                // Фильтрация данных
                println("Выберите поле для фильтра:")
                println("1 - Название")
                println("2 - Число операторов")
                println("3 - Число учасников")

                val filterCmd = readLine()

                val filtered = when (filterCmd) {
                    "1" -> {
                        println("Введите фамилию для фильтра:")
                        val query = readLine() ?: ""
                        data.filter { it.naz.contains(query) }
                    }
                    "2" -> {
                        println("Введите минимальное число программ для фильтра:")
                        val minn1 = readLine()?.toDoubleOrNull() ?: 0.0
                        data.filter { it.n1 >= minn1 }
                    }
                    "3" -> {
                        println("Введите минимальное число языков для фильтра:")
                        val minn2 = readLine()?.toDoubleOrNull() ?: 0.0
                        data.filter { it.n2 >= minn2 }
                    }
                    else -> {
                        println("Неверная команда")
                        emptyList()
                    }
                }

                if (filtered.isEmpty()) {
                    println("Нет данных для фильтрации")
                } else {
                    println("Результаты фильтрации:")
                    filtered.forEach {
                        println("Название: ${it.naz}")
                        println("Число операторов: ${it.n1}")
                        println("Число участников: ${it.n2}")
                        println("Q= ${it.q()}")
                    }
                }
            }
            "5" -> {
                // Удаление данных
                println("Введите название для удаления:")
                val query = readLine() ?: ""

                val removed = data.removeAll { it.naz.contains(query) }
                if (removed) {
                    println("Данные успешно удалены")
                } else {
                    println("Данные не найдены")
                }
            }
            "0" -> {
                // Выход
                return
            }
            else -> {
                println("Неверная команда")
            }
        }
    }
}


