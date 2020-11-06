package Swerve

/**
 * @property x = how much to move in x dir
 * @property y = how much to move in y dir
 * @property z = what direction
 */
data class Controls(
    var x: Double = 0.0,
    var y: Double = 0.0,
    var z: Double = 0.0
)