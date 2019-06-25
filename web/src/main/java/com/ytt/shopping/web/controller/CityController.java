package com.ytt.shopping.web.controller;

import com.ytt.shopping.model.dto.CityDTO;
import com.ytt.shopping.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:01 2019/3/8
 * @Modiflid By:
 */
@Controller
@RequestMapping("/map")
@Slf4j
public class CityController {

    @Autowired
    private CityService cityService;

    @ResponseBody
    @RequestMapping(value = "/getCity", method = RequestMethod.GET)
    public CityDTO getCity(CityDTO city){
        city.setId(1);
        CityDTO rc = cityService.getCity(city);
        return rc;
    }

}
