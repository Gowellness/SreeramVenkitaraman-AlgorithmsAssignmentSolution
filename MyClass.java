package myProject;
import java.util.*;
public class MyClass {

//company class----------------------------------------------------------------------------------------------------------------------
    public static class company{
    
    public double current_st_price = 0 ;
    public double yesterdays_st_price = 0;
    public int company_number ;
    public boolean tf_value ;
    
    public company(double a , int b , boolean c){
        
        yesterdays_st_price= current_st_price;
        current_st_price= a;
        company_number= b;
        tf_value= c;

    }
    
    }
    
  
    

//funPerformOperations()--------------------------------------------------------------------------------------------------------------------------------
    
    public static void funPerformOperations(ArrayList<company> objList,int n){
        
        Scanner sc = new Scanner(System.in);
        
        while(true){
        System.out.println("\n\n\n------------------------------------------------------------------");
        System.out.println("Enter the operation that you want to perform: ");
        System.out.println("1. Display the companies stock prices in ascending order(press:1)");
        System.out.println("2. Display the companies stock prices in descending order(press:2)");
        System.out.println("3. Display the total no of companies for which stock prices rose today(press:3)");
        System.out.println("4. Display the total no of companies for which stock prices declined today(press:4)");
        System.out.println("5. Search a specific stock price(press:5)");
        System.out.println("6. press 0 to exit");

        int temp= sc.nextInt();

        if(temp==0) break;
        

        switch(temp){
            case 1: fun1(objList,n); 
            break;
            case 2: fun2(objList,n); 
            break;
            case 3: fun3(objList,n); 
            break;
            case 4: fun4(objList,n); 
            break;
            case 5: fun5(objList,n); 
            break;
            default: System.out.println("input is not valid");
            
        }
        
        }
        
    }
    
    
//fun1--------------------------------------------------------------------------------------------------------------------------------

public static void fun1(ArrayList<company> objList , int n){
    
    ArrayList<Double> arr= new ArrayList<Double>();
    for(int i=0;i<n;i++){
        double val = objList.get(i).current_st_price;
        arr.add(Double.valueOf(val));
    }
    Collections.sort(arr);
    System.out.print("\nthe companies stock prices in ascending order: ");
    for(int i=0;i<n;i++) {
    	System.out.print(arr.get(i)+" ");
    }
    
}

//fun2--------------------------------------------------------------------------------------------------------------------------------

public static void fun2(ArrayList<company> objList , int n){
	
	ArrayList<Double> arr= new ArrayList<Double>();
    for(int i=0;i<n;i++){
        double val = objList.get(i).current_st_price;
        arr.add(Double.valueOf(val));
    }
    Collections.sort(arr,Collections.reverseOrder());
    System.out.print("\nthe companies stock prices in decending order: ");
    for(int i=0;i<n;i++) {
    	System.out.print(arr.get(i)+" ");
    }
    System.out.println();
    
}

//fun3--------------------------------------------------------------------------------------------------------------------------------

public static void fun3(ArrayList<company> objList , int n){
	
	int count=0;
	for(int i=0;i<n;i++) {
		if(objList.get(i).tf_value==true) {
			count++;
		}
	}
	System.out.println("\nthe total no of companies for which stock prices rose today: " + count);
    
}

//fun4--------------------------------------------------------------------------------------------------------------------------------

public static void fun4(ArrayList<company> objList , int n){
	
	int count=0;
	for(int i=0;i<n;i++) {
		if(objList.get(i).tf_value==false) {
			count++;
		}
	}
	System.out.println("\nthe total no of companies for which stock prices declined today: " + count);
    
}

//fun5--------------------------------------------------------------------------------------------------------------------------------

public static void fun5(ArrayList<company> objList , int n){
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("enter the key value");
	double temp= sc.nextDouble();
	for(int i=0;i<n;i++) {
		if(objList.get(i).current_st_price==temp) {
			System.out.println("Stock of value "+temp +  " is present");
			break;
		}
		else if(((objList.get(i).current_st_price) != temp)  && (i==n-1)) {			
			System.out.println("Value not found");
		}
	}
	
}


//main()----------------------------------------------------------------------------------------------------
    
    
    
    
    
    
    
public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Total number of companies: ");
        int n= sc.nextInt();
        ArrayList<company> objList = new ArrayList<company>(n); 
        for(int i=0;i<n;i++){
            
            System.out.println("Enter current stock price of the company "+(i+1));
            double temp1= sc.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            boolean temp2= sc.nextBoolean();
            
            company obj_temp = new company(temp1,i,temp2);
            objList.add(obj_temp);
            
        }
        
        
        funPerformOperations(objList,n);
        
    }
    
    
    
}


