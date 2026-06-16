package dev.junio.queue.exercises;

import dev.junio.queue.Queue;
import dev.junio.stack.Stack;
import dev.junio.stack.arraystack.ArrayStack;

/**
 * Questão 2: Fila Utilizando Duas Pilhas (Simulação FIFO usando LIFO)
 * Aplica o conceito de COMPOSIÇÃO.
 */
public class Exer02StackBasedQueue implements Queue<Integer> {

    // Duas instâncias de Stack como variáveis de instância (padrão solicitado)
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public Exer02StackBasedQueue() {
        // Instanciação utilizando a classe concreta disponível no seu projeto
        this.stack1 = new ArrayStack<>(100);
        this.stack2 = new ArrayStack<>(100);
    }

    @Override
    public void push(Integer x) {
        // Inserções sempre vão direto para a stack1
        stack1.push(x);
    }

    @Override
    public Integer pop() {
        shiftStacks();
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return stack2.pop();
    }

    @Override
    public Integer peek() {
        shiftStacks();
        if (stack2.isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        return stack2.peek();
    }

    @Override
    public Integer back() {
        if (isEmpty()) {
            throw new IllegalStateException("Fila vazia");
        }
        // Se a stack1 não está vazia, o último elemento inserido está no topo dela
        if (!stack1.isEmpty()) {
            return stack1.peek();
        }

        // Caso contrário, o elemento está no fundo da stack2.
        // Usamos uma pilha temporária para não perder os dados.
        Stack<Integer> temp = new ArrayStack<>(stack2.size());
        while (!stack2.isEmpty()) {
            temp.push(stack2.pop());
        }
        Integer bottom = temp.peek();
        while (!temp.isEmpty()) {
            stack2.push(temp.pop());
        }
        return bottom;
    }

    @Override
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public int size() {
        return stack1.size() + stack2.size();
    }

    @Override
    public void clear() {
        stack1.clear();
        stack2.clear();
    }

    @Override
    public void display() {
        System.out.println("Fila baseada em pilhas. Total de elementos: " + size());
    }

    /**
     * Metodo auxiliar interno para transferir elementos da stack1 para a stack2
     * invertendo a ordem (transformando a lógica LIFO em FIFO).
     */
    private void shiftStacks() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }
}