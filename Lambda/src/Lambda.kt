fun main(){
    //타입을 명시해주지 않아서 뒤에서 명시, 제일 마지막에 있는 값을 반환
    val add = {x:Int, y:Int -> x+y}
    println(add(10, 20))

    //타입을 명시적으로 지정해주었으니 생략 가능, 제일 마지막에 있는 값을 반환
    val add2:(Int, Int)->Int = {x, y -> x+y}
    println(add2(20, 30))

    //반환되는 값은 없고 그냥 출력하고 끝내는 구문
    val add3 = {x:Int, y:Int -> println(x+y)}
    add3(10, 20)

    //변수에 대입하지 않고 사용
    println({x:Int, y:Int -> x+y}(10, 20))
}