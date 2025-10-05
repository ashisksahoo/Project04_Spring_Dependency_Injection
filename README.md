# Spring Dependency Injection Project

A Java Spring Framework demonstration project that showcases Dependency Injection (DI) and Inversion of Control (IoC) concepts using XML-based configuration. This project provides practical examples of how Spring manages object dependencies and bean lifecycles.

## 📋 Project Overview

This project demonstrates core Spring Framework concepts including:
- **Dependency Injection (DI)**: Automatic injection of dependent objects
- **Inversion of Control (IoC)**: Framework-managed object creation and lifecycle
- **XML Configuration**: Spring bean configuration using `spring.xml`
- **Bean Management**: Creating and managing Spring beans
- **Setter & Constructor Injection**: Both injection types demonstrated

The project uses a Library-Book relationship to illustrate dependency injection patterns in a practical context.

## 🎯 Key Concepts Demonstrated

### Dependency Injection (DI)
Dependency Injection is a design pattern where objects receive their dependencies from external sources rather than creating them internally. Spring Framework manages these dependencies automatically.

### Inversion of Control (IoC)
Instead of the application controlling object creation, Spring's IoC container manages the complete lifecycle of objects (beans), including instantiation, configuration, and dependency resolution.

## 🛠️ Technologies Used

- **Java**: Core programming language (JDK 8+)
- **Spring Framework**: IoC container and dependency injection
- **Spring Core**: Core container features
- **Spring Context**: ApplicationContext for bean management
- **XML Configuration**: Bean definitions and wiring

## 📁 Project Structure

```
Project04_Spring_Dependency_Injection/
├── .settings/              # IDE configuration files
├── bin/                    # Compiled class files
├── lib/                    # Spring Framework JAR files
│   ├── spring-core.jar
│   ├── spring-context.jar
│   ├── spring-beans.jar
│   ├── commons-logging.jar
│   └── other dependencies...
├── src/
│   ├── com/techpalle/
│   │   ├── controller/
│   │   │   └── LibraryController.java  # Main controller class
│   │   └── model/
│   │       ├── BookIndependent.java    # Book entity
│   │       └── LibraryDependent.java   # Library entity with dependency
│   └── spring.xml          # Spring configuration file
├── .classpath              # Java classpath configuration
└── .project                # Project configuration
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Spring Framework 5.x or higher
- IDE (Eclipse, IntelliJ IDEA, or similar)

### Required Spring Dependencies

Download and add the following JAR files to your `lib/` folder:

**Core Dependencies:**
- `spring-core-5.x.x.jar`
- `spring-context-5.x.x.jar`
- `spring-beans-5.x.x.jar`
- `spring-expression-5.x.x.jar`
- `commons-logging-1.x.x.jar`

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/ashisksahoo/Project04_Spring_Dependency_Injection.git
   cd Project04_Spring_Dependency_Injection
   ```

