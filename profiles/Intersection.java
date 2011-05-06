import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class Intersection {

	public static void main(String[] args) {
		try {
			Set<String> file1 = loadFile(args[0]);
			Set<String> file2 = loadFile(args[1]);
			for (String item : file1) {
				if (file2.contains(item)) {
					System.out.println(item);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace(System.err);
		}
	}
	
	private static Set<String> loadFile(String path) throws IOException {
		Scanner in = new Scanner(new File(path));
		Set<String> content = new TreeSet<String>();
		while(in.hasNext()) {
			content.add(in.next());
		}
		return content;
	}
	
}
