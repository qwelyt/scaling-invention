package com.github.qwelyt.util.primes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class Primes {

   public static List<Integer> primes(final int start, final int numberOfPrimes) {
      return Stream.iterate(primeAfter(start - 1), Primes::primeAfter)
            .limit(numberOfPrimes)
            .collect(Collectors.toList());
   }

   private static int primeAfter(final int number) {
      if (isPrime(number + 1)) {
         return number + 1;
      }
      return primeAfter(number + 1);
   }

   private static boolean isPrime(final int number) {
      return number > 1
            && IntStream.rangeClosed(2, (int) Math.sqrt(number))
            .noneMatch(divisor -> number % divisor == 0);
   }
}
