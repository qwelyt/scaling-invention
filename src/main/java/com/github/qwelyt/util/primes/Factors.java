package com.github.qwelyt.util.primes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Factors {
   public static List<Integer> of(final int number) {
      return factors(number).filter(i -> i != 1).boxed().collect(Collectors.toList());
   }

   private static IntStream factors(final int number) {
      return IntStream.rangeClosed(2, number)
            .filter(x -> number % x == 0)
            .mapToObj(x -> IntStream.concat(IntStream.of(x), factors(number / x)))
            .findFirst()
            .orElse(IntStream.of(number));
   }
}
