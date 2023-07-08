# algo
  For a given string that only contains alphabet characters a-z, if 3 or more consecutive 
characters are identical, remove them from the string. Repeat this process until 
there is no more than 3 identical characters sitting besides each other.
# installation
jdk11 
maven 3.5+

# project structure
--application  
   demo shows how to run the algo  
--data  
  generagte unit test cases  
--functioninterface  
  function interface (jdk8 feature)  
--sitbesides  
  algo to remove words sit besides  
--test  
  use a base implemention to  test and verify the final version of algo  
--util  
  a util class to afford help  
# class graph
![image](https://github.com/jinqiao627306162/algo/assets/35721902/3edcab4e-7df2-4457-b796-45aff70ac116)

SitBesidesAlgoTest is used for unit test
SitbesidesApplication is a demo to use RemoveSitbesidesByDoublePointer
RemoveSitbesidesByDoublePointer is the final algo 

# algo design
![image](https://github.com/jinqiao627306162/algo/assets/35721902/d10f0a78-a347-4fbb-b506-452c3e54f9af)






