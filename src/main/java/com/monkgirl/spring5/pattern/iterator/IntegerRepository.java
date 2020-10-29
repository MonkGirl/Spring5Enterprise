package com.monkgirl.spring5.pattern.iterator;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-28 09:40
 * @description
 */
public class IntegerRepository implements Container {
    private final Integer[] numbers;

    public IntegerRepository(Integer[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> getIterator() {
        return new IntegerIterator(numbers);
    }
}
