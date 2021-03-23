public class SelectionSort 
{
	public void printArray(int[] arr)
	{
		int n = arr.length;
		for(int i=0; i <n; i++) 
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public void sort(int[] arr)
	{
		int n = arr.length;
		for(int i=0; i< n-1; i++) //unsorted part
		{
			int min = i;
			for(int j=i+1; j<n; j++)
			{
				if(arr[j] < arr[min])
					min = j;
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
	public static void main(String[] args)
	{
		int[] arr = new int[] {5,1,2,9,10};
		BubbleSort bs = new BubbleSort();
		System.out.println("Array before sorting");
		bs.printArray(arr);
		bs.sort(arr);
		System.out.println("Array after sorting");
		bs.printArray(arr);
	}
}
