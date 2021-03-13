package array;
public class Main 
{
	public static void printArray(int[] arr) 
	{
		for(int i = 0; i < arr.length; i++) 
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void reverseArray(int[] arr, int start, int end)
	{
		while(start < end)
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
	public int findMin(int[] arr)
	{
		int min = arr[0];
		for(int i=1; i<arr.length; i++)
		{
			if(arr[i]<min)
			{
				min = arr[i];
			} 
		}
		return min;
	}
	public static void moveZero(int[] arr, int n)
	{
		int j=0;
		for(int i=0; i<n; i++)
		{
			if(arr[i]!=0 && arr[j]==0)
			{
				int zero = arr[i];
				arr[i] = arr[j];
				arr[j] = zero;
			}
			if(arr[j]!=0)
				j++;
		}
	}
	
	public int[] resize(int[] arr, int capacity)
	{
		int[] temp = new int[capacity];
		for(int i=0; i<arr.length; i++)
		{
			temp[i]= arr[i];
		}
		arr=temp;
		return arr;
	}
	
	public int[] mergeArray(int[] arr1, int[] arr2, int n, int m)
	{
		int[] result = new int[n + m];
		int i = 0; 
		int j = 0; 
		int k = 0;
		while(i<n && j<m) //boundary condition
		{
			if(arr1[i]<arr2[j])
			{
				result[k] = arr1[i];
				i++;
			}
			else
			{
				result[k] = arr2[j];
				j++;
			}
			k++;
		}
		while(i<n) //arr2 got exhausted
		{
			result[k] = arr1[i];
			i++;
			k++;
		}
		while(j<m) //arr1 got exhausted
		{
			result[k]=arr2[j];
			j++;
			k++;
		}
		return result;
	}
	
	public static void main(String[] args) 
	{
		int[] array = {2,11,5,10,7,8};
		printArray(array);
		reverseArray(array, 0, array.length - 1);
		printArray(array);
		Main obj = new Main();
		System.out.println(obj.findMin(array));
		int[] zeroarray = {5,0,6,4,10,0,15};
		moveZero(zeroarray, zeroarray.length);
		printArray(zeroarray);
		System.out.println("The size of original array is " + array.length);
		array = obj.resize(array, 10);
		System.out.println("The size of array after resizing is " + array.length);

		int[] arr1 = {2,3,5,10};
		int[] arr2 = {4,6,11,15};
		int[] result = obj.mergeArray(arr1, arr2, arr1.length, arr2.length);
		obj.printArray(result);
	}
}
