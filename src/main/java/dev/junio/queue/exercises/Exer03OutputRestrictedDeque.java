package dev.junio.queue.exercises;

import dev.junio.queue.arrayqueue.ArrayQueue;

/**
 * Questão 3: Fila com Saída Dupla (Output-Restricted Deque)
 * Aplica o conceito de HERANÇA para reaproveitamento total da infraestrutura.
 */
public class Exer03OutputRestrictedDeque extends ArrayQueue<Integer> {

    public Exer03OutputRestrictedDeque(int capacity) {

        super(capacity); // Invoca o construtor de ArrayQueue
    }

    /**
     * Remove e retorna o elemento que está exatamente no final da fila (items[count-1]).
     */
    public Integer popBack() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }

        // Como items e count são protected na classe pai, podemos acessá-los diretamente
        int lastIndex = count - 1;

        @SuppressWarnings("unchecked")
        Integer removedElement = (Integer) items[lastIndex];

        items[lastIndex] = null; // Evita memory leak (limpa a lacuna)
        count--;                 // Ajusta o controle de tamanho da fila

        return removedElement;
    }
}