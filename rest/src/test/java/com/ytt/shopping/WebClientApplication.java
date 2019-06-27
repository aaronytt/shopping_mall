package com.ytt.shopping;

import com.ytt.shopping.model.Goods;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 13:21 2019/6/27
 * @Modiflid By:
 */
@SpringBootApplication
@Slf4j
public class WebClientApplication implements ApplicationRunner {

    @Autowired
    private WebClient webClient;

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(WebClientApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.NONE)
                .run(args);
    }

    @Bean
    public WebClient webClient(WebClient.Builder builder){
        return builder.baseUrl("http://localhost:8080").build();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        CountDownLatch latch = new CountDownLatch(2);

        webClient.get()
                .uri("/goods/get/{id}",2)
                .retrieve()
                .bodyToMono(Goods.class)
                .doOnError(t -> log.error("Error: ",t))
                .doFinally(s -> latch.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(g -> log.info("Goods: {}",g));

        Mono<Goods> americano = Mono.just(
                Goods.builder()
                        .name("books")
                        .price(Money.of(CurrencyUnit.of("CNY"),4.99))
                        .build()
        );

        webClient.post()
                .uri("/goods/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(americano,Goods.class)
                .retrieve()
                .bodyToMono(Goods.class)
                .doOnError(t -> log.error("Error: ",t))
                .doFinally(s -> latch.countDown())
                .subscribeOn(Schedulers.single())
                .subscribe(g -> log.info("Goods Create: {}",g));

        latch.await();

        webClient.get()
                .uri("/goods/get")
                .retrieve()
                .bodyToFlux(Goods.class)
                .toStream()
                .forEach(g -> log.info("Goods in List: {}",g));
    }
}
