package machine

val cm = CoffeeMachine()

fun main() {
    while (true) {
//        cm.printState()
        print("Write action (buy, fill, take, remaining, exit): ")
        when (readLine()!!) {
            "buy" -> buyCoffe()
            "fill" -> fillMachine()
            "take" -> takeMoney()
            "remaining" -> cm.printState()
            "exit" -> break
        }
    }
    /*
    print("Write how many ml of water the coffee machine has: ")
    val waterAvailable = readLine()!!.toInt()
    print("Write how many ml of milk the coffee machine has: ")
    val milkAvailable = readLine()!!.toInt()
    print("Write how many grams of coffee beans the coffee machine has: ")
    val beansAvailable = readLine()!!.toInt()
    print("Write how many cups of coffee you will need: ")
    val cups = readLine()!!.toInt()
    val water = cups * 200
    val milk = cups * 50
    val beans = cups * 15
    val canMake = kotlin.math.min(waterAvailable / 200, kotlin.math.min(milkAvailable / 50, beansAvailable / 15))

    if (canMake == cups) {
            println("Yes, I can make that amount of coffee")
    } else if (canMake > cups) {
        println("Yes, I can make that amount of coffee (and even ${canMake - cups} more than that)")
    } else {
        println("No, I can make only $canMake cups of coffee")
    }
//    println("For $cups cups of coffee you will need:")
//    println("""
//        $water ml of water
//        $milk ml of milk
//        $beans g of coffee beans
//    """.trimIndent())*/
}

fun takeMoney() {
    cm.takeMoney()
}

fun fillMachine() {
    println("Write how many ml of water do you want to add: ")
    val water = readLine()!!.toInt()
    println("Write how many ml of milk do you want to add: ")
    val milk = readLine()!!.toInt()
    println("Write how many grams of coffee beans do you want to add: ")
    val beans = readLine()!!.toInt()
    println("Write how many disposable cups of coffee do you want to add: ")
    val cups = readLine()!!.toInt()
    cm.fill(water, milk, beans, cups)
}

fun buyCoffe() {
    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    val what = readLine()!!
    when (what) {
        "1" -> cm.getEspresso()
        "2" -> cm.getLatte()
        "3" -> cm.getCappuccino()
    }

}
