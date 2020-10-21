package chapter18;

import com.alibaba.fastjson.JSON;
import com.monkgirl.spring5.chapter18.entities.ShopInfo;
import com.monkgirl.spring5.chapter18.service.ShopInfoService;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author MissYoung
 * @version 0.1
 * @date 2020-10-20 15:57
 * @description
 */
@SpringJUnitConfig(locations = "classpath:spring/spring-mvc.xml")
public class ShopInfoTest {
    private ShopInfoService shopInfoService;
    private static Long shopId = 0L;

    @Autowired
    public void setShopInfoService(ShopInfoService shopInfoService) {
        this.shopInfoService = shopInfoService;
    }

    @Test
    void saveShop() {
        for (int i = 0; i < 10; i++) {
            ShopInfo shopInfo = new ShopInfo();
            shopInfo.setShopId(shopId++);
            shopInfo.setShopName("name" + i);
            shopInfo.setAccount("Account" + i);
            shopInfoService.saveShop(shopInfo);
        }
    }

    @Test
    void saveShop2() {
        try (HintManager hintManager = HintManager.getInstance()) {
            for (int i = 10; i < 20; i++) {

                ShopInfo shopInfo = new ShopInfo();
                //shopInfo.setShopId((long) i);
                shopInfo.setShopName("name" + i);
                shopInfo.setAccount("Account" + i);
                if (i == 15L) {
                    hintManager.addDatabaseShardingValue("shop_info", 2);
                    hintManager.addTableShardingValue("shop_info", 6);
                }
                //shopInfoService.saveShop(shopInfo);
                shopInfoService.saveShopAutoIncrement(shopInfo);
            }
        }
    }

    @Test
    void queryShop() {
        ShopInfo shopInfo = shopInfoService.queryShop(2L);
        System.out.printf("商品信息是=%s%n", JSON.toJSONString(shopInfo));
    }
}
