package com.dy.framework.mybatis.mapper;

import com.dy.framework.mybatis.model.TPermission;
import com.dy.framework.mybatis.model.TPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int countByExample(TPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int deleteByExample(TPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int insert(TPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int insertSelective(TPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    List<TPermission> selectByExample(TPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    TPermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int updateByExampleSelective(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int updateByExample(@Param("record") TPermission record, @Param("example") TPermissionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int updateByPrimaryKeySelective(TPermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_permission
     *
     * @mbggenerated Fri Apr 29 16:48:01 CST 2016
     */
    int updateByPrimaryKey(TPermission record);
}