 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javafx.scene.control.SpinnerValueFactory.DoubleSpinnerValueFactory;

public class MyQueueTest {
	public MyQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public MyQueue<Double> doubleQ;
	public double one=1, two=2, three=3, four=4;
	// STUDENT: add variables as needed for your student tests

	@Before
	public void setUp() throws Exception {
		stringQ = new MyQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		doubleQ=new MyQueue<Double>(4);
		doubleQ.enqueue(one);
		doubleQ.enqueue(two);
		//doubleQ.enqueue(three);
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	@Test
	public void testIsEmpty() {
		try {
			assertEquals(false,stringQ.isEmpty());
			stringQ.dequeue();
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(true, stringQ.isEmpty());
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		
		
	}
	
	@Test
	public void testDequeueStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		try {
			assertEquals(a, doubleQ.dequeue());
			assertEquals(b, doubleQ.dequeue());
			//assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		
	}

	@Test
	public void testSize() {
		
		try {
			assertEquals(3, stringQ.size());
			stringQ.enqueue(d);
			assertEquals(4, stringQ.size());
			stringQ.dequeue();
			stringQ.dequeue();
			assertEquals(2, stringQ.size());
		} catch (QueueOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
//			System.out.println(stringQ.size());
			assertTrue("This should have caused an QueueOverflowException", false);
			
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
//			System.out.println(stringQ.size());
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testEnqueueStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		try {
			assertEquals(2, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(three));
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(four));
			assertEquals(4, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue((double) 5);
			
			assertTrue("This should have caused an QueueOverflowException", false);
			
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
			//System.out.println(stringQ.size());
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	@Test
	public void testIsFull() {
		
		try {
			assertEquals(false, stringQ.isFull());
			stringQ.enqueue(d);
			stringQ.enqueue(e);
//			System.out.println(stringQ.size());
			assertEquals(true, stringQ.isFull());
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Test
	public void testToString() {
		
		try {
			assertEquals("abc", stringQ.toString());
			stringQ.enqueue(d);
			assertEquals("abcd", stringQ.toString());
			stringQ.enqueue(e);
			assertEquals("abcde", stringQ.toString());
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
//		fail("Not yet implemented");
		try {
			System.out.println(doubleQ.toString()+ " A");
			assertEquals("1.02.0", doubleQ.toString());
			
			doubleQ.enqueue(four);
			assertEquals("1.02.04.0", doubleQ.toString());
			doubleQ.dequeue();
			doubleQ.enqueue((double)5);
			assertEquals("1.02.05.0", doubleQ.toString());
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testToStringDelimiter() {
		
		try {
			assertEquals("a%b%c", stringQ.toString("%"));
			stringQ.enqueue(d);
			assertEquals("a&b&c&d", stringQ.toString("&"));
			stringQ.enqueue(e);
			assertEquals("a/b/c/d/e", stringQ.toString("/"));
		} catch (QueueOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Test
	public void testFill() {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new MyQueue<String>(5);
		//fill with an ArrayList
		stringQ.fill(fill);
		assertEquals(3,stringQ.size());
		try {
			assertEquals("apple", stringQ.dequeue());
			assertEquals("banana", stringQ.dequeue());
			assertEquals("carrot", stringQ.dequeue());	
		} catch (QueueUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

}
