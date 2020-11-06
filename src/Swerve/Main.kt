package Swerve

fun main(){
    var swerve = Swerve()

    for(i in 0..100){
        swerve.update( Controls(10.0, 1000.0, 10.0))
    }

    println(swerve.toString())

}