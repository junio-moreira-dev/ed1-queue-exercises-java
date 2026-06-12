package dev.junio.queue.exercises;

import dev.junio.queue.linkedqueue.LinkedQueue;

public class Exer06SplitEvenOdd {

    public static class Result {
        public LinkedQueue<Integer> evenQueue = new LinkedQueue<>();
        public LinkedQueue<Integer> oddQueue = new LinkedQueue<>();
    }

    public static Result splitEvenOdd(LinkedQueue<Integer> originalQueue) {
        Result result = new Result();

        // Retira da original até esvaziar e distribui usando o operador ternário
        while (!originalQueue.isEmpty()) {
            int value = originalQueue.pop();

            if (value % 2 == 0) {
                result.evenQueue.push(value);
            } else {
                result.oddQueue.push(value);
            }
        }

        return result;
    }
}