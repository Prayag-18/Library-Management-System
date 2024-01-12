# Library-Management-System

My Library Management Code contains 4 classes namely: 
1 class Main
2 class Librarian
3 class Members
4 class Books

The code starts by passing an integer input (1,2 or 3) :

If input is 1:

We make object libran of class Librarian to access functions used for Librarian.
Then, we take a lib_input (1 to 7) in a while loop and using switch we navigate to use the functions to do the work of librarian.

If input is 2:

We are still using object libran of class Librarian to access functions used for Member.
Then, we take a inputs of Membername and Memberid(in my Mobile No of member is the Unique ID). After this we check if the Member is registered or not.
If Member is registered, then we proceed by taking another input to choose which function for Member to be performed via switch. We are calling our Member functions in the Librarian class.


# We have used Librarian class to perform functions for both the librarian and any Member because list of objects books and members have been defined in the Librarian class.

# class Members contains attributes of members object:
1 Name
2 Age
3 Mobile_No
4 BookCount
  $ book1 and book2 objects of class Books have been initialized to null to keep track of books borrowed and returned by member at any instant.
  $ fine_of_member_for_book1 and fine_of_member_for_book2 are initialized equal to 0 and keep track of fines for book1 and book2 and Totalfine is sum of fine of book1 and book2.

# class Books contains attributes of books object:
1 Title
2 Author
3 Totalcopies
4 BookID
5 availablecopies
6 time1
7 time2

If input is 3:
We exit the Library.

Else for any other input:
It is Invalid and code asks to do the process again.
