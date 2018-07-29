package demo03;

import demo03.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test03 {
    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void findUserOrderById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<OrderUser> orderUsers = sqlSession.selectList("test03.findUserOrderById", 2);
        for (int i = 0; i < orderUsers.size(); i++) {
            System.out.println(orderUsers.get(i));
        }
    }

    @Test
    public void findUserItemsById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> orderUsers = sqlSession.selectList("test03.findUserItemsById", 2);
        for (int i = 0; i < orderUsers.size(); i++) {
            System.out.println(orderUsers.get(i));
        }
    }

    @Test
    public void findOrderDetailById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Order> orderUsers = sqlSession.selectList("test03.findOrderDetailById", 2);

/*        for(int i = 0; i < orderUsers.size(); i++){
            Order order = orderUsers.get(i);
            System.out.println("{OrderId: " + order.getOrderId());
            System.out.println("CreateTime: " + order.getCreatetime());
            User user = order.getUser();
            System.out.println("UserName: " + user.getName());
            System.out.println("UseAddress: " + user.getAddress());
            List<OrderDetail> orderDetails = order.getDetails();
            for(int j = 0; j < orderDetails.size(); j++){
                OrderDetail orderDetail =  orderDetails.get(j);
                System.out.println("OrderId:" + orderDetail.getOrdersId());
                Items items = orderDetails.get(j).getItems();
                System.out.println("Name: " + items.getName());
            }
            System.out.println("}");
        }*/

        for (int i = 0; i < orderUsers.size(); i++) {
            System.out.println(orderUsers.get(i));
        }
    }
}
