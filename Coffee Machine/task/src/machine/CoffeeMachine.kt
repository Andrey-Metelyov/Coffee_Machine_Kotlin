package machine

enum class State {
    ACTION,
    VARIANT,
    FILL_WATER,
    FILL_MILK,
    FILL_BEANS,
    FILL_CUPS
}

class CoffeeMachine(
    var water: Int = 400,
    var milk: Int = 540,
    var beans: Int = 120,
    var cups: Int = 9,
    var money: Int = 550
) {
    private var state: State = State.ACTION

    fun printState() {
        println(
            """
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
        """.trimIndent()
        )
        println()
    }

    fun getPrompt(): String {
        return when (state) {
            State.VARIANT -> "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "
            State.ACTION -> "Write action (buy, fill, take, remaining, exit): "
            State.FILL_WATER -> "Write how many ml of water do you want to add: "
            State.FILL_MILK -> "Write how many ml of milk do you want to add: "
            State.FILL_BEANS -> "Write how many grams of coffee do you want to add: "
            State.FILL_CUPS -> "Write how many disposable cups of coffee do you want to add: "
        }
    }

    private fun trackResources(
        water: Int = 0,
        milk: Int = 0,
        beans: Int = 0,
        cups: Int = 0
    ): Boolean {
        var result = true;
        if (this.water < water) {
            println("Sorry, not enough water!")
            result = false
        }
        if (this.milk < milk) {
            println("Sorry, not enough milk!")
            result = false
        }
        if (this.beans < beans) {
            println("Sorry, not enough beans!")
            result = false
        }
        if (this.cups < cups) {
            println("Sorry, not enough cups!")
            result = false
        }
        return result
    }

    fun getCappuccino() {
        // for the cappuccino, the coffee machine needs
        // 200 ml of water,
        // 100 ml of milk, and
        // 12 g of coffee.
        // It costs $6
        if (!trackResources(200, 100, 12, 1)) {
            return
        }
        water -= 200
        milk -= 100
        beans -= 12
        cups--
        money += 6
        println("I have enough resources, making you a coffee!")
    }

    fun fill(water: Int, milk: Int, beans: Int, cups: Int) {
        this.water += water
        this.milk += milk
        this.beans += beans
        this.cups += cups
//        println("I have enough resources, making you a coffee!")
    }

    fun getEspresso() {
        // For the espresso, the coffee machine needs
        // 250 ml of water and
        // 16 g of coffee beans.
        // It costs $4.
        if (!trackResources(water = 250, beans = 16, cups = 1)) {
            return
        }
        water -= 250
        beans -= 16
        cups--
        money += 4
        println("I have enough resources, making you a coffee!")
    }

    fun getLatte() {
        // For the latte, the coffee machine needs
        // 350 ml of water,
        // 75 ml of milk, and
        // 20 g of coffee beans.
        // It costs $7.
        if (!trackResources(250, 75, 16, 1)) {
            return
        }
        water -= 350
        milk -= 75
        beans -= 20
        cups--
        money += 7
        println("I have enough resources, making you a coffee!")
    }

    fun takeMoney() {
        println("I gave you \$$money\n")
        money = 0
    }

    fun process(command: String): Boolean {
        return when (state) {
            State.ACTION -> processAction(command)
            State.VARIANT -> buyCoffe(command)
            State.FILL_WATER -> fillWater(command)
            State.FILL_MILK -> fillMilk(command)
            State.FILL_BEANS -> fillBeans(command)
            State.FILL_CUPS -> fillCups(command)
        }
        return true
    }

    private fun fillCups(command: String): Boolean {
        val amount = command.toInt()
        cups += amount
        state = State.ACTION
        return true

    }

    private fun fillBeans(command: String): Boolean {
        val amount = command.toInt()
        beans += amount
        state = State.FILL_CUPS
        return true
    }

    private fun fillMilk(command: String): Boolean {
        val amount = command.toInt()
        milk += amount
        state = State.FILL_BEANS
        return true
    }

    private fun fillWater(command: String): Boolean {
        val amount = command.toInt()
        water += amount
        state = State.FILL_MILK
        return true
    }

    private fun processAction(command: String): Boolean {
        when (command) {
            "buy" -> state = State.VARIANT
            "fill" -> state = State.FILL_WATER
            "take" -> takeMoney()
            "remaining" -> printState()
            "exit" -> return false
        }
        return true
    }

    private fun buyCoffe(command: String): Boolean {
        when (command) {
            "1" -> getEspresso()
            "2" -> getLatte()
            "3" -> getCappuccino()
            "back" -> state = State.ACTION
        }
        state = State.ACTION
        return true
    }
}