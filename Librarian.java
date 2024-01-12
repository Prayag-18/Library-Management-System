package org.example;
import javax.lang.model.type.NullType;
import java.util.*;
public class Librarian {
    int book_id = 0;
    static Members[] members = new Members[500];
    static Books[] books = new Books[500];
    int no_of_members = 0;
    //Books[] books = new Books[400];

    //public Books [] books = new Books[200];
    public void Library(){
        //books = new ArrayList<>();
        //members = new ArrayList<>();
        //List<String> borrowedBooks = new ArrayList<>();
        //Books [] books = new Books[200];

        Scanner scanner = new Scanner(System.in);
        boolean var = true;
        while(var){
            System.out.println("---------------------------------\n" +
                    "1. Register a member\n" +
                    "2. Remove a member\n" +
                    "3. Add a book\n" +
                    "4. Remove a book\n" +
                    "5. View all members along with their books and fines to be paid\n" +
                    "6. View all books\n" +
                    "7. Back\n" +
                    "---------------------------------\n");
            int lib_input = scanner.nextInt();

            switch (lib_input) {
                case 1:                                                          // Add Member
                    AddMember();
                    break;
                case 2:                                                          // Remove Member
                    RemoveMember();
                    break;
                case 3:                                                          // Add Book
                    AddBook();
                    break;
                case 4:                                                          // Remove Book
                    removeBook();
                    break;

                case 5:
                    // Veiw all Memb and their books and their fines
                    for (int i=0; i<no_of_members; i++){
                        System.out.println("Name :"+members[i].Name + ", Age : " + members[i].Age + ", Mobile_No : "+ members[i].Mobile_No);
                        if (members[i].book1 != null) System.out.println("Book1 :"+members[i].book1+", Fine on Book1 :"+members[i].fine_of_member_for_book1);
                        if (members[i].book2 != null) System.out.println("Book2 :"+members[i].book2+", Fine on Book1 :"+members[i].fine_of_member_for_book2);
                        System.out.println("Total Fine on Member : "+members[i].Totalfine);
                    }
                    break;
                case 6:                                                                      // Show all Books
                    System.out.println("---------------------------------");
                    System.out.println("List of All Books :");
                    for (Books book : books){
                        System.out.println("Book ID : "+book.BookID);
                        System.out.println("Book Title : "+book.Title);
                        System.out.println("Author : "+book.Author);
                        System.out.println();
                    }
                    System.out.println("---------------------------------");
                    break;
                case 7:
                    //Back      -> Main Menu pe jaana hai
                    var = false;
                    break;
                default:
                    System.out.println("Invalid Input !!");
                    break;
            }
        }
    }

    public void AddMember(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name : ");
        String Name = scanner.nextLine();
        System.out.print("Age : ");
        int Age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Mobile No : ");
        Long Mobile = scanner.nextLong();
        scanner.nextLine(); // Consume the newline character

        members[no_of_members] = new Members(Name,Age,Mobile);
        System.out.println("Member added successfully");
        no_of_members += 1;
    }

