package com.kanika.calculatorJavaAssessment.operators;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class DefaultAdder implements Adder{
    @Override
    public Integer add(List<Integer> numbers) {
        // Throw exception if the list is empty
        if(numbers.isEmpty())
            throw new IllegalStateException();

        // Generalized Method
        /*Integer sum=0;
        for(int i=0; i<numbers.size(); i++)
            sum+=numbers.get(i);

        return sum;*/

        // Using Lambdas
        /*AtomicReference<Integer> sum = new AtomicReference<>(0);
        numbers.forEach(i -> sum.updateAndGet(v -> v + i));

        return sum.get();*/

        // Using Stream
        //return numbers.stream().reduce(0, (sum,i)->sum+i);

        // Using Collectors.summingInt
        return numbers.stream().collect(Collectors.summingInt(p -> p));

    }
}
