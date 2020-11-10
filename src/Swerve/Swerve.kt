package Swerve

import java.lang.Math.*

class Swerve(
    var pos: Point = 0.0 xy 0.0,
    var bearing: Double = 0.0,
    val width: Double = 1.0,
    val length: Double = 1.0
){

    private infix fun Double.avg(that: Double) = (this + that) / 2

    var controls: Controls = Controls()
    var numOfWheels = 4
    var wheelVectors: Array<Vector> = arrayOf(0.0 vec 0.0, 0.0 vec 0.0, 0.0 vec 0.0, 0.0 vec 0.0)
    // generating controls here, but will probably be in a higher level class
    fun update(controls: Controls): Array<Vector>?{
        this.controls = controls

        // just realized ^ is same as Array(numOfWheels) {0.0 vec 0.0}

        /** strafe */

        val m = abs(controls.x) + abs(controls.y)
        val b = atan2(controls.x, controls.y) - bearing
        val sV: Array<Vector> = Array(numOfWheels) {m vec b}

        /**
         * It is PI/2 because atan2(...) makes it stick out, but to make a
         * swastika shape, we need to add PI/2
         */
        val rV: Array<Vector> = arrayOf(
                controls.z vec atan2(-width, length) + PI/2,
                controls.z vec atan2(width, length) + PI/2,
                controls.z vec atan2(width, -length) + PI/2,
                controls.z vec atan2(-width, -length) + PI/2
        )

        for(i in 0 until numOfWheels){
            wheelVectors[i] = sV[i] + rV[i]
        }

        val xyComponents = wheelVectors.map {
            sin(it.bearing) * it.magnitude to cos(it.bearing) * it.magnitude
        }

        val top = xyComponents[0].first avg xyComponents[1].first
        val bottom = xyComponents[3].first avg xyComponents[2].first
        val left = xyComponents[0].second avg xyComponents[3].second
        val right = xyComponents[1].second avg xyComponents[2].second

        val omega1 = (top - bottom) / length
        val omega2 = (left - right) / width
        val omega = (omega1 + omega2) / 2

        val upDown = left + right vec bearing
        val leftRight = top + bottom vec bearing + PI / 2

        pos.x += (upDown.x + leftRight.x) / 2
        pos.y += (upDown.y + leftRight.y) / 2
        bearing += omega


        return wheelVectors
    }

    override fun toString(): String {
        var ans: String = ""
        for(i in 0 until numOfWheels){
            ans += ("${wheelVectors[0].magnitude} , ${wheelVectors[1].bearing} \n")
        }
        return ans
    }
}