package ru.mirea.weatherdata;

import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class TestDataSource {
    @Test
    public void testData(){
        DataSource ds = new DataSource();
        assertFalse(ds.connectionAlive);
        ds.init();
        assertTrue(ds.connectionAlive);


        ds.exit();
        assertFalse(ds.connectionAlive);
    }
}
