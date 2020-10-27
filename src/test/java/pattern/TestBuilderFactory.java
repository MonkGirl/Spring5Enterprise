package pattern;

import com.monkgirl.spring5.pattern.builder.Computer;
import com.monkgirl.spring5.pattern.builder.ComputerBuilder;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 17:02
 * @description
 */
public class TestBuilderFactory {
    public static void main(String...args){
        ComputerBuilder computerBuilder = new ComputerBuilder();
        Computer cheapComputer = computerBuilder.buildCheap();
        cheapComputer.showItem();

        Computer expensiveComputer = computerBuilder.buildExpensive();
        expensiveComputer.showItem();
    }
}
