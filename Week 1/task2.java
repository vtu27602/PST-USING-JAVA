import java.util.Scanner;
public class max{
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n=sc.nextInt();
        
        int[] arr=new int[n];
        System.out.println("Enter the elements:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int max=arr[0];
        for(int i=1;i<n;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        System.out.println("Max element is "+ max);
    }
    
}

OUTPUT:Enter size of array:
3
Enter the elements:
4
4
5
Max element is 5
