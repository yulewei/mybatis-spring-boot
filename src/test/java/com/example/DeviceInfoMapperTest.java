package com.example;

import com.example.entity.DeviceInfo;
import com.example.entity.criteria.DeviceInfoExample;
import com.example.mapper.DeviceInfoMapper;
import com.github.pagehelper.PageHelper;
import one.util.streamex.StreamEx;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yulewei on 2018/4/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DeviceInfoMapperTest {

    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    @Test
    public void deviceStat() {
        DeviceInfoExample example = new DeviceInfoExample();
        example.createCriteria().andUidNotEqualTo(0L).andDeviceTokenNotEqualTo("");
        example.setOrderByClause("uid");
        long total = deviceInfoMapper.countByExample(example);
        int pageSize = 10000;
        long pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));

        Set<DeviceInfo> listUni = new HashSet<>();
        for (int page = 1; page <= pages; page++) {
            PageHelper.startPage(page, pageSize, false);
            List<DeviceInfo> list = deviceInfoMapper.selectByExample(example);
            Map<Long, List<DeviceInfo>> uidMap = StreamEx.of(list).groupingBy(DeviceInfo::getUid);
            for (Long uid : uidMap.keySet()) {
                List<DeviceInfo> deviceInfoList = uidMap.get(uid);
                DeviceInfo deviceInfo = null;
                if (deviceInfoList.size() == 1) {
                    deviceInfo = deviceInfoList.get(0);
                } else {
                    Collections.sort(deviceInfoList, new BeanComparator<DeviceInfo>("createtm", Comparator.reverseOrder()));
                    deviceInfo = deviceInfoList.get(0);
                }
                if (StringUtils.isNotBlank(deviceInfo.getDeviceToken())) {
                    listUni.add(deviceInfo);
                }
            }
        }

        int iOSDefaultCount = 0;
        int iOSDfbbCount = 0;
        int umengCount = 0;
        int xiaomiCount = 0;
        int huaweiCount = 0;
        int jiguangCount = 0;
        for (DeviceInfo deviceInfo : listUni) {
            if (StringUtils.isBlank(deviceInfo.getDeviceToken()))
                continue;
            if (deviceInfo.getDeviceToken().contains("cc.kaipao.dongjia:")) {
                iOSDefaultCount++;
            }
            if (deviceInfo.getDeviceToken().contains("cc.kaipaoClone.dongjia:") || deviceInfo.getDeviceToken()
                    .contains("cc.kaipaoCloneS.dongjia:")) {
                iOSDfbbCount++;
            }
            if (deviceInfo.getDeviceToken().contains("umeng")) {
                umengCount++;
            }
            if (deviceInfo.getDeviceToken().contains("huawei")) {
                huaweiCount++;
            }
            if (deviceInfo.getDeviceToken().contains("xiaomi")) {
                xiaomiCount++;
            }
            if (deviceInfo.getDeviceToken().contains("jiguang")) {
                jiguangCount++;
            }
        }
        System.out.println("umengCount: " + umengCount + " / " + listUni.size());
        System.out.println("huaweiCount: " + huaweiCount + " / " + listUni.size());
        System.out.println("xiaomiCount: " + xiaomiCount + " / " + listUni.size());
        System.out.println("jiguangCount: " + jiguangCount + " / " + listUni.size());
        System.out.println("ios: " + (iOSDefaultCount + iOSDfbbCount) + " / " + listUni.size());
    }

    @Test
    public void name() {
        DeviceInfoExample example = new DeviceInfoExample();
        example.createCriteria().andUidNotEqualTo(0L).andDeviceTokenNotEqualTo("");
        example.setOrderByClause("uid");
        long total = deviceInfoMapper.countByExample(example);
        int pageSize = 10000;
        long pages = (int) (total / pageSize + ((total % pageSize == 0) ? 0 : 1));

        for (int page = 1; page <= pages; page++) {
            PageHelper.startPage(page, pageSize, false);
            List<DeviceInfo> list = deviceInfoMapper.selectByExample(example);
            Map<Long, List<DeviceInfo>> uidMap = StreamEx.of(list).groupingBy(DeviceInfo::getUid);
            for (Long uid : uidMap.keySet()) {
                List<DeviceInfo> deviceInfoList = uidMap.get(uid);
                boolean find = false;
                for (int i = 1; i < deviceInfoList.size(); i++) {
                    DeviceInfo deviceInfo0 = deviceInfoList.get(i - 1);
                    DeviceInfo deviceInfo1 = deviceInfoList.get(i);
                    if (deviceInfo0.getDeviceToken().equals(deviceInfo1.getDeviceToken())) {
                        find = true;
                    }
                }
                if(find){
                    System.out.println(deviceInfoList);
                }
            }
        }
    }
}
