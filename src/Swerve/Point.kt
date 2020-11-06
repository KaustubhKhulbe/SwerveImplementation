package Swerve


infix fun Double.xy(that: Double) = Point(this, that)

/**
 * Represents a point on a cartesian plane
 *
 * @property x value of the point
 * @property y value of the point
 */
data class Point(
    var x: Double,
    var y: Double
) {
    override fun toString() = "($x, $y)"
}