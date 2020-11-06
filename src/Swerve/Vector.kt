package Swerve

import kotlin.math.*

/**
 * Vector for the <code> bearing </code> of the swerve wheel,
 * and the <code> magnitude </code>
 */

infix fun Double.vec(other: Double) = Vector(this, other)

data class Vector(
    var bearing: Double = 0.0,
    var magnitude: Double = 0.0
){
    val x get() = sin(bearing) * magnitude
    val y get() = cos(bearing) * magnitude

    operator fun plus(other: Vector) : Vector{
        val newX = this.x + other.x
        val newY = this.y + other.y
        val newMag = sqrt(newX.pow(2) + newY.pow(2))
        val newBearing = atan2(x, y)
        return newBearing vec newMag
    }
}