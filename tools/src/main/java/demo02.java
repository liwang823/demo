import mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import pojo.User;

import java.io.InputStream;
import java.util.List;

public class demo02 {

    public static void main(String[] args) {

        // 获取配置文件，配置文件的路径按照类的路径来看
        String resource = "mybatis-config.xml";
        InputStream is = demo02.class.getResourceAsStream(resource);

        // java和数据库的连接通过SqlSessionFactory来输出，SqlSessionFactory通过SqlSessionFactoryBuilder产生
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);

        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // List<Object> users = sqlSession.selectList("test.selectAll");

        /**
         * 配置文件方式
         *    直接通过SqlSession的查询api获取查询结果
         *
         * Mapper代理方式
         *    通过SqlSession获取Mapper
         *    Mapper通过xml文件的nameSpace映射Mapper的包来实现Mapper接口
         *    返回数据
         */
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);

        sqlSession.close();

    }
}
