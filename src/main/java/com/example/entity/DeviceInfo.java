package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * dj_device_info
 *
 * @mbg.generated
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo implements Serializable {
    /**
     * 主键
     *
     * dj_device_info.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * 设备号
     *
     * dj_device_info.device_id
     *
     * @mbg.generated
     */
    private String deviceId;

    /**
     * 推送id
     *
     * dj_device_info.device_token
     *
     * @mbg.generated
     */
    private String deviceToken;

    /**
     * 用户id
     *
     * dj_device_info.uid
     *
     * @mbg.generated
     */
    private Long uid;

    /**
     * 创建时间
     *
     * dj_device_info.createtm
     *
     * @mbg.generated
     */
    private Long createtm;

    /**
     * 更新时间
     *
     * dj_device_info.updatetm
     *
     * @mbg.generated
     */
    private Long updatetm;

    /**
     * 是否登出
     *
     * dj_device_info.logout
     *
     * @mbg.generated
     */
    private Byte logout;

    /**
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

}