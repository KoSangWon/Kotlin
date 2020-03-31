import java.io.File
import java.util.*

class ClientManager {
    private val clientById = mutableMapOf<String, Client>()
    private val clientByName = mutableMapOf<String, Client>()
    private val clientByTel = mutableMapOf<String, Client>()

    init {
        val scan = Scanner(File("client.txt"))
        while (scan.hasNext()) {
            val str = scan.nextLine()
            val line = str.split(" ")
            //println(line)

            clientById[line[0]] = Client(line[0], line[1], line[2], line[3].toInt())
            clientByName[line[1]] = Client(line[0], line[1], line[2], line[3].toInt())
            clientByTel[line[2]] = Client(line[0], line[1], line[2], line[3].toInt())
        }
    }

    private fun checkIsSameName():Boolean{
        val nameList = mutableListOf("")
        val scan = Scanner(File("client.txt"))
        while(scan.hasNext()){
            val str = scan.nextLine()
            val line = str.split(" ")
            val findValue = line[1]
            val found: Boolean = nameList.contains(findValue)
            if(!found) {
                nameList.add(line[1])
            }else{
                return false
            }
        }
        return true
    }

    private fun findClientById(id: String) = clientById[id]
    private fun findClientByName(name: String) = clientByName[name]
    private fun findClientByTel(tel: String) = clientByTel[tel]

    private fun getId(c: Client) = c.id
    private fun getName(c: Client) = c.name
    private fun getTel(c: Client) = c.tel
    private fun getPoint(c: Client) = c.point

    private fun getIdByName(){
        if(!checkIsSameName()) {
            println("동명이인이 존재합니다. 전화번호로 찾으세요.")
            return
        }
        print("이름 입력 : ")
        val name = readLine()!!
        val client = findClientByName(name)
        if(client != null)
            println(getId(client))
        else
            println("입력한 이름이 없습니다.")
    }

    private fun getIdByTel(){
        print("전화번호 입력 : ")
        val tel = readLine()!!
        val client = findClientByTel(tel)
        if(client != null)
            println(getId(client))
        else
            println("입력한 전화번호가 없습니다.")
    }

    fun findId(){
        while(true) {
            print("1. 이름으로 찾기\n2. 전화번호로 찾기\n")
            print("입력 : ")
            val number = readLine()!!.toInt()
            if(number == 1){
                getIdByName()
                break
            } else if(number == 2){
                getIdByTel()
                break
            } else{
                println("1 또는 2를 입력하세요.")
            }
        }
    }

    private fun getNameByID(){
        print("ID 입력 : ")
        val id = readLine()!!
        val client = findClientById(id)
        if(client != null)
            println(getName(client))
        else
            println("입력한 ID가 없습니다.")
    }

    private fun getNameByTel(){
        print("전화번호 입력 : ")
        val tel = readLine()!!
        val client = findClientByTel(tel)
        if(client != null)
            println(getName(client))
        else
            println("입력한 전화번호가 없습니다.")
    }

    fun findName(){
        while(true) {
            print("1. ID로 찾기\n2. 전화번호로 찾기\n")
            print("입력 : ")
            val number = readLine()!!.toInt()
            if(number == 1){
                getNameByID()
                break
            } else if(number == 2){
                getNameByTel()
                break
            } else{
                println("1 또는 2를 입력하세요.")
            }
        }
    }


    private fun getTelByID(){
        print("ID 입력 : ")
        val id = readLine()!!
        val client = findClientById(id)
        if(client != null)
            println(getTel(client))
        else
            println("입력한 ID가 없습니다.")
    }

    private fun getTelByName(){
        if(!checkIsSameName()) {
            println("동명이인이 존재합니다. ID로 찾으세요.")
            return
        }
        print("이름 입력 : ")
        val name = readLine()!!
        val client = findClientByName(name)
        if(client != null)
            println(getTel(client))
        else
            println("입력한 이름이 없습니다.")
    }

    fun findTel(){
        while(true) {
            print("1. ID로 찾기\n2. 이름으로 찾기\n")
            print("입력 : ")
            val number = readLine()!!.toInt()
            if(number == 1){
                getTelByID()
                break
            } else if(number == 2){
                getTelByName()
                break
            } else{
                println("1 또는 2를 입력하세요.")
            }
        }
    }

    private fun getPointByID(){
        print("ID 입력 : ")
        val id = readLine()!!
        val client = findClientById(id)
        if(client != null)
            println(getPoint(client))
        else
            println("입력한 ID가 없습니다.")
    }

    private fun getPointByTel(){
        print("전화번호 입력 : ")
        val tel = readLine()!!
        val client = findClientByTel(tel)
        if(client != null)
            println(getPoint(client))
        else
            println("입력한 전화번호가 없습니다.")
    }

    private fun getPointByName(){
        if(!checkIsSameName()) {
            println("동명이인이 존재합니다. ID나 전화번호로 찾으세요.")
            return
        }
        print("이름 입력 : ")
        val name = readLine()!!
        val client = findClientByName(name)
        if(client != null)
            println(getPoint(client))
        else
            println("입력한 이름이 없습니다.")
    }

    fun findPoint(){
        while(true) {
            print("1. ID로 찾기\n2. 전화번호로 찾기\n3. 이름으로 찾기\n")
            print("입력 : ")
            val number = readLine()!!.toInt()
            if(number == 1){
                getPointByID()
                break
            } else if(number == 2){
                getPointByTel()
                break
            } else if(number == 3) {
                getPointByName()
                break
            } else{
                println("1, 2, 3 중 하나를 입력하세요.")
            }
        }
    }
}
