package com.avvsoft2050.servises

class PrimesGenerator {
    companion object{

        val firstPrimes = getFirstPrimes(1000)

        fun getFirstPrimes(count: Int): MutableList<Int> {
            val firstPrimes: MutableList<Int> = ArrayList()
            if (count > 0) {
                firstPrimes.add(2)
            }
            var i = 3
            while (firstPrimes.size < count) {
                if (isPrime(i, firstPrimes)) {
                    firstPrimes.add(i)
                }
                i += 2
            }
            return firstPrimes
        }

        fun getFivePrimesRanges(length: Int, firstPrimes: MutableList<Int>): MutableList<MutableList<Int>> {
            var start = 0
            val fivePrimesRanges: MutableList<MutableList<Int>> = ArrayList()
            for (n in 0..4) {
                val nStart = (firstPrimes.size - length) / 5
                val primesRange = firstPrimes.subList(start, start + length)
                start += nStart
                fivePrimesRanges.add(primesRange)
            }
            return fivePrimesRanges
        }

        fun getRandomSixPrimesLists(fivePrimesRanges: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
            val randomSixPrimesLists: MutableList<MutableList<Int>> = ArrayList()
            for (primesRange in fivePrimesRanges) {
                val sixRandomPrimes: MutableList<Int> = ArrayList()
                while (sixRandomPrimes.size < 6) {
                    val index = (Math.random() * primesRange.size).toInt()
                    if (!sixRandomPrimes.contains(primesRange[index])) {
                        sixRandomPrimes.add(primesRange[index])
                    }
                }
                randomSixPrimesLists.add(sixRandomPrimes)
            }
            return randomSixPrimesLists
        }

        private fun isPrime(n: Int, primes: MutableList<Int>): Boolean {
            val sqrt = Math.sqrt(n.toDouble())
            for (prime in primes) {
                if (prime > sqrt) {
                    return true
                }
                if (n % prime == 0) {
                    return false
                }
            }
            return true
        }
    }
}



