package step3.util

object RandomGenerator : NumberGenerator {
    override fun generate(minValue: Int, maxValue: Int): Int {
        return (minValue..maxValue).random()
    }
}
