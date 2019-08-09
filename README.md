Extracting contents of a website and prepare its information to be uploaded to a new platform.


Installation 
1. Create a database connection.
2. Run the sql file in the database directory to create the appropiate table.
3. Run the Main Java application under package base22.contentcrawler.main
4. Enter the desired file on the console, attached to the project is file: text.txt to run.
5. Each url strings completed by the application will appear line by line on the console.
6. The console will print where to find the ouput file. 

Data Module Detail
1. id: Serial number pertaining to each record
2. url: Input URL from the file
3. title: Title of the web page extracted
4. body: Body contents of the web page extracted
5. links: Any links and its description found on the web page extracted

Functionality
1. Capability of key-in a file name on the console to run
2. Reading in a .txt file of url's into the application to be extracted
3. Each url running through the application will appear on the console once completed
4. A message alerting the application has completed with output file name and location path
5. An output .csv file containing url entered, title, body, and links of each web page.

Testing
1. Validate each content extracted from the web page entered correctly in the database
2. Printed critical points of the application to ensure validity
3. Validate file inserted into the application

