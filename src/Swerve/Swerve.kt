package Swerve

import java.lang.Math.abs
import java.lang.Math.atan2

class Swerve(
    var pos: Point = 0.0 xy 0.0,
    var bearing: Double = 0.0
){
    var controls: Controls = Controls()

    // generating controls here, but will probably be in a higher level class
    fun update(): Array<Vector>?{
        var numOfWheels = 4
        var wheelVectors: Array<Vector> = arrayOf(0.0 vec 0.0, 0.0 vec 0.0, 0.0 vec, 0.0 vec 0.0)
        // just realized ^ is same as Array(numOfWheels) {0.0 vec 0.0}

        /** strafe */

        val m = abs(controls.x) + abs(controls.y)
        val b = atan2(controls.x, controls.y) - bearing
        val sV: Array<Vector> = Array(numOfWheels) {m vec b}

        return null
    }
}