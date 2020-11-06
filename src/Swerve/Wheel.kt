package Swerve

/**
 * This is a wheel on the robot
 * xPos and yPos, correspond to each of the 4 locations on the bot
 * (-1, -1)
 * (-1, 1)
 * (1, -1)
 * (1, 1)
 */
data class Wheel(
    val xPos: Double,
    val yPos: Double,
    var vector: Vector = Vector(0.0, 0.0)
)