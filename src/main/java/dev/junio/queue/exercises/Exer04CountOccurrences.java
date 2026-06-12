package dev.junio.queue.exercises;

import dev.junio.queue.linkedqueue.LinkedQueue;

public class Exer04CountOccurrences {

    public static int countOccurrences(LinkedQueue<Integer> queue, int target) {
        LinkedQueue<Integer> auxQueue = new LinkedQueue<>();
        int count = 0;

        // 1. Esvazia a original contando o target e armazenando na auxiliar
        while (!queue.isEmpty()) {
            int current = queue.pop();
            if (current == target) count++;
            auxQueue.push(current);
        }

        // 2. Restaura o estado perfeito da fila original
        while (!auxQueue.isEmpty()) {
            queue.push(auxQueue.pop());
        }

        return count;
    }
}