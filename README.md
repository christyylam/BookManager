# My Book Manager Application

## Keep track of all the books you've read!

Some features:
- Organize books by genre
- Lists all books in collection by the same author
- Lets users visualize their book collection
- Keeps track of user's ratings and reviews for each book
- Lets users enter reviews for each book added

This application will help users keep track of the books that they
have read by visualizing their entire collection, keeping track of their reviews and ratings for each book,
and allowing users to organize books by the genre or author. This application is for anyone who enjoys reading. 

This project is of interest to me because I enjoy reading as a hobby. I want an
application to refer to where I can see the books that I have read and what I thought about them, since I usually 
start forgetting as time passes.

## User Stories

As a user, I want to be able to:
- Add a book (name, author, rating, review) to my collection
- View a list of books (the title and author) in my collection
- Select a book in my collection and rate it on a scale of 0 to 5
- Select a book in my collection and view my rating and review in detail

- Save my book collection to file
- Load my book collection from file

## Phase 4: Task 2
I have chosen to implement a class in my model package (Book) that is robust.
The methods I have made robust are the Book constructor and the setRating method.

## Phase 4: Task 3
If I had more time to work on the project, I think I would have made the Book field in the ViewBookCollectionPanel class 
a private field and used a getter to access it instead.
I think I would also refactor my actionPerformed method in my AddBookPanel class because it is quite long and it would be easier 
to read/ easier to add more functionality to in the future if it was split into more helper methods.