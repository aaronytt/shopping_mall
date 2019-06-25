package com.ytt.shopping.web.controller;

import com.ytt.shopping.model.dto.GoodsDTO;
import com.ytt.shopping.service.GoodsService;
import com.ytt.shopping.web.controller.request.GoodsRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.SPACE;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.*;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 10:59 2019/6/20
 * @Modiflid By:
 */
@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @PostMapping(path = "/add", consumes = APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    @ResponseStatus(CREATED)
    public GoodsDTO addGoodsWithoutBindingResult(@Valid GoodsRequest goods){
        return goodsService.saveGoods(goods.getName(),goods.getPrice());
    }

    @PostMapping(path = "/add", consumes = APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ResponseStatus(CREATED)
    public GoodsDTO addJsonGoodsWithoutBindingResult(@Valid @RequestBody GoodsRequest goods){
        return goodsService.saveGoods(goods.getName(),goods.getPrice());
    }

    @PostMapping(path = "/batchAdd", consumes = MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    @ResponseStatus(CREATED)
    public List<GoodsDTO> batchAddGoods(@RequestParam("file")MultipartFile file){
        List<GoodsDTO> goods = new ArrayList<>();
        if(!file.isEmpty()){
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
                String str;
                while ((str = reader.readLine()) != null){
                    String[] arr = StringUtils.split(str, SPACE);
                    if(null != arr && arr.length == 2){
                       goods.add(goodsService.saveGoods(arr[0], Money.of(CurrencyUnit.of("CNY"), NumberUtils.createBigDecimal(arr[1]))));
                    }
                }
            } catch (IOException e) {
                log.error("exception",e);
            } finally {
                IOUtils.closeQuietly(reader);
            }
        }
        return goods;
    }

    @GetMapping(path = "/get/{id}")
    @ResponseBody
    @ResponseStatus(OK)
    public GoodsDTO getById(@PathVariable long id){
        return goodsService.getById(id);
    }

}
