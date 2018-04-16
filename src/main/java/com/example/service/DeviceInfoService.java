package com.example.service;

import com.example.mapper.DeviceInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yulewei on 2018/4/4
 */
@Service
public class DeviceInfoService {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

}
