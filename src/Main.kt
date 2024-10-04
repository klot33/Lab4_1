import kotlin.random.Random

fun main() {
    println("Добро пожаловать в игру Камень-Ножницы-Бумага!")
    println("Правила:")
    println("1 - Камень")
    println("2 - Ножницы")
    println("3 - Бумага")
    println("Введите 'q' для выхода из игры в любой момент.\n")

    while (true) {
        print("Ваш выбор (1 - Камень, 2 - Ножницы, 3 - Бумага): ")
        val userInput = readLine()

        if (userInput == null) {
            println("Ошибка: Ввод не может быть пустым. Пожалуйста, попробуйте снова.\n")
            continue
        }

        if (userInput.lowercase() == "q") {
            println("Спасибо за игру! До свидания!")
            break
        }

        val userChoice = userInput.toIntOrNull()
        if (userChoice == null || userChoice !in 1..3) {
            println("Ошибка: Некорректный ввод. Пожалуйста, введите 1, 2 или 3.\n")
            continue
        }

        val computerChoice = Random.nextInt(1, 4)

        println("Вы выбрали: ${choiceToString(userChoice)}")
        println("Компьютер выбрал: ${choiceToString(computerChoice)}")

        when {
            userChoice == computerChoice -> {
                println("Ничья! Переигрываем...\n")
            }
            isUserWinner(userChoice, computerChoice) -> {
                println("Вы победили!\n")
                break
            }
            else -> {
                println("Компьютер победил! Переигрываем...\n")
            }
        }
    }
}

fun choiceToString(choice: Int): String {
    return when (choice) {
        1 -> "Камень"
        2 -> "Ножницы"
        3 -> "Бумага"
        else -> "Неизвестно"
    }
}

fun isUserWinner(user: Int, computer: Int): Boolean {
    return (user == 1 && computer == 2) || // Камень выигрывает
            (user == 2 && computer == 3) || // Ножницы выигрывают
            (user == 3 && computer == 1)    // Бумага выигрывает
}