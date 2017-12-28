/**
 * 
 */
package com.huawei.apw.demo.batch.orm;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.huawei.apw.demo.batch.beans.Person;

/**
 * @author Liquid
 *
 */
@Mapper
public interface PersonMapper {
	
	@Select("SELECT * FROM People")
	@Results({
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name")
    })
	List<Person> findAll();
	
	@Select("SELECT * FROM People where first_name = #{firstName} limit #{_pagesize} offset #{_skiprows} ")
	@Results({
        @Result(property = "firstName", column = "first_name"),
        @Result(property = "lastName", column = "last_name")
    })
	List<Person> findAllPaged(int _skiprows, int _pagesize, String firstName);
	

//	@Select("SELECT * FROM People limit #{_skiprows}, #{_pagesize}")
//	@Results({
//        @Result(property = "firstName",  column = "first_name"),
//        @Result(property = "lastName", column = "last_name")
//    })
//	List<Person> findAllPaged();
	
	@Insert("INSERT INTO People (first_name, last_name) VALUES (#{firstName}, #{lastName})")
	int addPersonItem(Person person);
	
}
