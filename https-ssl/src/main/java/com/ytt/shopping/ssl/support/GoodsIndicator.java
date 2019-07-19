//package com.ytt.shopping.ssl.support;
//
//import com.ytt.shopping.service.GoodsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.actuate.health.Health;
//import org.springframework.boot.actuate.health.HealthIndicator;
//import org.springframework.stereotype.Component;
//
//@Component
//public class GoodsIndicator implements HealthIndicator {
//    @Autowired
//    private GoodsService goodsService;
//
//    @Override
//    public Health health() {
//        long count = goodsService.getGoodsCount();
//        Health health;
//        if (count > 0) {
//            health = Health.up()
//                    .withDetail("count", count)
//                    .withDetail("message", "We have enough coffee.")
//                    .build();
//        } else {
//            health = Health.down()
//                    .withDetail("count", 0)
//                    .withDetail("message", "We are out of coffee.")
//                    .build();
//        }
//        return health;
//    }
//}
