package pattern;

import com.monkgirl.spring5.pattern.factoy.ComputerFactory;
import com.monkgirl.spring5.pattern.factoy.impl.Asus;
import com.monkgirl.spring5.pattern.factoy.impl.Lenovo;
import com.monkgirl.spring5.pattern.factoy.impl.Macbook;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 01:07
 * @description
 */
public class TestFactory {
    public static void main(String...args){
        ComputerFactory factory = new ComputerFactory();
        Asus asus = (Asus) factory.createComputer("asus");
        asus.make();
        Lenovo lenovo = (Lenovo) factory.createComputer("lenovo");
        lenovo.make();
        Macbook macbook = (Macbook) factory.createComputer("macbook");
        macbook.make();
    }
}
