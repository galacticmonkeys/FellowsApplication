import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/** Tests the Queue class. (To test larger inputs, simply add data using a loop.)
 */
public class queueTest {

	/** Don't dequeue completely. Then enqueue again */
	@Test
	public void testQueue() {
		thing.enqueue(1);
		thing.enqueue(3);
		assertEquals(1, thing.dequeue());
		thing.enqueue(2);
		assertEquals(3, thing.dequeue());
	}

	/** Should throw exception for full queue */
	@Test(expected= IllegalStateException.class)
	public void testExceptions() {
		thing.enqueue(1);
		thing.enqueue(3);
		thing.enqueue(2);
	}

	/** Should throw exception for empty queue */
	@Test(expected= IllegalStateException.class)
	public void testExceptions2() {
		thing.enqueue(1);
		thing.enqueue(2);
		assertEquals(1, thing.dequeue());
		assertEquals(2, thing.dequeue());
		thing.dequeue();
	}

   	/**A queue of size 2 */ 
    private Queue thing = new Queue(2);

	public static void main(String... args) {
	    org.junit.runner.JUnitCore.main("queueTest");
	}
}

