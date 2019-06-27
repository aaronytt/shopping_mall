//package com.ytt.shopping.rest;
//
//import com.ytt.shopping.model.Goods;
//import lombok.extern.slf4j.Slf4j;
//import org.joda.money.CurrencyUnit;
//import org.joda.money.Money;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.Banner;
//import org.springframework.boot.WebApplicationType;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.client.RestTemplateBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.ParameterizedTypeReference;
//import org.springframework.http.MediaType;
//import org.springframework.http.RequestEntity;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import java.net.URI;
//import java.util.List;
//
//import static org.springframework.http.HttpMethod.GET;
//
///**
// * @Author: aaron
// * @Descriotion:
// * @Date: 23:47 2019/6/25
// * @Modiflid By:
// */
//@SpringBootApplication
//@Slf4j
//public class RestTemplateApplication implements ApplicationRunner {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    public static void main(String[] args) {
//        new SpringApplicationBuilder()
//                .sources(RestTemplateApplication.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .run(args);
//    }
//
////    @Bean
////    public RestTemplate restTemplate(){
////        return new RestTemplate();
////    }
//
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder){
//        return builder.build();
//    }
//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        URI uri = UriComponentsBuilder
//                .fromUriString("Http://localhost:8080/goods/get/{id}")
//                .build(1);
//        RequestEntity<Void> req = RequestEntity
//                .get(uri)
//                .accept(MediaType.APPLICATION_JSON)
//                .build();
//        ResponseEntity<String> resp = restTemplate.exchange(req,String.class);
//        log.info("Response Status: {}, Response Headers: {}", resp.getStatusCode(),resp.getHeaders());
//        log.info("GoodDTO: {}", resp.getBody());
////
//        String goodUriString = "Http://localhost:8080/goods/add";
//        Goods request = Goods.builder().name("pen").price(Money.of(CurrencyUnit.of("CNY"), 5.02)).build();
//        Goods response = restTemplate.postForObject(goodUriString, request, Goods.class);
//        log.info("New Good: {}", response);
//
//        URI goodUri = UriComponentsBuilder
//                .fromUriString("Http://localhost:8080/goods/get")
//                .build()
//                .toUri();
//        ParameterizedTypeReference<List<Goods>> ptr = new ParameterizedTypeReference<List<Goods>>() {};
//        ResponseEntity<List<Goods>> list = restTemplate.exchange(goodUri, GET, null, ptr);
//        list.getBody()
//                .forEach(goodsDTO ->
//                        log.info("New Good: {}", goodsDTO)
//                );
//    }
//}
