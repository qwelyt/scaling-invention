package com.github.qwelyt.util.factorial;

import java.math.BigInteger;

public final class Factorial {
   public static BigInteger of(final Integer number){
      if(number < 13){
         return BigInteger.valueOf(FactorialSmall.of(number));
      }
      return FactorialBig.of(number);
   }
}
