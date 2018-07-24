package demo01;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class test01 {

    @Test
    public void findUserById() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user user = sqlSession.selectOne("test.findUserById", 1);
        System.out.println(user.getName());
        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user usr = new user("james", "123");
        sqlSession.insert("test.insertUser", usr);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        user user = sqlSession.selectOne("test.findUserById", 1);
        user.setPassword("123456");
        sqlSession.update("test.updateUser", user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("test.deleteUserById", 2);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void main(String[] args) throws IOException {
        //new test01().findUserById();
        //new test01().insertUser();
        //new test01().updateUser();
        // new test01().deleteUser();
    }
}
