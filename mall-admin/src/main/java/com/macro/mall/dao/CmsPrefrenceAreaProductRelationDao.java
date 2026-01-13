package com.macro.mall.dao;

import com.macro.mall.model.CmsPrefrenceAreaProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Preferred area and product relation custom Dao
 * Created by macro on 2018/4/26.
 */
public interface CmsPrefrenceAreaProductRelationDao {
    /**
     * Batch insert
     */
    int insertList(@Param("list") List<CmsPrefrenceAreaProductRelation> prefrenceAreaProductRelationList);
}
