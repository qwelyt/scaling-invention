package com.github.qwelyt.util.tail.call;

// Convenience class
public final class Calls {
   public static <T> TailCall<T> call(final TailCall<T> next){
      return next;
   }

   public static <T> TailCall<T> done(final T value){
      return new TailCall<T>() {
         @Override public boolean complete() { return true;}
         @Override public T result() { return value; }
         @Override public TailCall<T> apply() { throw new Error("Not implemented"); }
      };
   }
}
