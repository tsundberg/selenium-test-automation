# Selenium WebDriver, test automation for web applications

A getting started project for the course Selenium WebDriver, test automation for web applications

It contains a Maven project and a Gradle project.

## Development environment

### Java

You must have Java installed. The recommended version is Java 8.
Download it from Oracle [http://www.oracle.com/technetwork/java/javase/downloads/index.html](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
and install it.

### IntelliJ IDEA

The recommended development environment is IntelliJ IDEA. The community version 
is more then enough for this course.

Download it from Jet BRAINS [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/) 
and install it.

Then open up the preferred build script, Maven or Gradle, and start doing the exercises. 

If you have tools like Eclipse or NetBeans installed and are comfortable to use them, then 
feel free to do so. Unfortunately, do not expect Thomas to be able to help you 
to get the sample projects working. He doesn't know anything about either Eclipse or NetBeans.

## Build tools

Build tools are strictly not needed, but hey simplifies getting started so you should use one. 
Use Gradle or Maven. Gradle is easier to get started with, but somewhat slower. 
Maven is more complicated to get started with, it must be installed locally, but is faster. 

You can use any of them, the end result is the same.

### Gradle

Build the project using 

```
./gradlew test
```

from a command line prompt.

Gradle doesn't have to be installed for this to work. A Gradle version will be downloaded and installed when you run `gradlew`. 

### Maven

Build the project using 

```
mvn test
```

from a command line prompt.

Maven must be installed for this to work. Maven can be downloaded from [http://maven.apache.org/download.cgi](http://maven.apache.org/download.cgi).

## Examples

You will work with a web application that you can run local. You can also 
connect to an online version at [http://selenium.thinkcode.se](http://selenium.thinkcode.se) 
and use it. The online version will be slower. Running it on your local host is 
the recommended way.

## References

* Selenium - [http://www.seleniumhq.org/](http://www.seleniumhq.org/)
* Gradle - [http://gradle.org/](http://gradle.org/)
* Maven - [http://maven.apache.org/](http://maven.apache.org/)
