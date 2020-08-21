package com.monkgirl.spring5.entities;

import com.monkgirl.spring5.annotation.Run;
import org.springframework.stereotype.Component;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-08-21 15:55
 * @description
 */
@Run
@Component
public class HuaweiPhoneFactory extends PhoneFactory{
    public void huawei(){
        System.out.println("This is Huawei.");
    }
}
