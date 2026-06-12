package dev.junio.queue.exercises;

import dev.junio.queue.arrayqueue.ArrayQueue;

/**
 * Questão 1: Deslocamento Imediato no Desenfileirar
 * Herda de ArrayQueue para reaproveitar a estrutura do vetor.
 */
public class Exer01ShiftPop extends ArrayQueue<Integer> {

    public Exer01ShiftPop(int capacity) {
        super(capacity);
    }

    @Override
    public Integer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        // 1. Guarda o elemento do início (índice 0)
        @SuppressWarnings("unchecked")
        Integer removedElement = (Integer) items[0];

        // 2. Desloca todos os elementos restantes uma posição para a esquerda
        for (int i = 1; i < count; i++) {
            items[i - 1] = items[i];
        }

        // 3. Ajusta o contador e limpa a última posição para o Garbage Collector
        count--;
        items[count] = null;

        return removedElement;
    }
}