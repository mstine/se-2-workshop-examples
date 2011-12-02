package com.dss.se2workshop;

import com.dss.se2workshop.util.PropertyLoader;
import org.junit.Assert;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void itWorks() {
        Assert.assertTrue(true);

        Assert.assertEquals("http://content1.local:8080", PropertyLoader.getBaseUrl());
    }
}
