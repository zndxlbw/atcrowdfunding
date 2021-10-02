package com.atguigu.crowd.test;

import com.atguigu.crowd.entity.Admin;
import com.atguigu.crowd.entity.Role;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.mapper.RoleMapper;
import com.atguigu.crowd.service.api.AdminService;
import com.atguigu.crowd.service.api.RoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

//在类上标记必要的注解，Spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-persist-mybatis.xml","classpath:spring-persist-tx.xml"})
public class CorwdTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private RoleService roleService;


    @Test
    public void test(){
        for (int i = 0;i<238;i++){
            adminMapper.insert(new Admin(null,"loginAcct"+i,"userPswd"+i,"userName"+i,"email"+i,null));
        }
    }

    @Test
    public void addRoleInfo(){
        for (int i = 0;i<235;i++){
            roleMapper.insert(new Role(null,"role"+i));
        }
    }

    @Test
    public void testTX(){
        Admin admin = new Admin(null,"Jerry","123456","杰瑞","herry@qq.com",null);
        adminService.saveAdmin(admin);

    }

    /**
     * 使用Logback的方式打印日志
     */
    @Test
    public void testLog(){
        //获取Logger对象，获取日志记录器对象
        //这里传入的反射的class对象，就是当前打印日志这个类
        Logger logger = LoggerFactory.getLogger(CorwdTest.class);

        //根据不同的日志级别来打印日志
        logger.debug("Hello, I am debug level!!!");
        logger.debug("Hello, I am debug level!!!");
        logger.debug("Hello, I am debug level!!!");

        logger.info("Hello, I am info level!!!");
        logger.info("Hello, I am info level!!!");
        logger.info("Hello, I am info level!!!");

        logger.warn("Hello, I am warn level!!!");
        logger.warn("Hello, I am warn level!!!");
        logger.warn("Hello, I am warn level!!!");

        logger.error("Hello, I am error level!!!");
        logger.error("Hello, I am error level!!!");
        logger.error("Hello, I am error level!!!");

    }

    @Test
    public void testAdminMapper(){
        Admin admin = new Admin(null,"Mark","123123","马克","mark@qq.com",null);
        int count = adminMapper.insert(admin);
        System.out.println("受影响的行数:"+count);
    }

    @Test
    public void testConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }




}
