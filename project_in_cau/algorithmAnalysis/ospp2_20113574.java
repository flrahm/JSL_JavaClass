
/*
Example call cmd line
    Compiling cmd line : javac ospp1_201_0000.java
    Execution cmd line : java ospp1_201_0000 testdata.csv result.txt
    @2018-11-19, in AA class, cau MI lab, 2018.
*/
import java.io.*;

// cau.alg.ospp@gmail.com

// Change your filename and classname to ospp1_[Your Student Number]
// ___________________________________________________________________
public class ospp1_20113574 { // CHANGE the class name to YOUR STUDENT NUMBER!!
// ___________________________________________________________________
	public static void main(String[] args) {
		// Assume call cmd: java AA [InputFilePath] [OutputFilePath]
		File inputFile = new File(args[0]);
		File outputFile = new File(args[1]);

		// File Reading
//////////////////////////////////////////////////

		int[] result = fileLoader(inputFile);
		
		
/////////reference : http://creatordev.tistory.com/70 
		QuickSort(result,0,result.length-1);

	
	}

	public static int partition(int arr[], int left, int right) {
		int pivot = arr[(left + right) / 2];
		
		while (left < right) {
			while ((arr[left] < pivot)&&(left<right))
				left++;
			while ((arr[right] > pivot) && (left < right))
				right--;
			
			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		return left;
	}
	
	
	public static void QuickSort(int arr[], int left, int right) {
		
		if (left < right) {
			int pivotIndex = partition(arr,left,right);
			
			QuickSort(arr,left,pivotIndex-1);
			QuickSort(arr, pivotIndex+1,right);
		}
	}

///////////////////////////////////////////////////////

	public static int[] fileLoader(File iFile) {
		int[] RET = null;
		String line = "";
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(iFile));
			line = bufferReader.readLine();
			String[] strNum = line.split(",", -1);
			RET = new int[strNum.length];
			for (int i = 0; i < strNum.length; i++) {
				RET[i] = Integer.parseInt(strNum[i]);
			}
			bufferReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return RET;
	}

public static int resultWriter(int[] result, File oFile){

    for(int i=0;i<result.length-1;i++){
        if(result[i]>result[i+1]){
            System.out.println("Error: sort result");
            System.out.println(i+"th :"+result[i]+", "+(i+1)+"th :"+result[i+1]);
            return -1;
        }
    }

    try{
        FileWriter fWriter = new FileWriter(oFile);
        for (int i=0;i<result.length;i++){
            fWriter.write(result[i]+" ");
        }
        fWriter.close();
    } catch(IOException e){
        for (int i=0;i<result.length;i++){
            System.out.print(result[i]+" ");
        }
        e.printStackTrace();
    }
    return 0;
}