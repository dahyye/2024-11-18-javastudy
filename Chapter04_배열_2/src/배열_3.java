import java.util.Arrays;

public class 배열_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
//		int arr[] = new int[10];
//
//		int max=0;
//		int min=0;
//		int max_index;
//		int min_index;
//		
//		for(int i=0;i<arr.length;i++)
//		{
//			arr[i]=(int)(Math.random()*100)+1;
//			if(arr[i]>max)
//			{
//				max=arr[i];
//				max_index = i;
//			}
//			if(arr[i]<min)
//			{
//				min=arr[i];
//				min_index = i;
//			}
//			
//		}
//		
//		System.out.println(Arrays.toString(arr));
//		System.out.println("최대값은 "+max);
//		System.out.println("최소값은 ");
		
		
		int[] arr = new int[10];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		int max=arr[0];
		int min=arr[0];
		int max_index=0;
		int min_index=0;
		
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>max)
			{
				max=arr[i];
				max_index=i+1;
			}
			if(arr[i]<min)
			{
				min=arr[i];
				min_index=i+1;
			}
		}
		
		
		System.out.println("최대값은 "+max);
		System.out.println("최소값은 "+min);
		System.out.println("최대값은 "+max_index+"번째에 위치하고 있다");
		System.out.println("최th값은 "+min_index+"번째에 위치하고 있다");

		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
