package com.ytt.shopping.service.impl;

import com.ytt.shopping.model.dto.CityDTO;
import com.ytt.shopping.model.po.CityPO;
import com.ytt.shopping.mybatis.mapper.CityMapper;
import com.ytt.shopping.service.CityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: aaron
 * @Descriotion:
 * @Date: 19:07 2019/3/8
 * @Modiflid By:
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public CityDTO getCity(CityDTO city) {
        if(!Optional.ofNullable(city).isPresent()){
            city = new CityDTO();
        }
        CityPO cityPO = cityMapper.findById(city.getId());
        CityDTO result = new CityDTO();
        BeanUtils.copyProperties(cityPO,result);
        return result;
    }
}
