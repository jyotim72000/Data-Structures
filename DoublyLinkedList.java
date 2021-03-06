import java.util.Scanner;

class Node
{
	private int data;
	private Node next;
	private Node prev;

	
	public Node()
	{
		data=0;
		next=null;
		prev =null;
	}
	
	public Node(int d,Node n, Node p)
	{
		data=d;
		next=n;
		prev=p;
	}
	
	public void setData(int d)
	{
		data=d;
	}
	
	public void setNext(Node n)
	{
		next=n;
	}
	
	public void setPrev(Node p)
	{
		prev=p;
	}
	
	public int getData()
	{
		return (data);
	}
	
	public Node getNext()
	{
		return(next);
	}
	
	public Node getPrev()
	{
		return(prev);
	}
}

class LinkedList
{
	private int size;
	private Node start;
	
	public LinkedList()
	{
		size=0;
		start=null;
	}
	
	public boolean isEmpty()
	{
		if(start==null)
			return(true);
		else
			return(false);
	}
	
	public int getListSize()
	{
		return(size);
	}
	
	public void insertAtFirst(int value)
	{
		Node NewNode;
		NewNode = new Node();
		NewNode.setData(value);
		NewNode.setNext(start);
		NewNode.setPrev(null);
		if(start!=null) {
			start.setPrev(NewNode);
		}
		start = NewNode;
		size++;
	}
	
	public void insertAtLast(int value)
	{
		Node NewNode,t,t1;
		NewNode = new Node();
		NewNode.setData(value);
		NewNode.setNext(null);
		t=start;
		t1=start;
		if(t==null)
			start=NewNode;
		else
		{
			while(t.getNext()!=null)
			{
				t=t.getNext();
				t1=t.getPrev();
			}
			t.setNext(NewNode);
			t.setPrev(t1);
		}
		size++;
	}
	
	public void insertAtPos(int value, int pos)
	{
		if(pos==1)
			insertAtFirst(value);
		if(pos==size+1)
			insertAtLast(value);
		if(pos>1&&pos<=size)
		{
			Node t,t1;
			t=start;
			t1=start;
			Node NewNode = new Node(value,null,null);
			for(int i=1;i<pos-1;i++)
			{
				t=t.getNext();
				t1=t.getNext();
			}
			NewNode.setNext(t.getNext());
			NewNode.setPrev(t1.getPrev());
			t.setNext(NewNode);
			size++;
		}
		else
			System.out.println("Insertion not possible at this position");
	}
	
	public void deleteAtFirst()
	{
		if(start==null)
			System.out.println("List is already empty");
		else
		{
			start = start.getNext();
			start.setPrev(null);
			size--;
		}
	}
	
	public void deleteAtLast()
	{
		Node t;
		t=start;
		if(start==null)
			System.out.println("List is already empty");
		else
		{
			for(int i=1;i<size-1;i++)
			{
				t=t.getNext();
			}
			t.setNext(null);
			size--;
		}
	}
	
	public void deleteAtPos(int pos)
	{
		Node t, t1;
		t=start;
		t1=start;
		if(start==null)
			System.out.println("List is already empty");
		else if(pos>size||pos<1)
			System.out.println("Invalid position");
		else if(pos==1)
			deleteAtFirst();
		else if(pos==size)
			deleteAtLast();
		else
		{
			for(int i=1;i<pos-1;i++)
			{
				t=t.getNext();
			}
			t1=t.getNext();
			t.setNext(t1.getNext());
			t.setPrev(t1.getPrev());
			size--;
		}
	}
	
	public void viewList()
	{
		Node t;
		if(isEmpty())
		{
			System.out.println("List is empty.");
		}
		else
		{
			t = start;
			for(int i=1;i<=size;i++)
			{
				System.out.println(" "+t.getData());
				t = t.getNext();
			}
		}
	}
}

public class DoublyLinkedList
{
	public static void main(String args[])
	{
		Scanner s = new Scanner(System.in);
		LinkedList list = new LinkedList();
		boolean flag=true;
		while(flag)
		{
			System.out.println("");
			System.out.println("1. Add item to the list at first");
			System.out.println("2. Add item to the list at last");
			System.out.println("3. Add item to the list at position");
			System.out.println("4. Delete item from the list at first");
			System.out.println("5. Delete item from the list at last");
			System.out.println("6. Delete item from the list at position");
			System.out.println("7. View List");
			System.out.println("8. EXIT");
			System.out.println("Enter your choice : ");
			int choice = s.nextInt();
			int position,value;
			switch(choice)
			{
				case 1:
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtFirst(value);
					break;
				case 2:
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtLast(value);
					break;
				case 3:
					System.out.println("Enter position of item : ");
					position = s.nextInt();
					System.out.println("Enter value of item : ");
					value = s.nextInt();
					list.insertAtPos(value, position);
					break;
				case 4:
					list.deleteAtFirst();
					break;
				case 5:
					list.deleteAtLast();
					break;
				case 6:
					System.out.println("Enter position : ");
					position = s.nextInt();
					list.deleteAtPos(position);
					break;
				case 7:
					list.viewList();
					break;
				case 8:
					flag=false;
					break;
				default:System.out.println("Invalid choice");
			}
		}
	}
}
