package top_interviews_150_study

fun main() {
    isIsomorphic("badc", "baba").also {
        println("res $it")
    }
}

fun isIsomorphic(s: String, t: String): Boolean {

    val myHashMap = hashMapOf<Char, Char>()
    for (i in 0 until s.length) {

        val key = s[i]
        val value = t[i]

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