2. **Add Spring Framework Libraries**
   - Download Spring Framework from [spring.io](https://spring.io/projects/spring-framework)
   - Place all required JAR files in the `lib/` folder
   - Add them to your project's build path

3. **Configure Spring XML**
   
   The `spring.xml` file should be in the `src/` folder:
   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd">
       
       <!-- Book Bean Definition -->
       <bean id="library" class="com.techpalle.model.BookIndependent">
           <property name="section_no" value="101"/>
           <property name="section_code" value="CS"/>
           <property name="section_name" value="Computer Science"/>
           <property name="eBook" value="true"/>
           <property name="eBook_name" value="Java Programming"/>
           <property name="author" value="James Gosling"/>
           <property name="publisher" value="Tech Publications"/>
           <property name="subject" value="Programming"/>
           <property name="price" value="499.99"/>
       </bean>
       
       <!-- Library Bean with Dependency Injection -->
       <bean id="libraryDependent" class="com.techpalle.model.LibraryDependent">
           <property name="ld" ref="library"/>
       </bean>
       
   </beans>
   ```

4. **Compile and Run**
   ```bash
   javac -d bin -cp "lib/*" src/com/techpalle/**/*.java
   java -cp "bin:lib/*" com.techpalle.controller.LibraryController
   ```

## 💻 Code Examples

### Model Classes

**BookIndependent.java (Independent Bean)**
```java
package com.techpalle.model;

public class BookIndependent {
    private int section_no;
    private String section_code;
    private String section_name;
    private boolean eBook;
    private String eBook_name;
    private String author;
    private String publisher;
    private String subject;
    private double price;
    
    // Getters and setters for all properties
    
    @Override
    public String toString() {
        return "Book Details: " + section_name + " - " + eBook_name;
    }
}
```

**LibraryDependent.java (Dependent Bean)**
```java
package com.techpalle.model;

public class LibraryDependent {
    private BookIndependent ld; // Dependency
    
    // Setter injection
    public void setLd(BookIndependent ld) {
        this.ld = ld;
    }
    
    public BookIndependent getLd() {
        return ld;
    }
}
```

### Controller Class

**LibraryController.java**
```java
package com.techpalle.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.techpalle.model.LibraryDependent;

public class LibraryController {
    public static void main(String[] args) {
        // Load Spring configuration
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        
        // Get bean from Spring container
        LibraryDependent ld = (LibraryDependent) ac.getBean("library");
        
        // Access injected properties
        System.out.println(ld.getSection_no());
        System.out.println(ld.getSection_code());
        System.out.println(ld.getSection_name());
        System.out.println(ld.getBook().getBook_no());
        System.out.println(ld.getBook().getBook_name());
        System.out.println(ld.getBook().getAuthor());
        System.out.println(ld.getBook().getPublisher());
        System.out.println(ld.getBook().getSubject());
        System.out.println(ld.getBook().getPrice());
    }
}
```

## 🏗️ Dependency Injection Types

### 1. Setter Injection
Dependencies are injected through setter methods:
```xml
<bean id="library" class="com.techpalle.model.LibraryDependent">
    <property name="ld" ref="bookBean"/>
</bean>
```

### 2. Constructor Injection
Dependencies are injected through constructor:
```xml
<bean id="library" class="com.techpalle.model.LibraryDependent">
    <constructor-arg ref="bookBean"/>
</bean>
```

## 📊 Bean Lifecycle

```
1. Bean Definition (XML Configuration)
   ↓
2. Bean Instantiation (Spring Container)
   ↓
3. Dependency Injection (Setter/Constructor)
   ↓
4. Bean Initialization (Post-construct)
   ↓
5. Bean Ready for Use
   ↓
6. Bean Destruction (Pre-destroy)
```

## 🎓 Learning Outcomes

After studying this project, you will understand:

- ✅ How Spring IoC container works
- ✅ Difference between tight coupling and loose coupling
- ✅ How to configure beans using XML
- ✅ Setter vs Constructor injection
- ✅ ApplicationContext and BeanFactory
- ✅ Bean scopes and lifecycle
- ✅ Dependency management in Spring

## 🔑 Key Spring Concepts

### ApplicationContext
The `ApplicationContext` is Spring's IoC container responsible for:
- Bean instantiation
- Configuration management
- Dependency injection
- Bean lifecycle management

### Bean Scopes
- **Singleton** (default): One instance per Spring container
- **Prototype**: New instance for each request
- **Request**: One instance per HTTP request
- **Session**: One instance per HTTP session

## 🆚 Comparison: Traditional vs Spring DI

| Aspect | Traditional Approach | Spring DI |
|--------|---------------------|-----------|
| Object Creation | Manual (`new` keyword) | Spring Container |
| Dependency Management | Developer responsibility | Spring Framework |
| Coupling | Tight coupling | Loose coupling |
| Testing | Difficult | Easy (mock injection) |
| Configuration | Hard-coded | External (XML/Annotations) |
| Flexibility | Low | High |

## 📝 Best Practices

- ✅ Use meaningful bean IDs
- ✅ Prefer constructor injection for mandatory dependencies
- ✅ Use setter injection for optional dependencies
- ✅ Keep XML configuration organized
- ✅ Use property placeholders for external values
- ✅ Follow naming conventions
- ✅ Document bean dependencies

## 🔧 Configuration Options

### XML-based Configuration
```xml
<bean id="beanId" class="com.example.ClassName">
    <property name="propertyName" value="propertyValue"/>
    <property name="dependency" ref="otherBean"/>
</bean>
```

### Annotation-based Configuration (Alternative)
```java
@Component
public class MyClass {
    @Autowired
    private Dependency dependency;
}
```

## 🚀 Running the Application

### Using IDE (Eclipse)
1. Import project into Eclipse
2. Add Spring libraries to build path
3. Right-click on `LibraryController.java`
4. Select "Run As" → "Java Application"

### Using Command Line
```bash
# Compile
javac -d bin -cp "lib/*" src/com/techpalle/**/*.java

# Run
java -cp "bin:lib/*" com.techpalle.controller.LibraryController
```

### Expected Output
```
101
CS
Computer Science
1001
Java Programming
James Gosling
Tech Publications
Programming
499.99
```

## 🐛 Troubleshooting

### Common Issues

**Issue**: `NoClassDefFoundError: org/springframework/context/ApplicationContext`
- **Solution**: Ensure all Spring Core JAR files are in the classpath

**Issue**: `FileNotFoundException: class path resource [spring.xml] cannot be opened`
- **Solution**: Place `spring.xml` in the `src/` folder at the root level

**Issue**: `NoSuchBeanDefinitionException`
- **Solution**: Verify bean ID in XML matches the ID used in `getBean()`

**Issue**: `BeanCreationException`
- **Solution**: Check for circular dependencies or missing setter methods

## 🤝 Contributing

Contributions are welcome! To contribute:

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📚 Additional Resources

- [Spring Framework Official Documentation](https://docs.spring.io/spring-framework/docs/current/reference/html/)
- [Spring IoC Container](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans)
- [Dependency Injection Guide](https://www.baeldung.com/spring-dependency-injection)
- [Spring Bean Scopes](https://www.baeldung.com/spring-bean-scopes)

## 📝 Future Enhancements

- [ ] Add annotation-based configuration examples
- [ ] Implement Java-based configuration
- [ ] Add unit tests with Mockito
- [ ] Demonstrate bean scopes (singleton, prototype)
- [ ] Add AOP (Aspect-Oriented Programming) examples
- [ ] Implement Spring Boot migration guide
- [ ] Add multiple bean configuration examples
- [ ] Demonstrate circular dependency resolution

## 📄 License

This project is open source and available for educational purposes.

## 👤 Author

**Ashisk Sahoo**
- GitHub: [@ashisksahoo](https://github.com/ashisksahoo)

## 🙏 Acknowledgments

- Tech Palle for Spring Framework training
- Spring Framework documentation and community
- Java dependency injection patterns

## 📧 Support

For questions or issues:
- Open an issue in the GitHub repository
- Contact the author through GitHub

---

**Note**: This is an educational project demonstrating Spring Framework's core concepts: Dependency Injection and Inversion of Control. It serves as a foundation for understanding how modern Spring applications manage dependencies and object lifecycles.
