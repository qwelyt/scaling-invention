package com.github.qwelyt.util.tail.call;

import java.util.stream.Stream;

@FunctionalInterface
public interface TailCall<T> {
   TailCall<T> apply();

   default boolean complete() {
      return false;
   }

   default T result() {
      throw new Error("Not implementer");
   }

   default T invoke(){
      return Stream.iterate(this, TailCall::apply)
            .filter(TailCall::complete)
            .findFirst()
            .get()
            .result();
   }
}
