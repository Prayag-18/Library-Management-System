package org.example;

import java.util.ArrayList;

public class Books {
    String Title;
    String Author;
    int Totalcopies;
    int BookID;
    int availablecopies;
    long time1;
    long time2;
    //public static ArrayList<Books> Booklist = new ArrayList<>();
    public boolean available = true;
    int remove = 0;
    // ----- Constructor -----
    Books(String Title, String Author, int BookID, int Totalcopies){
        this.Title = Title;
        this.Author = Author;
        this.Totalcopies = Totalcopies;
        this.BookID = BookID;
    }

    public String getTitle() {return Title;}
    public String getAuthor() {return Author;}
    public int getTotalcopies() {return Totalcopies;}
    public int getBookID() {return BookID;}
    public int getAvailablecopies() {return availablecopies;}

    public boolean isAvailable() {return availablecopies > 0;}
    boolean c = true;
    public boolean borrowBook() {
        if (availablecopies > 0) {
            availablecopies--;
            return c;                         // Book successfully borrowed
        } else {
            c = false;
            return c;                         // No available books
        }
    }
    public void start_time(){
        time1 = System.currentTimeMillis();
    }
    public long end_or_return_time(){
        long time3 = System.currentTimeMillis();
        long extratime = ((time2-time1-10000L) / 1000L);
        return extratime;
    }
    public long calculateamount(){
        long current_time = System.currentTimeMillis();
        long amount = (((current_time-time1)/1000L)-10L)*3L;
        return amount;
    }
    public void avail_bility(boolean available) {
        this.available = available;
    }
}
