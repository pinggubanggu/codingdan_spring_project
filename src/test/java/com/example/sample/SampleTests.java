package com.example.sample;

import static org.junit.Assert.assertNotNull;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/springroot/root-context.xml"})
@Log4j
public class SampleTests {

    @Setter(onMethod_ = { @Autowired })
    private Restaurant restaurant;

    @Test
    public void testExist() {
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("----------------------------------------------------");
        log.info(restaurant.getChef());
    }

}
