package future.skill.problems;

import java.util.ArrayList;
import java.util.List;

public class NthPrime {
    /**
     * Return the first twelve prime numbers as a list of integers.
     */
    public List<Integer> level1First12Primes() {
        // Write your code here
        return getNPrimes(12);
    }

    /**
     * Return the nth prime number. The integer n is an input parameter and
     * your program should return an integer; the nth prime.
     */
    public int level2NthPrime(int n) {
        // Write your code here
        return getNPrimes(n).get(n -1);
    }

    private List<Integer> getNPrimes(int n) {
        List<Integer> primes = new ArrayList<>(n);

        int current = 2;

        while (primes.size() < n) {
            boolean isPrime = true;
            for (int p : primes) {
                if (current % p == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primes.add(current);
            }
            current++;
        }

        return primes;
    }
}
