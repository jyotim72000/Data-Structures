import java.util.Scanner;

class Node
{
	private int data;
	private Node next;
	
	public Node()
	{
		data = 0;
		next = null;
	}
	
	public Node(int d, Node n)
	{
		data = d;
		next = n;
	}
	
	public void setData(int d)
	{
		data = d;
	}
	
	public void setNext(Node n)
	{
		next = n;
	}
	
	public int getData()
	{
		return (data);
	}
	
	public Node getNext()
	{
		return (next);
	}
}

class LinkedList
{
	private int size;
	private Node last;
	
	public LinkedList()
	{
		size = 0;
		last = null;
	}
	
	public boolean isEmpty()
	{
		if(last==null)
			return(true);
		else
			return(false);
	}
	
	public int getListSize()
	{
		return(size);
	}
	
	/*public void insertAtFirst(int value)
	{
		if(last==null)
		{
			Node NewNode = new Node();
			last=NewNode;
			NewNode.setData(value);			
			NewNode.setNext(NewNode);
		}
		else
		{
			Node NewNode = new Node();
			Node t = last;
			NewNode.setData(value);
			NewNode.setNext(t.getNext());
			last.setNext(NewNode);
		}
		size++;
		
	}*/
	public void insertAtFirst(int value)
	{
		Node newNodeAdded = new Node();
		if(last==null)
		{
			last = newNodeAdded;
			newNodeAdded.setData(value);
			newNodeAdded.setNext(newNodeAdded);
		}
		else
		{
			Node t = last;
			newNodeAdded.setData(value);
			newNodeAdded.setNext(t.getNext());
			last.setNext(newNodeAdded);
		}
		size++;
	}
	
	public void insertAtLast(int value)
	{
		if(last==null)
		{
			Node NewNode = new Node();
			last=NewNode;
			NewNode.setData(value);			
			NewNode.setNext(NewNode);
		}
		else
		{
			Node NewNode = new Node();
			Node t = last;
			NewNode.setData(value);
			NewNode.setNext(t.getNext());
			t.setNext(NewNode);
			last=NewNode;
		}
		size++;
	}
	
	public void insertAtPos(int value, int pos)
	{
		if(last==null)
		{
			Node NewNode = new Node();
			last=NewNode;
			NewNode.setData(value);			
			NewNode.setNext(NewNode);
		}
		else
		{
			if(pos==1)
				insertAtFirst(value);
			if(pos==size+1)
				insertAtLast(value);
			if(pos>1&&pos<=size)
			{
				Node NewNode = new Node(value,null);
				Node t =last;
				for(int i=1;i<pos;i++)
				{
					t=t.getNext();
				}
				NewNode.setNext(t.getNext());
				t.setNext(NewNode);
			}
		}
		size++;
	}
	
	public void deleteAtFirst()
	{
		if(last==null)
			System.out.println("List is already empty");
		else
		{
			Node t = last;
			t = t.getNext();
			last.setNext(t.getNext());
			size--;
		}
	}
	
	public void deleteAtLast()
	{
		if(last==null)
			System.out.println("List is already empty");
		else
		{
			Node t =last;
			Node t1 = last;
			for(int i=1;i<size;i++)
			{
				t=t.getNext();
			}
			last = t;
 			t.setNext(t1.getNext());
			size--;
		}
	}
	
	public void deleteAtPos(int pos)
	{
		Node t =last;
		Node t1 =last;
		if(last==null)
			System.out.println("List is already empty");
		else if(pos>size||pos<1)
			System.out.println("Invalid position");
		else if(pos==1)
			deleteAtFirst();
		else if(pos==size)
			deleteAtLast();
		else
		{
			for(int i=1;i<pos;i++)
			{
				t=t.getNext();
			}
			t1=t.getNext();
			t.setNext(t1.getNext());
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
			t = last;
			for(int i=1;i<=size;i++)
			{
				t = t.getNext();
				System.out.println("  "+t.getData());
			}
		}
	}
}

public class CircularLinkedList {
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
			System.out.println("8. Reverse your list");
			System.out.println("9. EXIT");
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
