/* ============
 * Orson Charts
 * ============
 * 
 * (C)opyright 2013, by Object Refinery Limited.
 * 
 */

package com.orsoncharts;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 * Some tests for the {@link Range} class.
 */
public class RangeTest {

    @Test
    public void testEquals() {
        Range range1 = new Range(0, 10);
        Range range2 = new Range(0, 10);
        assertEquals(range1, range2);
    
        range1 = new Range(2, 4);
        assertNotEquals(range1, range2);
        range2 = new Range(2, 4);
        assertEquals(range1, range2);
    }
   
    @Test
    public void testContains() {
        Range r = new Range(0, 10);
        assertFalse(r.contains(-0.5));
        assertTrue(r.contains(0.0));
        assertTrue(r.contains(5.0));
        assertTrue(r.contains(10.0));
        assertFalse(r.contains(10.5));
    }
    
    @Test
    public void testIntersects() {
        Range r = new Range(0, 10);
        assertFalse(r.intersects(-0.5, -0.1));
        assertTrue(r.intersects(-0.5, 0.0));
        assertTrue(r.intersects(0.0, 5.0));
        assertTrue(r.intersects(0.0, 10.0));
        assertTrue(r.intersects(0.0, 11.0));
        assertTrue(r.intersects(5.0, 9.0));
        assertTrue(r.intersects(5.0, 10.0));
        assertTrue(r.intersects(5.0, 11.0));
        assertTrue(r.intersects(10.0, 11.0));
        assertFalse(r.intersects(10.5, 11.0));        
    }
    
    private static final double EPSILON = 0.0000001;
    
    /**
     * A check for serialization.
     */
    @Test
    public void testSerialization() {
        Range r1 = new Range(0, 10);
        Range r2 = (Range) TestUtils.serialized(r1);
        assertEquals(r1, r2);
    }
}
