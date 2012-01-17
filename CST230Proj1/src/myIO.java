import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
			for (int i = 0; i <= text.size() - 1; i++) {
				String temp = text.get(i);
				String rev = "";
				for (int j = temp.length() - 1; j >= 0; j--) {
					char letter = temp.charAt(j);
					rev = rev + letter;
				}
				revText.add(rev.toString());
			}
			for (int i = revText.size() - 1; i >= 0; i--) {
				revEvery.add(revText.get(i));
			}
			// while ((m = inputStream.readLine()) != null){
			// for(int i = m.length()-1; i >= 0; i--){
			// outputStream.print(m.charAt(i));
			// }
			// }

			for (int i = 0; i <= text.size() - 1; i++) {
				outputStream.write(text.get(i));
				outputStream.write("\n");
			}
			outputStream.write("\n");
			for (int j = 0; j <= revText.size() - 1; j++) {
				outputStream.write(revText.get(j));
				outputStream.write("\n");
			}
			outputStream.write("\n");
			for (int k = 0; k <= revEvery.size() - 1; k++) {
				outputStream.write(revEvery.get(k));
				outputStream.write("\n");
			}

		} catch (Exception e) {
			System.out.println("File Not Found");
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}
}