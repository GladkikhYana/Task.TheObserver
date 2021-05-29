package test;

import Model.Clock;

import static org.junit.Assert.*;

public class ClockTest {
private Clock clock;
    @org.junit.Before
    public void setUp() throws Exception {
        clock = new Clock();
    }
    @org.junit.After
    public void tearDown() throws Exception {
        clock = null;
    }
    @org.junit.Test
    public void draw() {
        assertNotNull("Not null", clock);
    }
}