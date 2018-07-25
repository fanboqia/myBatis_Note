package demo02;

import demo01.user;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class test02 {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectBatch() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<user> users = sqlSession.selectList("test02.findUserByIdBatch", ids.toArray());
        System.out.println(users.get(0).getName());
        System.out.println(users.get(1).getName());
    }

    @Test
    public void findUserCount() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user user = new user();
        user.setName("james");
        user.setPassword("123");
        Integer integer = sqlSession.selectOne("test02.findUserCount", user);
        System.out.println(integer);
    }

    @Test
    public void findUserList() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user user = new user();
        user.setId(1);
        //user.setName("james");
        //user.setPassword("123");
        Map<Integer, user> map = sqlSession.selectOne("test02.findUserList", user);
        System.out.println(map.get("name"));
    }

    @Test
    public void UpdateUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user user = new user();
        user.setId(1);
        user.setName("franklin");
        user.setPassword("123");
        sqlSession.update("test02.updateUserById", user);
        sqlSession.commit();
    }

    @Test
    public void deleteUserByIdBatch() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        sqlSession.delete("test02.deleteUserByIdBatch", ids.toArray());
        sqlSession.commit();
    }
}
