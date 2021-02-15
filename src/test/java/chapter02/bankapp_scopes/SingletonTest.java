package chapter02.bankapp_scopes;

import chapter02.bankapp_interfaces.dao.FixedDepositDao;
import chapter02.bankapp_scopes.controller.FixedDepositController;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class SingletonTest {
    private static ApplicationContext context;

    @BeforeClass
    public static void init() {
        context = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter02/scopes/applicationContext.xml");
    }

    @Test
    public void testInstances() {
        FixedDepositController controller1 = (FixedDepositController) context.getBean("controller");
        FixedDepositController controller2 = (FixedDepositController) context.getBean("controller");

        assertSame("Different FixedDepositController instances", controller1, controller2);
    }

    @Test
    public void testReference() {
        FixedDepositController controller = (FixedDepositController) context.getBean("controller");
        FixedDepositDao fixedDepositDao1 = controller.getFixedDepositService().getFixedDepositDao();
        FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("dao");

        assertSame("Different FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
    }

    @Test
    public void testSingletonScope() {
        ApplicationContext anotherContext = new ClassPathXmlApplicationContext(
                "classpath:META-INF/spring/chapter02/scopes/applicationContext.xml");
        FixedDepositController fixedDepositController1 =
                (FixedDepositController) anotherContext.getBean("controller");
        FixedDepositController fixedDepositController2 =
                (FixedDepositController) context.getBean("controller");

        assertNotSame("Same FixedDepositController instances",
                fixedDepositController1, fixedDepositController2);
    }

    @Test
    public void testSingletonScopePerBeanDef() {
        FixedDepositDao fixedDepositDao1 = (FixedDepositDao) context.getBean("dao");
        FixedDepositDao fixedDepositDao2 = (FixedDepositDao) context.getBean("anotherDao");

        assertNotSame("Same FixedDepositDao instances", fixedDepositDao1, fixedDepositDao2);
    }

}
