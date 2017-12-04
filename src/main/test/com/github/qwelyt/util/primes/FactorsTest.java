package com.github.qwelyt.util.primes;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class FactorsTest {

   @Test
   public void factorsOf4() {
      asserter(4, Arrays.asList(2, 2));
   }

   @Test
   public void factorsOf16() {
      asserter(16, Arrays.asList(2, 2, 2, 2));
   }

   @Test
   public void factorsOf27() {
      asserter(27, Arrays.asList(3, 3, 3));
   }

   @Test
   public void factorsOf864() {
      asserter(864, Arrays.asList(2, 2, 2, 2, 2, 3, 3, 3));
   }

   private void asserter(final int number, final List<Integer> expected) {
      final List<Integer> result = Factors.of(number);
      assertIterableEquals(expected, result);
   }
}