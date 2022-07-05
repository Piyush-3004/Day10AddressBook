package com.blzAsg;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class AddressBook {
	String bookName;
	static ArrayList<Contact> contactDetails = new ArrayList<Contact>();
	static HashMap<String, ArrayList<Contact>> system = new HashMap();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// addContact();
		int op = 1;
		while (op != 0) {
			System.out.println("enter 0 to break , 1 to proceed");
			op = scanner.nextInt();
			if (op == 0)
				break;
			System.out.println("Enter 0 to Exit,1 to add new book & contact ,2 to view ,3 to edit ,4 to delete");
			int ch = scanner.nextInt();
			switch (ch) {
			case 1:
				addNewBook();
				break;
			case 2:
				viewContact();
				break;
			case 3:
				editContact(contactDetails);
				break;
			case 4:
				AddressBook.deleteContact(contactDetails);
			}
		}
	}

	public static void addNewBook() {
		Scanner scanner = new Scanner(System.in);
		int op = 1;
		while (op != 0) {
			System.out.println("Enter 1 to add new book or update existing book, 0 to exit");
			op = scanner.nextInt();
			if (op != 0) {
				addNewContact();
			}

//		addBook1.contactDetails.add(new Contact());
		}
	}

	static void deleteContact(ArrayList<Contact> contactDetails) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name to delete the info");
		String name = scanner.next();
		for (int i = 0; i < contactDetails.size(); i++) {
			System.out.println(contactDetails.get(i).first_Name);

			if (contactDetails.get(i).first_Name.equals(name)) {
				contactDetails.remove(contactDetails.get(i));
			}
		}
	}

	static void editContact(ArrayList<Contact> contactDetails) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name to update the info");
		String name = scanner.next();
		for (int i = 0; i < contactDetails.size(); i++) {
			System.out.println(contactDetails.get(i).first_Name);

			if (contactDetails.get(i).first_Name.equals(name)) {

				System.out.println(
						"Enter 1 to change firstname , 2 to chnage lastname , 3 to change address , 4 to change City \n 5 tochange state, 6 to change zipcode , 7 to change obilenumber , 8 to change Email.");
				int op = scanner.nextInt();
				switch (op) {
				case 1:
					System.out.println("Enter new name");
					String newName = scanner.next();
					contactDetails.get(i).first_Name = newName;
					break;
				case 2:
					String newLastName = scanner.next();
					contactDetails.get(i).last_Name = newLastName;
					break;
				case 3:
					String newAddress = scanner.next();
					contactDetails.get(i).address = newAddress;
					break;
				case 4:
					String newCity = scanner.next();
					contactDetails.get(i).city = newCity;
					break;
				case 5:
					String newState = scanner.next();
					contactDetails.get(i).state = newState;
					break;
				case 6:
					int newZipCode = scanner.nextInt();
					contactDetails.get(i).zip_Code = newZipCode;
					break;
				case 7:
					int newPhoneNumber = scanner.nextInt();
					contactDetails.get(i).phone_Number = newPhoneNumber;
					break;
				case 8:
					String newEmail = scanner.next();
					contactDetails.get(i).email = newEmail;
					break;
				}
			}
		}
	}

	static void addNewContact() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Name : ");
		String firstName = scanner.next();
		System.out.println("Enter Last Name : ");
		String lastName = scanner.next();
		System.out.println("Enter Address : ");
		String address = scanner.next();
		System.out.println("Enter City : ");
		String city = scanner.next();
		System.out.println("Enter State : ");
		String state = scanner.next();
		System.out.println("Enter ZipCode : ");
		int zipCode = scanner.nextInt();
		System.out.println("Enter Mobile Number : ");
		long phonenumber = scanner.nextLong();
		System.out.println("Enter EmailId : ");
		String emailId = scanner.next();
		AddressBook addBook1 = new AddressBook();
		ArrayList<Contact> contactDetails = new ArrayList<Contact>();
		System.out.println("enter book name");
		String bn = scanner.next();

		addBook1.contactDetails
				.add(new Contact(firstName, lastName, address, city, state, zipCode, phonenumber, emailId));
		if (system.containsKey(bn)) {
			contactDetails = system.get(bn);
			addBook1.contactDetails
					.add(new Contact(firstName, lastName, address, city, state, zipCode, phonenumber, emailId));
		} else {
			system.put(addBook1.bookName = bn, addBook1.contactDetails);
		}
	}

	static void addContact() {
		AddressBook addBook = new AddressBook();
		addBook.bookName = "book0";
		addBook.contactDetails.add(new Contact("Pyush", "Patil", "Nashik", "Nashik", "Maharashtra", 422001, 901155747,
				"piyushp@gmail.com"));
		system.put(addBook.bookName, addBook.contactDetails);

	}

	static void viewContact() {
		Set<String> bookNames = system.keySet();
		for (String book : bookNames) {
			System.out.println("Name: " + book);
			System.out.println(system.get(book));
		}
//		for (int i = 0; i < contactDetails.size(); i++) {
//			System.out.println(contactDetails.get(i));
//		}
	}
}
