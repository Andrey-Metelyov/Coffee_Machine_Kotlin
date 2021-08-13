package machine

class CoffeeMachine(var water: Int = 400, var milk: Int = 540, var beans: Int = 120, var cups: Int = 9, var money: Int = 550) {
    fun printState() {
        println("""
            The coffee machine has:
            $water of water
            $milk of milk
            $beans of coffee beans
            $cups of disposable cups
            $money of money
        """.trimIndent())
        println()
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
        if (!trackResources(250, 75 , 16, 1)) {
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
//        printState()
    }
}