package com.github.qwelyt.util.factorial;

import com.github.qwelyt.util.tail.call.TailCall;

import static com.github.qwelyt.util.tail.call.Calls.call;
import static com.github.qwelyt.util.tail.call.Calls.done;

public final class FactorialSmall {
   public static Integer of(final int number){
      return of(1, number).invoke();
   }

   private static TailCall<Integer> of(final int factorial, final int number){
      if(number == 1){
         return done(factorial);
      }
      return call(() -> of(factorial * number, number -1));
   }
}
