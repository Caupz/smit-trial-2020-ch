# SMIT Sample Work 2020

- App of library's RestAPI which helps to manage books and it's lenders.
- Database with some sample data is in db_dump.sql file. I used MariaDB for Database Server.

# Install instructions
1. Git clone
2. Install Gradle if you haven't got it already
3. Build
4. After running is finished its process go to http://localhost:8080

# Actions
CAPS LOCKED texts are meant to be replaced by values you want to provide for the actions.

1. http://localhost:8080/getLibrarySummary
2. http://localhost:8080/searchBookByName/NAME_VALUE
3. http://localhost:8080/addUser/EMAIL_VALUE/PASSWORD/FIRSTNAME/LASTNAME/SSN
4. http://localhost:8080/getLateLenders
5. http://localhost:8080/searchBookLender/PERSON_NAME_VALUE
6. http://localhost:8080/receiveBook/BOOK_ID/USER_ID
7. http://localhost:8080/lendBook/USER_ID

# Closing words

I didn't have much experience with Java before. Only had experience when a friend asked me to fix some minor bugs or 1 course in school which only covered the basics (vars, classes, objects, functions, etc). I know the naming convention is kind of clumsy, but I'm not familiar with Java's elements. Lots of things could've been done better if would've had more time because most of it went for studying the exams.  
  
Everything I couldn't do is documented in issues.
