# Task Manager

A simple task management application written in Java. This project is under active development and will be updated with new features in the future.

## Features

- **Create Tasks**: Add new tasks to your list.
- **Delete Tasks**: Remove tasks you no longer need.
- **View Tasks**: Display all tasks in a tabular format.
- **Save to JSON**: Persist tasks to a JSON file using the Gson library.
- **Load from JSON**: Restore tasks from a previously saved JSON file.

## Technologies Used

- **Java**: Core programming language.
- **Gson**: A library for JSON serialization and deserialization (licensed under Apache 2.0).

## Planned Features

- Integration with a database for persistent storage.
- Implementation of the Spring framework for enhanced functionality and structure.

## Prerequisites

- **Java**: Version 8 or higher.
- **Maven**: Recommended for dependency management (optional if using JAR manually).
- **Gson**: Required for JSON functionality.

## Installation

### Option 1: Using Maven (Recommended)

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/asdfaw021/taskmanager.git
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd taskmanager
   ```
3. **Install Dependencies**:
   Ensure you have a `pom.xml` file with the Gson dependency (see below). Then run:
   ```bash
   mvn clean install
   ```
4. **Run the Application**:
   ```bash
   mvn exec:java -Dexec.mainClass="your.package.Main"
   ```
   *(Replace `your.package.Main` with the actual main class path.)*

#### Sample `pom.xml`
```xml
<project>
    <modelVersion>4.0.0</modelVersion>
    <groupId>com.example</groupId>
    <artifactId>taskmanager</artifactId>
    <version>1.0-SNAPSHOT</version>
    <dependencies>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.10.1</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>
```

### Option 2: Manual JAR Setup

1. **Download Gson**:
   Download the Gson JAR file from [Maven Central](https://repo1.maven.org/maven2/com/google/code/gson/gson/2.10.1/gson-2.10.1.jar).
2. **Clone the Repository**:
   ```bash
   git clone https://github.com/asdfaw021/taskmanager.git
   ```
3. **Navigate to the Project Directory**:
   ```bash
   cd taskmanager
   ```
4. **Compile with Gson**:
   Place the `gson-2.10.1.jar` in a `lib` folder within the project, then compile:
   ```bash
   javac -cp "lib/gson-2.10.1.jar" *.java
   ```
5. **Run the Application**:
   ```bash
   java -cp ".;lib/gson-2.10.1.jar" your.package.Main
   ```
   *(On Unix-like systems, use `:` instead of `;` in the classpath. Replace `your.package.Main` with the actual main class.)*

## Usage

- Launch the application using one of the methods above.
- Use the interface to add, delete, or view tasks.
- Save your tasks to a JSON file or load them from an existing file.

## Dependencies

- **[Gson](https://github.com/google/gson)**: Included for JSON handling. Licensed under the [Apache 2.0 License](https://www.apache.org/licenses/LICENSE-2.0).

## License

This project is licensed under the GNU General Public License v3.0. See the [LICENSE](LICENSE) file for details.

## Contributing

Contributions are welcome! Feel free to submit a pull request or open an issue for suggestions, bug reports, or feature requests.

## Contact

For questions or feedback, reach out via GitHub Issues.

---

*Last Updated: April 05, 2025*
