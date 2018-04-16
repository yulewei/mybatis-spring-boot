package com.example.mapper;

import com.example.entity.DeviceInfo;
import com.example.entity.criteria.DeviceInfoExample;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceInfoMapper extends BaseMapper<DeviceInfo, DeviceInfoExample> {
}