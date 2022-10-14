# FakeNewsDetector

## Description
 This project has the goal of compare news, be it type by the user or a news article extract from https://g1.globo.com using web scrap, and the database of articles already classified as fake to find out if the text if from a fake news or not.
 For this purpose with explore text preprocessing methods for cleaning our data, web scrap to get different news from web automatically and two comparions algorithms, Jaro-Winkler distance and Cosine Similarity.


## Requirements
 - Java SE 17 ou mais recente.
 - JavaFX sdk18 ou mais recente.
 - Maven
  
## Compile and running.
Direct from Eclipse, use the right button on the main fold and select the export option, in options select java file and runnable JAR File, on launch select the main class, select the file path with the name and click finish. Now you have and .exe of this project and just need to opent it to run.

Like wise you can also run the project on eclipse itself by running the main class.

## Running the program
After opening the program the user can chose between typing his on news or use the search button to get a article from https://g1.globo.com, after that they must select a comparison method and click on the comparison button, after that a pop-up will show up saying if the new is fake or not.
