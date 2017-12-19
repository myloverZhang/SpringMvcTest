import ct.dc.mobile.api.service.login.AppLoginServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by B41-80 on 2017/1/6.
 */
public class MongoTest {
    public static void main(String[] args)
    {
        ApplicationContext context = new FileSystemXmlApplicationContext("/web/WEB-INF/spring-context.xml");
        AppLoginServiceImpl service = (AppLoginServiceImpl) context.getBean("appLoginService");
        service.appUsersByDay(1880461,20161001,20161101);
    }
}
