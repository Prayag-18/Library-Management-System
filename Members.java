package org.example;
import java.util.Scanner;
public class Members {
    // Member (ph_no ,Name, Age, bookcount<2 )
    String Name;
    int Age;
    Long Mobile_No;
    static int BookCount;

    Members(String Name ,int Age,Long Mobile_No){
        this.Name = Name;
        this.Age = Age;
        this.Mobile_No = Mobile_No;
        this.BookCount = 0;
    }
    Books book1 = null;
    Books book2 = null;
    long fine_of_member_for_book1 = 0;
    long fine_of_member_for_book2 = 0;
    long Totalfine = 0;
    long fine =0;
    public void check_for_book(){
        if(book1 == null && book2 == null){
            fine = -1;
        }
        if(book1 != null && book2 == null) {
            fine = book1.calculateamount();
        }
        if(book1 == null && book2 != null) {
            fine = book2.calculateamount();
        }
        if(book1 != null && book2 != null) {
            fine += book1.calculateamount();
            fine += book2.calculateamount();
        }
    }
}
