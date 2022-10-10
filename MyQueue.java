import java.util.ArrayList;

public class MyQueue <T> implements QueueInterface<T>{
	
	private int SizeOfQueue=10;
	private int ElementsInTheQueue=0;
	private Node head;
	private Node tail;

	
	MyQueue(){
		tail=null;
		head=null;
	}

	public MyQueue(int size) {
		// TODO Auto-generated constructor stub
		this.SizeOfQueue=size;
		tail=null;
		head=null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return head==null||tail==null;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return ElementsInTheQueue==SizeOfQueue;
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		// TODO Auto-generated method stub
		
		if(isEmpty()) {		
			throw new QueueUnderflowException();
		}
		else {
			tail.setData(null);
			
			tail=tail.getNextNode();
			
			ElementsInTheQueue--;
		}
		
		if (tail==null) {
			head=null;
			ElementsInTheQueue--;
		
			throw new QueueUnderflowException();
		}

		return head.getData();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return ElementsInTheQueue;
	}

	@Override
	public boolean enqueue(T e) throws QueueOverflowException {
		// TODO Auto-generated method stub
		Node newNode=new Node(e, null);
		newNode.setData(e);

		if (ElementsInTheQueue==SizeOfQueue) {
			throw new QueueOverflowException();
		}
		if(isEmpty()) {
			head=tail=newNode;
			tail=newNode;
			ElementsInTheQueue++;
		}
			
		else if (!isFull()) {
			tail.setNextNode(newNode);
			tail=newNode;
			ElementsInTheQueue++;
		}
		else {
			throw new QueueOverflowException();
		}
		return true;
			
	}

	public String toString() {
		String str="";
		Node temp = head;
		
		while (temp!=null) {
			str+=temp.getData();
			
			temp=temp.getNextNode();
		}
		
		return str;
	}
	@Override
	public String toString(String delimiter) {
		// TODO Auto-generated method stub
		String str="";
		Node temp = head;
		
		while (temp!=null) {
			str+=temp.getData()+delimiter;
			
			temp=temp.getNextNode();
		}
		str = str.substring(0, str.length()-1);
		return str;
	}

	@Override
	public void fill (ArrayList<T> list) {
		// TODO Auto-generated method stub
		for (int i=0; i<list.size(); i++)
			try {
				enqueue(list.get(i));
			} catch (QueueOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private class  Node {
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion, null);
		}
		
		private Node(T dataPortion, Node nextNode) {
			data=dataPortion;
			next=nextNode;
		}
		
		private T getData() {
			return data;
		}
		private void setData(T newData) {
			data=newData;
		}
		
		private Node getNextNode() {
			return next;
		}
		private void setNextNode(Node nextNode) {
			next=nextNode;
		}
	}

	
}