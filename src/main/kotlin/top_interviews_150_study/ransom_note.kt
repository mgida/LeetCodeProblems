package top_interviews_150_study

fun main() {
    canConstruct("aaaab", "aaabb").also {
        println("res $it")
    }
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {

    val mHashMap = hashMapOf<Char, Int>()

    for (i in 0 until magazine.length) {

        if (mHashMap.containsKey(magazine[i])) {

            val currentValue = mHashMap[magazine[i]]

            if (currentValue != null) {
                mHashMap[magazine[i]] = currentValue + 1
            }
        } else {
            mHashMap[magazine[i]] = 1
        }
    }

    for (i in 0 until ransomNote.length) {
        if (mHashMap.containsKey(ransomNote[i])) {

            val currentValue = mHashMap[ransomNote[i]]

            if (currentValue == 1) {
                mHashMap.remove(ransomNote[i])
            } else {
                if (currentValue != null) {
                    mHashMap[ransomNote[i]] = currentValue - 1
                }
            }
        } else {
            return false
        }
    }

    return true
}