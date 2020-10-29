package com.monkgirl.spring5.pattern.iterator;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 09:33
 * @description
 */
public class IntegerIterator implements Iterator<Integer> {
    private final Integer[] numbers;
    private int index;

    public IntegerIterator(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        return index < numbers.length;
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return numbers[index++];
        }
        return null;
    }
}
