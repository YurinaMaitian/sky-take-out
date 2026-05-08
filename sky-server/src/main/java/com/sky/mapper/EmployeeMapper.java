package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface EmployeeMapper {



    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    // username 必须和下面的 username 名字相同，这是利用了反射机制，否则会报错
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, " +
        "create_time, create_user, update_time, " +
        "update_user, status) " +
        "values (#{name}, #{username}, #{password}, #{phone}, " +
        "#{sex}, #{idNumber}, #{createTime}, #{createUser}, #{updateTime}, #{updateUser}, #{status})")
    void insert(Employee employee);

    /**
     * 分页查询
     * @param employeePageQueryDTO
     * @return
     */
    Page<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);
}
