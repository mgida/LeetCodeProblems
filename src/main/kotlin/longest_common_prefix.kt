fun main() {
    longestCommonPrefix(arrayOf("flower", "flow", "flight")).also {
        println("longest common $it")
    }
}

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1) return strs[0]

    var shortestLength = Integer.MAX_VALUE

    for (s in strs) {
        shortestLength = Math.min(shortestLength, s.length)
    }


    for (i in 0 until shortestLength) {
        val currentChar = strs[0][i]

        for (s in strs) {
            if (s[i] != currentChar) {
                return s.substring(0, i)
            }
        }
    }

    return strs[0].substring(0, shortestLength)

//    var current = strs[0]
//    for (s in strs.drop(1)){
//        current = current.commonPrefixWith(s)
//    }
//    return current
}