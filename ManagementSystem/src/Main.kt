fun main(){
    val manager = ClientManager()

    while(true) {
        print("1. ID 찾기\n2. 이름 찾기\n3. 전화번호 찾기\n4. 포인트 찾기\n5. 종료\n")
        print("입력 : ")
        val number = readLine()!!.toInt()

        if (number == 5)
            break

        when (number) {
            1 -> manager.findId()
            2 -> manager.findName()
            3 -> manager.findTel()
            4 -> manager.findPoint()
            else -> {
                print("1부터 5까지의 수만 입력해주세요.")
            }
        }
        println("\n")
    }
}