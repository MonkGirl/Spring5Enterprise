package pattern;

import com.monkgirl.spring5.pattern.abstractfactory.*;
import com.monkgirl.spring5.pattern.abstractfactory.impl.Rmb;
import com.monkgirl.spring5.pattern.factoy.impl.Lenovo;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:26
 * @description
 */
public class TestAbstractFactory {
    public static void main(String...args){
        ComputerFactory computerFactory = (ComputerFactory) FactoryProducer.getFactory("computer");
        Lenovo lenovo = (Lenovo) computerFactory.createComputer("lenovo");
        lenovo.make();

        PriceFactory priceFactory = (PriceFactory) FactoryProducer.getFactory("price");
        Rmb rmb = (Rmb) priceFactory.createPrice("rmb");
        rmb.setPrice();
    }
}
