package top_interviews_150_study


fun main() {

    isAnagram("anagram", "nagaram").also {
        println("res $it")
    }
}
/** using hashMap to store the chars as keys with their counts
 * compare with the second string if they match.. both must be the same length
 * Another solution is sort both, then compare -> memory O(1)
 * */
fun isAnagram(s: String, t: String): Boolean {

    val myHashMap = hashMapOf<Char, Int>()

    if (s.length != t.length) return false

    for (i in 0 until s.length) {

        val key = s[i]

        if (!myHashMap.containsKey(key)) {
            myHashMap[key] = 1
        } else {

            val storedValue = myHashMap[key]
            storedValue?.let {
                myHashMap[key] = it + 1
            }

        }
    }

    for (i in 0 until t.length) {

        val char = t[i]

        if (myHashMap.containsKey(char)) {
            val storedValue = myHashMap[char]

            storedValue?.let {
                myHashMap[char] = it - 1
            }
        }
    }


    for ((_, value) in myHashMap) {
        if (value != 0) return false
    }


    return true
}