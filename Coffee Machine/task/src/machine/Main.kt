package machine

val cm = CoffeeMachine()

fun main() {
    do {
        print(cm.getPrompt())
   } while (cm.process(readLine()!!))
}
