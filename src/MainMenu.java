import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.zubiri.user.*;

public class MainMenu {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Users users = new Users();

		File dataFile = new File("src/usersData.txt");

		Scanner fileReader = new Scanner(dataFile);

		while (fileReader.hasNextLine()) {

			String[] separatedWords = fileReader.nextLine().split("::");

			User user = new User();

			if (user.setName(separatedWords[0]) && user.setPassword(separatedWords[1]))

				users.setUser(user);

		}

		Scanner sc = new Scanner(System.in);

		boolean logged = false;
		boolean finish = false;

		while (!finish) {

			System.out.println("Welcome to the log in / register aplication\n" + "What do you want to do?\n"
					+ "\t1- Register\n" + "\t2- Situation\n" + "\t3- Log In\n" + "\t4- Log Out\n" + "\t5- Finish");

			int option = sc.nextInt();
			sc.nextLine();

			switch (option) {

			case 1:

				
				System.out.println("Please enter the username and password");
				String[] separatedWords = sc.nextLine().split(" ");

				User user = new User();

				if (user.setName(separatedWords[0]) && user.setPassword(separatedWords[1])) {
					
					
					System.out.println("Succesfully registered");

					users.setUser(user);
				}
				

				break;

			case 2:

				break;

			case 3:

				System.out.println("Enter the username:");

				String usernameToFind = sc.nextLine();

				User user1 = users.getUser(usernameToFind);

				System.out.println("Enter the password:");

				String passwordToFind = sc.nextLine();

				if (user1.getPassword().matches(passwordToFind)) {

					System.out.println("You are now logged in as " + user1.getName());

					logged = true;
				}

				else {

					System.out.println("Incorrect password.");

				}

				break;

			case 4:

				logged = false;

				System.out.println("You have logged out");

				break;

			case 5:

				finish = true;

				break;

			}

		}

	}

}
