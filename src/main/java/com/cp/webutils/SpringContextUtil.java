/**
 * SpringContextUtil.java 
 * 版权所有@2014 前沿体育
 * Create by 郑水金
 * At 2015-11-21 下午5:22:56
 */
package com.cp.webutils;

/**获取Spring的ApplicationContext 工具类
 * Description: 
 * 在applicationContext.xml文件中配置此bean，以便让Spring启动时自动为我们注入ApplicationContext对象.
 * 例：

 <!-- 这个bean主要是为了得到ApplicationContext 所以它不需要其它属性-->

<bean class="com.yxty.web.utils.SpringContextUtil"></bean>
 有了这个ApplicationContext之后我们就可以调用其getBean("beanName")方法来得到由Spring 管理所有对象.
 */
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextUtil implements ApplicationContextAware
{
    private static ApplicationContext context;

    // 声明一个静态变量保存

    @SuppressWarnings("static-access")
    public void setApplicationContext(ApplicationContext contex)
        throws BeansException
    {
        this.context = contex;
    }

    public static ApplicationContext getContext()
    {
        return context;
    }

    public final static Object getBean(String beanName)
    {
        return context.getBean(beanName);
    }

    public final static Object getBean(String beanName, Class<?> requiredType)
    {
        return context.getBean(beanName, requiredType);
    }
}
