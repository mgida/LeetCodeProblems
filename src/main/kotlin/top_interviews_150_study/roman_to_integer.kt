package top_interviews_150_study

fun main() {
    romanToInt("LVIII").also {
        println(it)
    }
}

fun romanToInt(s: String): Int {
    val romanDB = HashMap<Char, Int>()
    romanDB['I'] = 1
    romanDB['V'] = 5
    romanDB['X'] = 10
    romanDB['L'] = 50
    romanDB['C'] = 100
    romanDB['D'] = 500
    romanDB['M'] = 1000

    val lastValueKey = s.last()

    var sum = romanDB.getValue(lastValueKey)

    for (i in 0..<s.length - 1) {

        val currentValue = romanDB.getValue(s[i])
        val nextValue = romanDB.getValue(s[i + 1])

        if (currentValue < nextValue) {
            sum -= currentValue
        } else {
            sum += currentValue
        }
    }

    return sum
}