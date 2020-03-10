package utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2020/1/2
 * \* Time: 14:58
 * \* To change this template use File | Settings | File Templates.
 * \* Description:通过该类即可在普通工具类里获取spring管理的bean
 * \
 */
public final class SpringUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (SpringUtil.applicationContext == null) {
            SpringUtil.applicationContext = applicationContext;
            System.out.println(
                    "========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
                            + applicationContext + "========");
        }
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @描述 根据beanName获取bean
     * @方法名 getBean
     * @参数 [name：beanName] 在spring中beanName默认命名为首字母小写
     * @返回值 java.lang.Object
     * @创建人 Baldwin
     * @创建时间 2020/1/7
     * @修改人和其它信息
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }
}