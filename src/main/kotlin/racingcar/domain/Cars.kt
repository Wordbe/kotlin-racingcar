package racingcar.domain

import racingcar.dto.RacingResultDTO

class Cars(numberOfCars: Int) {

    private val cars: List<Car>

    init {
        GameManager.validateNegativeNumber(numberOfCars)
        cars = List(numberOfCars) { Car() }
    }

    fun racing() {
        cars.forEach {
            it.move(MOVEMENT_STRATEGY)
        }
    }

    fun racingResult(): List<RacingResultDTO> {
        return cars.map { RacingResultDTO(it.getDistance()) }.toList()
    }

    companion object {
        private val MOVEMENT_STRATEGY: MovementStrategy = RandomNumberMovementStrategy()
    }
}
