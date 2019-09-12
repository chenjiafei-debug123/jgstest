package cn.kgc.chen.mapper;

import cn.kgc.chen.bean.User;

import java.util.List;

public interface UserMapper {

    //查询全部
    public List<User> getAll();
    //模糊查询
    public List<User> getAllByUserName(String userName);
    //增加
    public void add(User user);
    //修改
    public void update(User user);
    //删除
    public void delete(Integer id);
}
