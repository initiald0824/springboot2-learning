package com.spark.springboot2learning.chap5.typehandler;

import com.spark.springboot2learning.chap5.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author initiald0824
 * @date 2019/8/5 19:22
 */
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {

    /**
     * 设置非空性别参数
     * @param preparedStatement
     * @param i
     * @param sexEnum
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getId());
    }

    /**
     * 通过列名读取性别
     * @param resultSet
     * @param s
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int sex = resultSet.getInt(s);
        if (sex != SexEnum.MALE.getId() && sex != SexEnum.FEMALE.getId()) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    /**
     * 通过存储过程获取性别
     * @param resultSet
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int sex = resultSet.getInt(i);
        if (sex != SexEnum.MALE.getId() && sex != SexEnum.FEMALE.getId()) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }

    /**
     * 通过下标读取性别
     * @param callableStatement
     * @param i
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int sex = callableStatement.getInt(i);
        if (sex != SexEnum.MALE.getId() && sex != SexEnum.FEMALE.getId()) {
            return null;
        }
        return SexEnum.getEnumById(sex);
    }
}
