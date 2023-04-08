fun main(args: Array<String>) {
    var data = mutableListOf<ziz>()

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
                println("Введите фамилию:")
                val fam = readLine() ?: ""
                println("Введите число программ:")
                val chpr = readLine()?.toDoubleOrNull() ?: 0.0
                println("Введите число языков:")
                val chya = readLine()?.toDoubleOrNull() ?: 0.0

                val z = ziz(fam, chpr, chya)
                data.add(z)
            }
            "2" -> {
                // Поиск данных
                println("Введите фамилию для поиска:")
                val query = readLine() ?: ""

                val results = data.filter { it.fam.contains(query) }
                if (results.isEmpty()) {
                    println("Данные не найдены")
                } else {
                    println("Результаты поиска:")
                    results.forEach {
                        println("Фамилия: ${it.fam}")
                        println("Число программ: ${it.chpr}")
                        println("Число языков: ${it.chya}")
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
                        println("Фамилия: ${it.fam}")
                        println("Число программ: ${it.chpr}")
                        println("Число языков: ${it.chya}")
                        println("Q= ${it.q()}")
                    }
                }
            }
            "4" -> {
                // Фильтрация данных
                println("Выберите поле для фильтра:")
                println("1 - Фамилия")
                println("2 - Число программ")
                println("3 - Число языков")

                val filterCmd = readLine()

                val filtered = when (filterCmd) {
                    "1" -> {
                        println("Введите фамилию для фильтра:")
                        val query = readLine() ?: ""
                        data.filter { it.fam.contains(query) }
                    }
                    "2" -> {
                        println("Введите минимальное число программ для фильтра:")
                        val minChpr = readLine()?.toDoubleOrNull() ?: 0.0
                        data.filter { it.chpr >= minChpr }
                    }
                    "3" -> {
                        println("Введите минимальное число языков для фильтра:")
                        val minChya = readLine()?.toDoubleOrNull() ?: 0.0
                        data.filter { it.chya >= minChya }
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
                        println("Фамилия: ${it.fam}")
                        println("Число программ: ${it.chpr}")
                        println("Число языков: ${it.chya}")
                        println("Q= ${it.q()}")
                    }
                }
            }
            "5" -> {
                // Удаление данных
                println("Введите фамилию для удаления:")
                val query = readLine() ?: ""

                val removed = data.removeAll { it.fam.contains(query) }
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


