//High-Order Function
fun calculate(x:Int, y:Int, func:(Int, Int)->Int):Int{
    return func(x, y)
}

//Extension Function
fun String.removeFirstLastChar():String = this.substring(1, this.length-1)

fun main(){
    println(calculate(10,20){x,y->x+y})
    println(calculate(10,20){x,y->x*y})
    println(calculate(10,20){x,y->if(x>y)x else y})

    println("HelloWorld".removeFirstLastChar())
}