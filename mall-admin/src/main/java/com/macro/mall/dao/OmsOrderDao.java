package com.macro.mall.dao;

import com.macro.mall.dto.OmsOrderDeliveryParam;
import com.macro.mall.dto.OmsOrderDetail;
import com.macro.mall.dto.OmsOrderQueryParam;
import com.macro.mall.model.OmsOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Order query custom Dao
 * Created by macro on 2018/10/12.
 */
public interface OmsOrderDao {
    /**
     * Conditional order query
     */
    List<OmsOrder> getList(@Param("queryParam") OmsOrderQueryParam queryParam);

    /**
     * Batch delivery
     */
    int delivery(@Param("list") List<OmsOrderDeliveryParam> deliveryParamList);

    /**
     * Get order detail
     */
    OmsOrderDetail getDetail(@Param("id") Long id);
}
