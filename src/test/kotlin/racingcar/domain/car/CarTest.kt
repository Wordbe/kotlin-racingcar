package racingcar.domain.car

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.move.MovingStrategy

class CarTest {
    private val alwaysMovingStrategy = object : MovingStrategy {
        override fun canMove(): Boolean {
            return true
        }
    }
    private val alwaysNotMovingStrategy = object : MovingStrategy {
        override fun canMove(): Boolean {
            return false
        }
    }

    @Test
    fun `자동차 생성`() {
        val car = Car.of("장재주")

        assertThat(car.name.value).isEqualTo("장재주")
        assertThat(car.position.value).isEqualTo(0)
    }

    @Test
    fun `자동차 전진`() {
        val car = Car.of("장재주")

        car.move(alwaysMovingStrategy)
        assertThat(car.position.value).isEqualTo(1)
    }

    @Test
    fun `자동차 전진하지 않음`() {
        val car = Car.of("장재주")

        car.move(alwaysNotMovingStrategy)
        assertThat(car.position.value).isEqualTo(0)
    }
}
