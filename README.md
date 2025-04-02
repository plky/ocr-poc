# Java Tesseract OCR
This project demonstrates how to use the Tesseract OCR (Optical Character Recognition) engine with Java for extracting text from images and scanned documents. Tesseract is an open-source OCR engine that supports multiple languages and works across various platforms.

## Features
- Extract text from images (e.g., PNG, JPG, TIFF).
- Support for multiple languages (over 100 languages).
- Simple integration with Java.

## Prerequisites
To run the Java project, you will need to have the following installed:

- Tesseract OCR: [Installation Guide](https://github.com/tesseract-ocr/tesseract/wiki)
- Java (JDK 8 or higher).
- Maven (optional, for dependency management).

## Installation
### Step 1: Install Tesseract OCR
Windows: Download the installer from the [Tesseract official GitHub releases page](https://github.com/tesseract-ocr/tesseract/releases).

MacOS: Use Homebrew to install Tesseract:
```
brew install tesseract
```

Linux (Ubuntu/Debian):
```
sudo apt install tesseract-ocr
```

### Step 2: Set Up Java Project
You can either use Maven or manually download the necessary libraries.

#### Using Maven
Add the following dependency to your pom.xml:
```
<dependency>
    <groupId>net.sourceforge.tess4j</groupId>
    <artifactId>tess4j</artifactId>
    <version>4.5.1</version>
</dependency>
```

#### Manual Setup
Download the JAR file for Tess4J, which is a Java wrapper for the Tesseract OCR engine, from the [Tess4J GitHub page](https://github.com/nguyenq/tess4j) or Maven repository.

Make sure you add the JAR to your project’s classpath.

### Step 3: Set Tesseract Path
In your Java code, you need to set the path to the Tesseract executable. For example, on Windows:
```
System.setProperty("tessdata", "C:/Program Files/Tesseract-OCR/tessdata");
```

On Linux/Mac, this might not be necessary if Tesseract is in your system's PATH.
