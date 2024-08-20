package top_interviews_150_study

fun main() {
    val s = "abc"
    val t = "ahbgdc"

    isSubsequence(s, t).also { println(it) }
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.isEmpty()) return true
    var i = 0
    var j = 0

    for (k in t.indices) {

        if (s[i] == t[j]) {
            i++
            j++

            if (i == s.length) return true
        } else {
            j++
            if (j == t.length) return false
        }

    }

    return false
}