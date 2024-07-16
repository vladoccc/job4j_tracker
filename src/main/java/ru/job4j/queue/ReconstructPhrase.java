package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder first = new StringBuilder();
        int length = evenElements.size();
        for (int i = 0; i < length; i++) {
            if (i % 2 == 0) {
                first.append(evenElements.pollFirst());
                evenElements.pollFirst();
            }
        }
        return first.toString();
    }

    private String getDescendingElements() {
        StringBuilder second = new StringBuilder();
        int length = descendingElements.size();
        for (int i = 0; i < length; i++) {
            second.append(descendingElements.pollLast());
        }
        return second.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
