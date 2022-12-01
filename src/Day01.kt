data class Elf(val snacks: List<Int>) {
    val totalCalories: Int = snacks.sum()
}


fun main() {
    // Groups of snacks are separated by a blank line.
    fun parseElves(lines: List<String>): List<Elf> {
        val elves = mutableListOf<Elf>()
        var snacks = mutableListOf<Int>()
        for (line in lines) {
            if (line.isBlank()) {
                elves.add(Elf(snacks))
                snacks = mutableListOf()
            } else {
                snacks.add(line.toInt())
            }
        }
        elves.add(Elf(snacks))
        return elves
    }

    // Return max total calories.
    fun part1(input: List<String>): Int {
        val elves = parseElves(input)
        return elves.maxOf { it.totalCalories }
    }

    // return total calories of top three elves.
    fun part2(input: List<String>): Int {
        val elves = parseElves(input)
        return elves.sortedByDescending { it.totalCalories }.take(3).sumOf { it.totalCalories }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    val testResult = part1(testInput)
    println("Test max value: $testResult")

    val input = readInput("Day01")
    val result = part1(input)
    println("Max value: $result")

    val result2 = part2(input)
    println("Max three values: $result2")
}