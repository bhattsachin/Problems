/**
 * 
 */
package com.bhatt.datacenter;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**
 * @author ubuntu
 * 
 */
public class DataCenterTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.bhatt.datacenter.DataCenter#computeDataCenter(int[][])}.
	 */
	@Test
	public void testComputeDataCenter() {
		int[][] machines = new int[][] { { 103, 103, 103 },
				{ 107, 107, 107 }, { 103, 103, 103 },
				{ 103, 103, 103 },

		};
		DataCenter dc = new DataCenter(machines);
		dc.compute();
		dc = new DataCenter(new int[][]{{89094,9009},{89094,9009}});
		dc.compute();
		dc = new DataCenter(new int[][]{{1}});
		dc.compute();
	}

	/**
	 * Test method for
	 * {@link com.bhatt.datacenter.DataCenter#getMaxValueCount(java.util.Map)}.
	 */
	@Test
	public void testGetMaxValueCount() {
		Map<Integer, Integer> cols = new HashMap<Integer, Integer>();
		cols.put(108, 4);
		cols.put(189, 90);
		cols.put(182, 90);
		cols.put(78, 7);
		assertEquals(90, DataCenter.getMaxValueCount(cols));
		
	}

	/**
	 * Test method for
	 * {@link com.bhatt.datacenter.DataCenter#getMinValueCount(int[])}.
	 */
	@Test
	public void testGetMinValueCount() {
		int inp[] = new int[]{4, 31000, 8, 0};
		assertEquals(0, DataCenter.getMinValueCount(inp));
		DataCenter.getMinValueCount(new int[]{2});
	}

}
