package com.lessons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Created by adam on 4/14/2017.
 */
@Service
public class DaoService
{
    private static final Logger logger = LoggerFactory.getLogger(DaoService.class);

    @Resource
    private DataSource postgresDataSource;

    public DaoService()
    {
        logger.debug("DaoService() constructor called.");
    }


    public void exportDataToFile(String aFilename, String aStartDate, String aEndDate)
    {
        logger.debug("exportDatatoFile()  aFilename={}  aStartDate={}  aEndDate={}", aFilename, aStartDate, aEndDate);

        JdbcTemplate jt = new JdbcTemplate(this.postgresDataSource);
        String sSql = "Select now()";
        String sDatabaseTime = jt.queryForObject(sSql, String.class);

        logger.debug("sDatabaseTime is {}", sDatabaseTime);
    }

}
