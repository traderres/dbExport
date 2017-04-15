package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import javax.sql.DataSource;

/**
 * Created by adam on 4/14/2017.
 */
public class App
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.debug("main() started.");

        // Create the spring context
        //  1) Read spring-beans.xml
        //  2) Instantiate the spring beans
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");

        // Register a shutdown hook so that the Spring Context is shutdown gracefully on JVM exit
        AbstractApplicationContext ctx = (AbstractApplicationContext) context;
        ctx.registerShutdownHook();

        // Get a reference to the bean called "daoService"
        DaoService daoService = (DaoService) context.getBean("daoService");

        // Export the data to a dump file
        daoService.exportDataToFile("c:\\temp\\stuff.txt", "01/01/2000", "01/05/2000");


        logger.debug("main() finished.");
    }
}
