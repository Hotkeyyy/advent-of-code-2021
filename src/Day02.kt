fun main() {

    fun stringToPair(i: String) =
        Pair<String, Int>(i.split(" ").first(), i.split(" ").last().toInt())

    fun part1(input: List<String>): Int {
        var h = 0; var depth = 0

        input.forEach {
            val pair = stringToPair(it)
            when (pair.first) {
                "forward" -> h += pair.second
                "down" -> depth += pair.second
                "up" -> depth -= pair.second
            }
        }
        return h * depth
    }

    fun part2(input: List<String>): Int {
        var h = 0; var depth = 0; var aim = 0

        input.forEach {
            val pair = stringToPair(it)
            when (pair.first) {
                "forward" -> {
                    h += pair.second
                    depth += (pair.second * aim)
                }
                "down" -> aim += pair.second
                "up" -> aim -= pair.second
            }
        }
        return h * depth
    }

    val testInput = readInput("Day02_test")
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
