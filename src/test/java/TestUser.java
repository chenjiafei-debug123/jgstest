import cn.kgc.chen.bean.User;
import cn.kgc.chen.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class TestUser {

    SqlSession sqlSession = null;

    @Before
    public void before(){
        InputStream inputStream = TestUser.class.getClassLoader().getResourceAsStream("config/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void test(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getAll();
        for(User l : list){
            System.out.println(l);
        }
    }
    @Test
    public void test1(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.getAllByUserName("李");
        for(User l : list){
            System.out.println(l);
        }
    }
    @Test
    public void test2(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserCode("admin");
        user.setUserName("帅哥");
        user.setUserPassword("123");
        user.setGender(1);
        user.setBirthday(new Date());
        user.setPhone("12345678910");
        user.setAddress("北京");
        user.setUserRole(1);
        user.setCreatedBy(1);
        user.setCreationDate(new Date());
        user.setModifyBy(1);
        user.setModifyDate(new Date());
        userMapper.add(user);
        sqlSession.commit();
    }
    @Test
    public void test3(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUserCode("admin2");
        user.setUserName("帅哥2");
        user.setUserPassword("123");
        user.setGender(2);
        user.setBirthday(new Date());
        user.setPhone("12345678910");
        user.setAddress("北京2");
        user.setUserRole(2);
        user.setCreatedBy(2);
        user.setCreationDate(new Date());
        user.setModifyBy(2);
        user.setModifyDate(new Date());
        user.setId(18);
        userMapper.update(user);
        sqlSession.commit();
    }
    @Test
    public void test4(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.delete(18);
        sqlSession.commit();
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
