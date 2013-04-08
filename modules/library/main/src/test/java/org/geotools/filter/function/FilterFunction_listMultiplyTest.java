/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2005-2008, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.filter.function;

import org.geotools.factory.CommonFactoryFinder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.opengis.filter.FilterFactory;
import org.opengis.filter.capability.FunctionName;

/**
 *
 * @author Tobias Warneke
 */
public class FilterFunction_listMultiplyTest {

    private FilterFactory ff = CommonFactoryFinder.getFilterFactory(null);

    @Test
    public void testFunctionMetaInfo() {
        FunctionName functionName = ff.functionName("listMultiply", 2);
        assertNotNull(functionName);
    }

    /**
     * Test of evaluate method, of class FilterFunction_listMultiply.
     */
    @Test
    public void testEvaluate() {
        FilterFunction_listMultiply func = (FilterFunction_listMultiply) ff.function("listMultiply", ff.literal(2), ff.literal("1 2 3"));
        Object evaluate = func.evaluate(null);
        assertTrue(evaluate instanceof String);
        assertEquals("2.0 4.0 6.0", evaluate.toString());
    }

    @Test
    public void testEvaluate2() {
        FilterFunction_listMultiply func = (FilterFunction_listMultiply) ff.function("listMultiply", ff.literal(2.5), ff.literal("1 2 3"));
        Object evaluate = func.evaluate(null);
        assertTrue(evaluate instanceof String);
        assertEquals("2.5 5.0 7.5", evaluate.toString());
    }

    @Test
    public void testEvaluateNull() {
        FilterFunction_listMultiply func = (FilterFunction_listMultiply) ff.function("listMultiply", ff.literal(2.5), ff.literal((String) null));
        Object evaluate = func.evaluate(null);
        assertNull(evaluate);
    }
}