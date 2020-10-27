package com.monkgirl.spring5.pattern.abstractfactory;

import com.monkgirl.spring5.pattern.abstractfactory.impl.Dollar;
import com.monkgirl.spring5.pattern.abstractfactory.impl.Pound;
import com.monkgirl.spring5.pattern.abstractfactory.impl.Rmb;
import org.apache.commons.lang.StringUtils;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-23 14:21
 * @description
 */
public class PriceFactory implements AbstractFactory {

    @Override
    public Price createPrice(String currency) {
        if (StringUtils.isNotBlank(currency)) {
            switch (currency.toLowerCase()) {
                case "rmb":
                    return new Rmb();
                case "dollar":
                    return new Dollar();
                case "pound":
                    return new Pound();
                default:
                    return null;
            }
        } else {
            return null;
        }
    }
}
