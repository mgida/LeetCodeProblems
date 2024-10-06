package top_interviews_150_study

import java.util.*

fun main() {
    isValid("()[]{}").also {
        println("res $it")
    }
}


fun isValid(s: String): Boolean {

    val myHashMap = hashMapOf<Char, Char>()

    myHashMap[')'] = '('
    myHashMap[']'] = '['
    myHashMap['}'] = '{'


    val myStack = Stack<Char>()

    for (char in s) {

        if (myHashMap.containsKey(char)) {

            if (myStack.isNotEmpty() && myStack.last() == myHashMap[char]) {
                myStack.pop()
            } else {
                return false
            }

        } else {
            myStack.push(char)
        }
    }

    return myStack.isEmpty()
}