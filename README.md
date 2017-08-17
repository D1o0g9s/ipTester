IpTester is an inaccurately named project that gets the user's public IP
address by scraping whatismyipaddress.com. 

USAGE: 
	0. Download htmlunit-2.23-OSGi.jar from  
		https://sourceforge.net/projects/htmlunit/files/htmlunit/2.23/   
		Note: this is not the most recent version of the library. Still  
		need to figure out how to make this compatible with the latest  
		release.  
		  
[Command Line Linux]  
	1. Clone ipTester from github and copy in the htmlunit-2.23-OSGi.jar  
		you downloaded from sourceforge.  
	2. cd into project folder from command line  
	3. Compile java code: javac -cp ./htmlunit-2.23-OSGi.jar:. IpTester.java  
	4. Run main: java -cp ./htmlunit-2.23-OSGi.jar:. IpTester  
	5. Wait until program terminates. It takes a while (>20 sec on my  
		computer) to get the html unit page.  
  
[Sample Command Line Usage + Output (# represents a digit)]  
$ javac -cp ./htmlunit-2.23-OSGi.jar:. IpTester.java  
$ java -cp ./htmlunit-2.23-OSGi.jar:. IpTester  
##.###.###.###  
  
  
[IDE]  
	1. Create a new project in your IDE with default package
	2. Clone ipTester and copy IpTester.java into the project src folder
	3. Include htmlunit-2.23-OSGi.jar to the library dependencies of the 
		project. This tells the program where to find the .jar file
		we need the dependencies from - if you move the .jar file
		in your computer, be sure to update this so the program can
		find the dependencies. 
	4. Press play!
	5. Wait until program terminates. It takes a while (>20 sec on my 
		computer) to get the html unit page. 

[Sample NetBeans Output [# represents a digit)]
run: 
##.###.###.###
BUILD SUCCESSFUL (total time: 28 seconds)



Last Updated: August 16, 2017
	

