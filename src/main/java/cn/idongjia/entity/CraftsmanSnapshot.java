package cn.idongjia.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 匠人快照表
 * 
 * craftsman_snapshot
 *
 * @mbg.generated
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CraftsmanSnapshot implements Serializable {
    /**
     * 主键
     *
     * craftsman_snapshot.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     * 操作人员ID
     *
     * craftsman_snapshot.admin_id
     *
     * @mbg.generated
     */
    private Integer adminId;

    /**
     * 匠人ID
     *
     * craftsman_snapshot.craftsman_id
     *
     * @mbg.generated
     */
    private Integer craftsmanId;

    /**
     * 客户ID
     *
     * craftsman_snapshot.customer_id
     *
     * @mbg.generated
     */
    private Integer customerId;

    /**
     * 快照URL
     *
     * craftsman_snapshot.url
     *
     * @mbg.generated
     */
    private String url;

    /**
     * 创建时间
     *
     * craftsman_snapshot.create_time
     *
     * @mbg.generated
     */
    private Long createTime;

    /**
     * 更新时间
     *
     * craftsman_snapshot.update_time
     *
     * @mbg.generated
     */
    private Long updateTime;

    /**
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;
}