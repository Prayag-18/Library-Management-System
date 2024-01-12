package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Librarian libran = new Librarian();
        boolean checker = true;
        while (checker) {
            System.out.println("Library Portal Initialized….\n" +
                    "---------------------------------\n" +
                    "1. Enter as a librarian\n" +
                    "2. Enter as a member\n" +
                    "3. Exit\n" +
                    "---------------------------------\n");
            Scanner SC = new Scanner(System.in);
            int input = SC.nextInt();
            SC.nextLine();

            if (input == 1) {
                boolean l = true;
                while(l){
                    System.out.println("---------------------------------\n" +
                            "1. Register a member\n" +
                            "2. Remove a member\n" +
                            "3. Add a book\n" +
                            "4. Remove a book\n" +
                            "5. View all members along with their books and fines to be paid\n" +
                            "6. View all books\n" +
                            "7. Back\n" +
                            "---------------------------------\n");
                    int lib_input = SC.nextInt();
                    switch (lib_input) {
                        case 1:
                            // Add Member
                            libran.AddMember();
                            break;
                        case 2:
                            // Remove Member
                            libran.RemoveMember();
                            break;
                        case 3:
                            // Add Book
                            libran.AddBook();
                            break;
                        case 4:
                            // Remove Book
                            libran.removeBook();
                            break;
                        case 5:
                            // Veiw all Memb and their books and their fines
                            libran.viewAllBooksAndOtherInfo();
                            break;
                        case 6:
                            // Show all Books
                            System.out.println("---------------------------------");
                            System.out.println("List of All Books :");
                            for (Books book : Librarian.books) {
                                if(book == null){
                                    continue;
                                }
                                if (book.remove == 0) {
                                    System.out.println("Book ID : " + book.BookID);
                                    System.out.println("Book Title : " + book.Title);
                                    System.out.println("Author : " + book.Author);
                                    System.out.println();
                                }
                            }
                            System.out.println("---------------------------------");
                            break;
                        case 7:
                            //Back      -> Main Menu pe jaana hai
                            l = false;
                            break;
                        default:
                            System.out.println("Invalid Input !!");
                            break;
                    }
                }
            }
            else if (input == 2) {
                Scanner sc2 = new Scanner(System.in);

                System.out.print("Name : ");
                String membername = sc2.nextLine();
                System.out.print("Mobile No : ");
                long memberid = sc2.nextLong();
                Members[] members = libran.members;
                int index_of_member = 0;
                int z =0;
                for (int i = 0; i < libran.no_of_members; i++) {
                    if (members[i].Mobile_No == memberid) {
                        z = 1;
                        index_of_member = i;
                        break;
                    }
                }
                if (z == 0) {
                    System.out.println("No member with name " + membername + " and id " + memberid);
                } else if (z == 1) {
                    System.out.println("Welcome "+ membername +"!");
                    System.out.println("---------------------------------\n" +
                            "1. List Available Books\n" +
                            "2. List My Books\n" +
                            "3. Issue book\n" +
                            "4. Return book\n" +
                            "5. Pay Fine\n" +
                            "6. Back\n" +
                            "---------------------------------\n");
                boolean l = true;
                while (l) {
                    int lib_input = SC.nextInt();
                    switch (lib_input) {
                        case 1:
                            libran.availableBooks();
                            break;
                        case 2:
                            libran.listMyBooks(index_of_member);
                            break;
                        case 3:
                            libran.IssueBook(index_of_member);
                            break;
                        case 4:
                            libran.bookReturn(index_of_member);
                            break;
                        case 5:
                            libran.payTotalFine(index_of_member);
                            break;
                        case 6:
                            //Back      -> Main Menu pe jaana hai
                            l = false;
                            break;
                        default:
                            System.out.println("Invalid Input !!");
                            break;
                    }
                }
            }
            }
            else if (input == 3) {
                checker = false;
                System.out.println("---------------------------------\n" +
                        "Thanks for visiting!\n" +
                        "---------------------------------\n");
            }
            else{
                System.out.println("Invalid Input !!");
                System.out.println("Please try again");
            }
        }
    }
}
