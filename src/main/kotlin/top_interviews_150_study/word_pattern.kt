package top_interviews_150_study

fun main() {
    wordPattern("abba", "dog cat cat dog").also {
        println("res $it")
    }
}

fun wordPattern(pattern: String, s: String): Boolean {

    val words = s.split(" ")

    words.forEach { println(it) }

    if (words.size != pattern.length) return false

    val myHashMap = hashMapOf<Char, String>()
    for (i in 0 until pattern.length) {

        val key = pattern[i]
        val value = words[i]

        if (!myHashMap.containsKey(key)) {

            if (myHashMap.containsValue(value)) return false

            myHashMap[key] = value

        } else {

            val storedValue = myHashMap[key]
            if (storedValue != value) return false
        }
    }

    return true
}