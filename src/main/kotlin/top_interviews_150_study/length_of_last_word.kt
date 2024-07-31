package top_interviews_150_study


fun main() {
    lengthOfLastWord("   fly me   to   the moon  ").also {
        println("length is $it")
    }
}

fun lengthOfLastWord(s: String): Int {
    var count = 0
    var len = s.length - 1
    for (i in s.length - 1 downTo 0) {

        if (!(s[i].isLetter())) {
            len--
        } else {
            break
        }
    }

    for (i in len downTo 0) {
        val char = (s[i])

        if (!char.isWhitespace()) count++
        if (char.isWhitespace()) return count
    }

    return count
}