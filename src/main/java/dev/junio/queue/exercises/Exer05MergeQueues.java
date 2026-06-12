package dev.junio.queue.exercises;

import dev.junio.queue.linkedqueue.LinkedQueue;

public class Exer05MergeQueues {

    // Ajustado o retorno para LinkedQueue<Integer>
    public static LinkedQueue<Integer> mergeTwoQueues(LinkedQueue<Integer> q1, LinkedQueue<Integer> q2) {
        // Nome alterado de auxQueue para result para bater com o restante do código
        LinkedQueue<Integer> result = new LinkedQueue<>();

        // Enquanto ambas as filas tiverem elementos, compara os inícios
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Como precisamos espiar para decidir qual remover, usamos peek()
            if (q1.peek() <= q2.peek()) {
                result.push(q1.pop());
            } else {
                result.push(q2.pop());
            }
        }

        // Se sobraram elementos em q1, joga tudo no final de result
        while (!q1.isEmpty()) {
            result.push(q1.pop());
        }

        // Se sobraram elementos em q2, joga tudo no final de result
        while (!q2.isEmpty()) {
            result.push(q2.pop());
        }

        return result;
    }
}