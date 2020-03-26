fun main(){
    val manager = ClientManager()
    val client = manager.findClient("gdlee")

    //println(manager.getPoint(client!!))
    if(client != null)
        println(manager.getPoint(client))
    else
        println("아이디 확인 요망~~")
}