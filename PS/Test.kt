fun solution(answers : IntArray) : IntArray {

    val student1 = arrayOf(1,2,3,4,5)
    val student2 = arrayOf(2,1,2,3,2,4,2,5)
    val student3 = arrayOf(3,3,1,1,2,2,4,4,5,5)

    var answerCount = arrayOf(0,0,0)

    answers.forEachIndexed { index,
                             i ->
        if (i == student1[index.rem(student1.size)]) answerCount[0]++
        if (i == student2[index.rem(student2.size)]) answerCount[1]++
        if (i == student3[index.rem(student3.size)]) answerCount[2]++
    }

    val result = arrayListOf<Int>()

    if (answerCount[0] == answerCount.max())
        result.add(1)
    if (answerCount[1] == answerCount.max())
        result.add(2)
    if (answerCount[2] == answerCount.max())
        result.add(3)

    return result.toIntArray()
}