    public void RemoveMember(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Phone no of Member to be removed : ");
        long mobilno = sc.nextLong();
        int z = 0;
        for (int i = 0 ; i < no_of_members; i++){
            if(members[i].Mobile_No == mobilno){
                z = i;
                break;
            }
        }
        for(int j = z; z<(no_of_members-1); z++){
            members[z] = members[z+1];
        }
        no_of_members -= 1;
        System.out.println("member removed successfully");
    }
    public void AddBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Title: ");
        String title = sc.nextLine();
        System.out.print("Author: ");
        String author = sc.nextLine();
        System.out.print("Copies: ");
        int copies = sc.nextInt();
        for (int i = 0;i<copies; i++){
            books[book_id] = new Books(title, author, book_id, copies);
            book_id++;
        }
    }

    public void removeBook() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the BookID of Book to be removed : ");
        int id_of_book = sc.nextInt();
        books[id_of_book].remove = 1;
    }

    public void allMembers_Books_Fines(){
        for (int i=0; i<no_of_members; i++){
            System.out.println("Name :"+members[i].Name + ", Age : " + members[i].Age + ", Mobile_No : "+ members[i].Mobile_No);
            if (members[i].book1 != null) System.out.println("Book1 :"+members[i].book1+", Fine on Book1 :"+members[i].fine_of_member_for_book1);
            if (members[i].book2 != null) System.out.println("Book2 :"+members[i].book2+", Fine on Book1 :"+members[i].fine_of_member_for_book2);
            System.out.println("Total Fine on Member : "+members[i].Totalfine);
        }
    }
    public void viewallbooks() {
        for (Books b : books) {
            if (b == null) {
                break;
            }
            System.out.println("Book Id"+b.BookID);
            System.out.println("Title: "+b.Title);
            System.out.println("Book Id"+b.Author);
        }
    }
    public void IssueBook(int id_of_member) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Book Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        if (books[id].remove == 0) {
            System.out.print("Title: ");
            String name = sc.nextLine();
            members[id_of_member].check_for_book();
            long currentfine = members[id_of_member].fine;
            if (currentfine <= 0) {
                if (members[id_of_member].book1 == null) {
                    books[id].available = false;
                    books[id].start_time();
                    members[id_of_member].book1 = books[id];
                    books[id].remove = 1;
                    System.out.println("---------------------------------\n" +
                            "Book Issued Successfully!\n" +
                            "--------------------------------");
                } else if (members[id_of_member].book2 == null) {
                    books[id].available = false;
                    books[id].start_time();
                    members[id_of_member].book2 = books[id];
                    books[id].remove = 1;
                    System.out.println("---------------------------------\n" +
                            "Book Issued Successfully!\n" +
                            "--------------------------------");
                } else {
                    System.out.println("You have already borrowed 2 books.");
                }
            } else {
                System.out.println("First you have to pay the fine." + currentfine);
            }
        }
        else {
            System.out.println("Book with ID : "+ id + " is not available");
        }
    }

    public void viewAllBooksAndOtherInfo(){
        for (int i = 0 ; i < no_of_members; i++){
            System.out.println("Member_ID: "+members[i].Mobile_No);
            System.out.println("Name: "+members[i].Name);
            if(members[i].book1 != null){
                System.out.println("Issued Book:-");
                System.out.println("Book Title: "+members[i].book1.BookID);
                System.out.println("Book Title: "+members[i].book1.Title);
            }
            if(members[i].book2 != null){
                System.out.println("Issued Book:-");
                System.out.println("Book Title: "+members[i].book2.BookID);
                System.out.println("Book Title: "+members[i].book2.Title);
            }
            System.out.println("Total fine: "+members[i].Totalfine);
            System.out.println("---------------------");
        }
    }

    public void availableBooks(){
        for(int i = 0; i<book_id; i++){
            if(books[i].available && books[i].remove == 0){
                System.out.println("ID: "+books[i].BookID);
                System.out.println("Title : "+books[i].Title);
                System.out.println("Author: "+books[i].Author);
                System.out.println();
            }
        }
    }

    public void bookReturn(int index_of_meber){
        Scanner sc = new Scanner(System.in);
        long amount = 0;
        System.out.print("Enter BookID of book to be returned : ");
        int book_id = sc.nextInt();
        if(members[index_of_meber].book1 != null || members[index_of_meber].book2 != null){
            amount = books[book_id].calculateamount();
        }
        if(members[index_of_meber].book1 != null && books[book_id] == members[index_of_meber].book1){
            members[index_of_meber].fine_of_member_for_book1 = amount;
            books[book_id].available = true;
            members[index_of_meber].Totalfine += amount;
            members[index_of_meber].book1 = null;
            books[book_id].remove = 0;
            if(amount > 0){
                System.out.println("Book return successfully you have to pay the amount of "+amount);
            }
            else {
                System.out.println("Book return successfully!");
            }
        }
        if(members[index_of_meber].book2 != null && books[book_id] == members[index_of_meber].book2){
            members[index_of_meber].fine_of_member_for_book2 = amount;
            books[book_id].available = true;
            members[index_of_meber].Totalfine += amount;
            members[index_of_meber].book2 = null;
            books[book_id].remove = 0;
            if(amount > 0){
                System.out.println("Book return successfully you have to pay the amount of "+amount);
            }
            else {
                System.out.println("Book return successfully!");
            }
        }
    }
    public void payTotalFine(int index_of_member){
        if(members[index_of_member].Totalfine != 0 ){
            System.out.println("Fine of rupeess "+members[index_of_member].Totalfine +"paid successfully!");
            members[index_of_member].Totalfine = 0;
            members[index_of_member].fine_of_member_for_book1 = 0;
            members[index_of_member].fine_of_member_for_book2 = 0;
        }
    }

    public void listMyBooks(int index_of_members) {
        if(members[index_of_members].book1 != null) {
            System.out.println("Book ID : " + members[index_of_members].book1.BookID);
            System.out.println("Title : " + members[index_of_members].book1.Title);
            System.out.println("Author : " + members[index_of_members].book1.Author);
        }
        if(members[index_of_members].book2 != null) {
            System.out.println("Book ID : " + members[index_of_members].book2.BookID);
            System.out.println("Title : " + members[index_of_members].book2.Title);
            System.out.println("Author : " + members[index_of_members].book2.Author);
        }
        if(members[index_of_members].book1 == null && members[index_of_members].book2 == null) {
            System.out.println("You have not issued any book.");
        }
    }
}
