package com.luluya.designPatterns.controller.proxy;

/**
 * 静态代理
 * @author jairy
 * @date 2019/5/17
 */
interface IUserDao {
    void save();
}
class UserDao implements IUserDao {
    @Override
    public void save() {
        System.out.println("已经保存数据...");
    }
}
//代理类
class UserDaoProxy implements IUserDao {
    private IUserDao target;

    public UserDaoProxy(IUserDao iuserDao) {
        this.target = iuserDao;
    }

    @Override
    public void save() {
        System.out.println("开启事物...");
        target.save();
        System.out.println("关闭事物...");
    }

}
