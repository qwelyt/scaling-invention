package com.github.qwelyt.util;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class Fibonacci {
   public static List<BigInteger> fibs(final Integer howManyNumbers) {
      return Stream.iterate(new BigInteger[]{BigInteger.ZERO, BigInteger.ONE}, a -> new BigInteger[]{a[1], a[0].add(a[1])})
            .limit(howManyNumbers)
            .map(a -> a[0])
            .collect(Collectors.toList());
   }
}
