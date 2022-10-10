 
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyStackTest {
	public MyStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public MyStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	public double one=1, two=2, three=3, four=4;
	
	@Before
	public void setUp() throws Exception {
		stringS = new MyStack<String>(5);
		stringS.push(a);
		stringS.push(b);
		stringS.push(c);
		
		//STUDENT: add setup for doubleS for student tests
		doubleS=new MyStack<Double>(4);
		doubleS.push(one);
		doubleS.push(two);
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,stringS.isEmpty());
		try {
			stringS.pop();
			stringS.pop();
			stringS.pop();
			assertEquals(true, stringS.isEmpty());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testIsFull() {
		assertEquals(false, stringS.isFull());
		try {
			stringS.push(d);
			stringS.push(e);
			assertEquals(true, stringS.isFull());
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	@Test
	public void testPopStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
//		assertEquals(2.0, doubleS.pop());
		assertEquals(2, doubleS.size());
		try {
			doubleS.pop();
			assertEquals(1, doubleS.size());
			doubleS.pop();
			assertEquals(0, doubleS.size());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	@Test
	public void testTop() {
		try {
			assertEquals(c, stringS.top());
			stringS.push(d);
			assertEquals(d, stringS.top());
			stringS.pop();
			stringS.pop();
			assertEquals(b, stringS.top());	
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Test
	public void testSize() {
		assertEquals(3, stringS.size());
		try {
			stringS.push(d);
			assertEquals(4, stringS.size());
			stringS.pop();
			stringS.pop();
			assertEquals(2, stringS.size());
		} catch (StackOverflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	@Test
	public void testPushStudent() {
		//Use the doubleQ for student tests
		//fail("Not yet implemented");
		try {
			assertEquals(2, doubleS.size());
			assertEquals(true, doubleS.push(three));
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(four));
			assertEquals(4, doubleS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleS.push((double)5);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}
	
	@Test
	public void testToString() {
		assertEquals("abc", stringS.toString());
		try {
			stringS.push(d);
			assertEquals("abcd", stringS.toString());
			stringS.push(e);
			assertEquals("abcde", stringS.toString());
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

	@Test
	public void testToStringStudent() {
		//Use the doubleQ for student tests
//		fail("Not yet implemented");
		assertEquals("1.02.0", doubleS.toString());
		try {
			doubleS.push(three);
			assertEquals("1.02.03.0", doubleS.toString());
			doubleS.pop();
			assertEquals("1.02.0", doubleS.toString());
			
		} catch (StackOverflowException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testToStringDelimiter() {
		assertEquals("a%b%c", stringS.toString("%"));
		try {
			stringS.push(d);
			assertEquals("a&b&c&d", stringS.toString("&"));
			stringS.push(e);
			assertEquals("a/b/c/d/e", stringS.toString("/"));
		} catch (StackOverflowException e1) {
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
		stringS = new MyStack<String>(5);
		//fill with an ArrayList
		stringS.fill(fill);
		assertEquals(3,stringS.size());
		try {
			assertEquals("carrot", stringS.pop());
			assertEquals("banana", stringS.pop());
			assertEquals("apple", stringS.pop());
		} catch (StackUnderflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

}
