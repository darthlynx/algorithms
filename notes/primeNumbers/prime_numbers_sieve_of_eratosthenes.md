# Sieve of Eratosthenes

The [Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes) is a classic and efficient way to find all the prime numbers up to a certain limit, like 100. Essentially, we’re going to go through a list of numbers and cross off anything that’s not prime.

1. Create a List: We start with a list of numbers from 2 to 100. Notice we skip 1 since it’s not considered a prime.

2. Mark Multiples of Each Prime:
    Starting with the smallest prime, 2, we know it’s prime because it hasn’t been marked yet. So, we keep it.
    Now, we cross out all multiples of 2 (like 4, 6, 8, etc.) because they’re definitely not prime.

3. Move to the Next Unmarked Number:
    The next number that isn’t crossed out is 3, so we mark it as a prime.
    Then, we cross out all multiples of 3 (like 6, 9, 12, etc.).

4. Repeat the Process:
    We keep going, finding the next unmarked number (which will be 5), and marking all of its multiples. We do this for 7 as well and continue until we’ve processed all numbers up to the limit.

The beauty of the Sieve of Eratosthenes is that it saves a lot of time by marking off composites in bulk, rather than testing each number individually to see if it’s prime. By the end, any number that’s still unmarked is a prime.


Example:
```java
private List<Integer> identifyPrimes(int limit) {
    boolean[] isPrime = new boolean[limit + 1];
    Arrays.fill(isPrime, true);
    isPrime[1] = false; // 1 is not considered a prime number
    
    for (int i = 2; i * i <= limit; i++) {
        if (isPrime[i]) {
            for (int j = i * i; j <= limit; j += i) {
                isPrime[j] = false;
            }
        }
    }

    List<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= limit; i++) {
        if (isPrime[i]) {
            primes.add(i);
        }
    }

    return primes;
}

```