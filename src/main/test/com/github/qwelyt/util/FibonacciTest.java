package com.github.qwelyt.util;

import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FibonacciTest {

   @Test
   public void testFibOf10() {
      asserter(10, Arrays.asList(
            BigInteger.ZERO
            , BigInteger.ONE
            , BigInteger.valueOf(1)
            , BigInteger.valueOf(2)
            , BigInteger.valueOf(3)
            , BigInteger.valueOf(5)
            , BigInteger.valueOf(8)
            , BigInteger.valueOf(13)
            , BigInteger.valueOf(21)
            , BigInteger.valueOf(34)
      ));
   }

   private void asserter(final int howManyNumbers, final List<BigInteger> expected) {
      final List<BigInteger> fibs = Fibonacci.fibs(howManyNumbers);
      assertIterableEquals(expected, fibs);
   }
}