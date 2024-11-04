package daily


fun main() {
    makeFancyString1("leeetcodeee").also {
        println("res $it")
    }
}

fun makeFancyString1(s: String): String {
    /** append the first char to the builder and loop from the second char till the end
     * check if value matched in current, its previous, its next
     * if so don't append the value
     * */

    val res = StringBuilder()
    res.append(s[0])


    for (i in 1..<s.length) {

        if (i + 1 < s.length) {
            val matched = (s[i] == s[i + 1]) && s[i] == s[i - 1]

            if (!matched) {
                res.append(s[i])
            }

        } else {
            res.append(s[i])
        }
    }

    return res.toString()
}

fun makeFancyString2(s: String): String {
    val res = StringBuilder()

    var count = 0 /** count the occurrence of the consequent chars*/
    var last = ' ' /** will be updated with last checked value*/

    for (char in s) {

        count = if (char == last) count + 1 else 1

        if (count <= 2) {
            res.append(char)
        }

        last = char
    }

    return res.toString()
}