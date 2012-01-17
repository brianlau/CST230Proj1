import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class myIO {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		System.out.println("Please enter the path of your file:");
		Scanner scan = new Scanner(System.in);
		String file = scan.nextLine();
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;

		try {
			inputStream = new BufferedReader(new FileReader(file));
			outputStream = new PrintWriter(new FileWriter("Lau_hw1_out.txt"));

			List<String> text = new ArrayList<String>();
			List<String> revText = new ArrayList<String>();
			List<String> revEvery = new ArrayList<String>();
			String l;
			while ((l = inputStream.readLine()) != null) {
				text.add(l);
			}
			for(int i = 0; i <= text.size()-1; i++){
				String temp = text.get(i);
				String rev ="";
				for(int j = temp.length()-1; j >=0; j--){
					char letter = temp.charAt(j);
					rev = rev + letter;
				}
				revText.add(rev.toString());
			}
			for (int i = revText.size() -1; i >= 0; i-- ){
				revEvery.add(revText.get(i));
			}
//			while ((m = inputStream.readLine()) != null){
//				for(int i = m.length()-1; i >= 0; i--){
//					outputStream.print(m.charAt(i));
//				}
//			}
		} 
		catch (Exception e){
			System.out.println("File Not Found");
		}
		finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}