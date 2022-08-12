package com.example.dao.impl;

import com.example.ConnectDatabase;
import com.example.dao.GenericDAO;
import com.example.mapper.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        List<T> results = new ArrayList<>();
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        Connection connection = ConnectDatabase.getConnection();
        if(connection != null){
            try {
                statement = connection.prepareStatement(sql);
                setParameter(statement,parameters);
                resultSet = statement.executeQuery();
                while (resultSet.next()){
                    results.add(rowMapper.mapRow(resultSet));
                }
                return results;
            } catch (SQLException e) {
                return null;
            }
            finally {
                try{
                    connection.close();
                    if(statement!=null){
                        statement.close();
                    }
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (SQLException e){
                    return null;
                }
            }
        }
        return null;
    }

    private void setParameter(PreparedStatement statement, Object[] parameters) {
        try{
            for (int i = 0; i < parameters.length; i++) {
                Object param = parameters[i];
                int index = i+1;
                if(param instanceof Long){
                    statement.setLong(index,(Long)param);
                } else if (param instanceof Integer) {
                    statement.setInt(index,(Integer) param);
                } else if (param instanceof String) {
                    statement.setString(index,(String) param);
                } else if (param instanceof Float) {
                    statement.setFloat(index,(Float)param);
                } else if (param instanceof Date) {
                    statement.setDate(index, (Date) param);
                }else if(param instanceof Timestamp){
                    statement.setTimestamp(index,(Timestamp) param);
                } else if (param instanceof Time) {
                    statement.setTime(index,(Time) param);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Long insert(String sql, Object... parameters) {
        PreparedStatement statement= null;
        ResultSet resultSet = null;
        Connection connection = ConnectDatabase.getConnection();
        Long id = null;
        if(connection != null){
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
                setParameter(statement,parameters);
                statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                if(resultSet.next()){
                    id = resultSet.getLong(1);
                }
                connection.commit();
                return id;
            } catch (SQLException e) {
                return null;
            }
            finally {
                try{
                    connection.close();
                    if(statement!=null){
                        statement.close();
                    }
                    if(resultSet!=null){
                        resultSet.close();
                    }
                }catch (SQLException e){
                    return null;
                }
            }
        }
        return null;
    }
}
