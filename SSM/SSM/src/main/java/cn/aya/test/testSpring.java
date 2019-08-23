package cn.aya.test;

import cn.aya.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    @Test
    public void run1(){
        // 加载配置文件
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 获取对象
        AccountService as = ac.getBean("accountService", AccountService.class);
        // 调用方法
        as.findAll();
    }
}
