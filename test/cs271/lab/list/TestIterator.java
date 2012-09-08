package cs271.lab.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestIterator {

	private List<Integer> list;

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<Integer>();
		// TODO also try with a LinkedList - does it make any difference?
	}

	@After
	public void tearDown() throws Exception {
		list = null;
	}

	@Test
	public void testEmpty() {
		final Iterator<Integer> i = list.iterator();
		assertFalse(i.hasNext());
	}

	@Test
	public void testNonempty() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		final Iterator<Integer> i = list.iterator();
		assertTrue(i.hasNext());
		assertEquals(33, (int)i.next());
		// TODO fix the expected values in the assertions below
		assertTrue(i.hasNext());
		assertEquals(77, (int)i.next());
		assertTrue(i.hasNext());
		assertEquals(44,(int) i.next());
		assertTrue(i.hasNext());
		assertEquals(77,(int) i.next());
		assertTrue(i.hasNext());
		assertEquals(55, (int)i.next());
		assertTrue(i.hasNext());
		assertEquals(77, (int)i.next());
		assertTrue(i.hasNext());
		assertEquals(66, (int)i.next());
		assertFalse(i.hasNext());
	}

	@Test
	public void testRemove() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		final Iterator<Integer> i = list.iterator();
		while (i.hasNext()) {
			if (i.next() == 77) {
				i.remove(); // TODO what happens if you use list.remove(77)?
			}
		}
		// TODO using assertEquals and Arrays.asList (see above)
		// express which values are left in the list
//		fail("Not yet implemented"); // remove this line when done
		assertEquals(Arrays.asList(33,44,55,66) ,list);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAverageValues() {
		list.add(33);
		list.add(77);
		list.add(44);
		list.add(77);
		list.add(55);
		list.add(77);
		list.add(66);
		double sum = 0;
		int n = 0;
		final Iterator<Integer> i = list.iterator();
		while (i.hasNext()){
			n++;
			sum = sum + i.next();
		}
		// TODO use an iterator and a while loop to compute the average (mean) of the values
		// (defined as the sum of the items divided by the number of items)
		assertEquals(61, sum / n,1);
		assertEquals(7, n);
	}
}
