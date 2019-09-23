
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

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length - 1; j++) {
				if (result[j] > result[j + 1]) {
					int temp = result[j];
					result[j] = result[j + 1];
					result[j + 1] = temp;
				}
			}
		}
		
		//  made by my hand
//////////////////////////////////////////////////
		// File Writing
		resultWriter(result, outputFile);
		return;
		
	}



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