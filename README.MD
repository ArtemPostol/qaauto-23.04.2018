## Steps to setup the work environment

1. Download **intellij idea** from [https://www.jetbrains.com/idea/download/#section=windows]
2. Download **jdk** from [http://www.oracle.com/technetwork/java/javase/downloads/index.html]
3. Run the **ideaIC.exe** file you have downloaded
4. Setup the **jdk-10.0.1_windows-x64_bin** whith default parameters
5. Download *Mozilla* from [https://www.mozilla.org/ru/firefox/new/]
6. Download **geckodriver** from [https://github.com/mozilla/geckodriver/releases]
7. Copy **geckodriver** to C:/Windows/System32/
8. Run **intellij idea** and create new project, in Project SDK choose jdk-10.0.1 from C:\Program Files\Java\jdk-10.0.1 
9. Setup selenium webdriver:
    [ <dependencies>
         <dependency>
             <groupId>org.seleniumhq.selenium</groupId>
             <artifactId>selenium-java</artifactId>
             <version>3.11.0</version>
         </dependency>
         </dependencies> ].



