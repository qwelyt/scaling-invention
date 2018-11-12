package com.github.qwelyt.util.factorial;

import com.github.qwelyt.util.tail.call.TailCall;

import java.math.BigInteger;

import static com.github.qwelyt.util.tail.call.Calls.call;
import static com.github.qwelyt.util.tail.call.Calls.done;

public final class FactorialBig {
   public static BigInteger of(final BigInteger number){
      return of(BigInteger.ONE, number).invoke();
   }

   public static BigInteger of(final int number){
      return of(BigInteger.ONE, BigInteger.valueOf(number)).invoke();
   }

   private static TailCall<BigInteger> of(final BigInteger factorial, final BigInteger number){
      if(BigInteger.ZERO.compareTo(number) > 0 || BigInteger.ONE.equals(number)){
         return done(factorial);
      }
      return call(() -> of(multiply(factorial, number), decrement(number)));
   }


   private static BigInteger decrement(final BigInteger number){
      return number.subtract(BigInteger.ONE);
   }

   private static BigInteger multiply(final BigInteger a, final BigInteger b){
      return a.multiply(b);
   }
}
