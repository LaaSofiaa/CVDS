# Laboratorio 03- TDD
*Integrantes:*

*-Jaider David Vargas Noriega.*

*-Laura Sofia Gil Chaves.*

## Desarrollo del laboratorio 03
### Crear un proyecto en Maven
La herramienta Maven nos ayuda a facilitar y optimizar procesos de desarrollo y hacerlos en el menor tiempo posible. Se creó un proyecto en Maven con los siguientes parámetros:
```yml
Grupo: edu.eci.cvds 
Artefacto: Library 
Paquete: edu.eci.cvds.tdd 
archetypeArtifactId: maven-archetype-quickstart 
```
![image](https://github.com/user-attachments/assets/b4cfe80f-44d9-452e-9b50-fdf71bbd7db7)
![image](https://github.com/user-attachments/assets/1e2c790f-a645-49c6-9839-17cd86d31dcc)
![image](https://github.com/user-attachments/assets/cbf455e5-6aa6-4174-81aa-1960a85a1c72)
### Agregar dependencia JUNIT5
Primero buscamos en maven central la dependencia de JUnit 5 en la versión más reciente. 
![image](https://github.com/user-attachments/assets/551b6bfe-c649-403e-82bf-50e6cd84aafe)
Luego, editamos el archivo pom.xml del proyecto para agregar la dependencia, verificando la versión de java.
![image](https://github.com/user-attachments/assets/82426c10-28b5-4bcf-99b9-4aad6f58d246)
### Agregar esqueleto del proyecto
Se crearon los siguientes paquetes dentro de```edu.eci.cvds.tdd``` en la carpeta src como en test.
![image](https://github.com/user-attachments/assets/0a326a5c-085a-4ad2-9ca4-0962727ab46f)

### Agregar clases 
En el paquete ```edu.eci.cvds.tdd.library``` se creó las siguientes clases.

![image](https://github.com/user-attachments/assets/6d8db0b4-d292-4da3-a7f4-b7ecbdea3e59)

```java
package edu.eci.cvds.tdd.library.book;
public class Book {
    private final String tittle;
    private final String author;
    private final String isbn;
    public Book(String tittle, String author, String isbn) {
        this.tittle = tittle;
        this.author = author;
        this.isbn = isbn;
    }
    public String getTittle() {
        return tittle;
    }
    public String getAuthor() {
        return author;
    }
    public String getIsbn() {
        return isbn;
    }
    @Override
    public boolean equals(Object obj) {
        return isbn.equals(((Book)obj).isbn);
    }
}
```
```java
package edu.eci.cvds.tdd.library.user;
public class User {
    private String name;
    private String id;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
```
```java
package edu.eci.cvds.tdd.library.loan;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.user.User;
import java.time.LocalDateTime;
public class Loan {
    private Book book;
    private User user;
    private LocalDateTime loanDate;
    private LoanStatus status;
    private LocalDateTime returnDate;
    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public LocalDateTime getLoanDate() {
        return loanDate;
    }
    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }
    public LoanStatus getStatus() {
        return status;
    }
    public void setStatus(LoanStatus status) {
        this.status = status;
    }
    public LocalDateTime getReturnDate() {
        return returnDate;
    }
    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }
}
```
```java
package edu.eci.cvds.tdd.library.loan;
public enum LoanStatus {
    ACTIVE, RETURNED
}
```
```java
package edu.eci.cvds.tdd.library;
import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.user.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Library responsible for manage the loans and the users.
 */
public class Library {
    private final List<User> users;
    private final Map<Book, Integer> books;
    private final List<Loan> loans;
    public Library() {
        users = new ArrayList<>();
        books = new HashMap<>();
        loans = new ArrayList<>();
    }
    /**
     * Adds a new {@link edu.eci.cvds.tdd.library.book.Book} into the system, the book is store in a Map that contains
     * the {@link edu.eci.cvds.tdd.library.book.Book} and the amount of books available, if the book already exist the
     * amount should increase by 1 and if the book is new the amount should be 1, this method returns true if the
     * operation is successful false otherwise.
     *
     * @param book The book to store in the map.
     *
     * @return true if the book was stored false otherwise.
     */
    public boolean addBook(Book book) {
        //TODO Implement the logic to add a new book into the map.
        return false;
    }
    /**
     * This method creates a new loan with for the User identify by the userId and the book identify by the isbn,
     * the loan should be store in the list of loans, to successfully create a loan is required to validate that the
     * book is available, that the user exist and the same user could not have a loan for the same book
     * {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE}, once these requirements are meet the amount of books is
     * decreased and the loan should be created with {@link edu.eci.cvds.tdd.library.loan.LoanStatus#ACTIVE} status and
     * the loan date should be the current date.
     *
     * @param userId id of the user.
     * @param isbn book identification.
     *
     * @return The new created loan.
     */
    public Loan loanABook(String userId, String isbn) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }
    /**
     * This method return a loan, meaning that the amount of books should be increased by 1, the status of the Loan
     * in the loan list should be {@link edu.eci.cvds.tdd.library.loan.LoanStatus#RETURNED} and the loan return
     * date should be the current date, validate that the loan exist.
     *
     * @param loan loan to return.
     *
     * @return the loan with the RETURNED status.
     */
    public Loan returnLoan(Loan loan) {
        //TODO Implement the login of loan a book to a user based on the UserId and the isbn.
        return null;
    }
    public boolean addUser(User user) {
        return users.add(user);
    }
}
```
Se compila con ```mvn package``` la estructura del proyecto.

![image](https://github.com/user-attachments/assets/e73d3718-456d-4e08-bc9f-a142df25ee83)

### Pruebas Unitarias y TDD- Crear Clase de Prueba
Para poder implementar los métodos ```addBook, loanABook y returnLoan``` de la clase ```Library``` se aplicó la técnica de TDD, por cada caso de prueba se hizo un commit. Todo esto se implementó en la clase de prueba LibraryTest.

### Pruebas Unitarias y TDD para addBook
Se realizan las pruebas para el método addBook, donde primero escribimos las pruebas unitarias antes de desarrollar el método en este caso ```shouldAddNewBook``` que válida si existe un libro.

![image](https://github.com/user-attachments/assets/42573889-3554-4ff4-bf96-57a6f6d3141e)

En este punto debería fallar la prueba porque aún no hay nada desarrollado en el método.

![image](https://github.com/user-attachments/assets/47be8a04-d2f0-47cb-97b8-8616e039e35b)

Se realiza el método para que funcionen la prueba unitaria.

![image](https://github.com/user-attachments/assets/83f55b64-f1cf-4e3c-934c-170cab2f1052)

Volvemos a ejecutar la prueba dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/f8168d0f-aedd-486e-a411-9da4bea5f91e)

Se realizan el mismo proceso para el punto anterior con ```should_AddNwBook_WhenNotExists``` que válida si no existe un libro.

![image](https://github.com/user-attachments/assets/1a1c3aa6-4e5d-4997-af09-da76f63b50fe)

En este punto debería fallar la prueba porque aún no se ha refactorizado 
 el método.

![image](https://github.com/user-attachments/assets/47be8a04-d2f0-47cb-97b8-8616e039e35b)

Se realiza el método para que funcionen la prueba unitaria.

![image](https://github.com/user-attachments/assets/da9536d7-cd52-4ae2-b031-0ce6b5d11d5f)

Volvemos a ejecutar las pruebas dando como resultado que son correctas.

![image](https://github.com/user-attachments/assets/7894a07a-bfa4-4a4b-b9e7-fd2f348e59fa)

Se realizan el mismo proceso para el punto anterior con ```should_IncreaseQuantity_WhenTheBookAlredyExists``` que agrega el mismo libro dos veces y luego verifica que la cantidad del libro en la biblioteca sea 2. En este caso, se deja la misma implemtación del código.

![image](https://github.com/user-attachments/assets/512b66ae-b41f-4d7c-94df-30d088a573b2)

![image](https://github.com/user-attachments/assets/bca7bfb9-08c2-4689-8c6d-b5a6cd74748e)

![image](https://github.com/user-attachments/assets/a0bb3d78-0385-4a4e-b2a2-d1dbd5eb9378)

Ahora con ```should_StartsWithOneBook_WhenIsNew``` que agrega un libro por primera vez a una biblioteca nueva, la cantidad del libro sea 1. En este caso, se deja la misma implemtación del código.

![image](https://github.com/user-attachments/assets/c61070bc-d51f-4689-9912-0a143cbf78fb)
![image](https://github.com/user-attachments/assets/f368513d-a328-4388-bbcc-104c9a0eb887)

Ahora con ```shouldNot_addBook_WhenItsNull``` que verifica que el método addBook no agregue un libro si el libro es null.

![image](https://github.com/user-attachments/assets/c0fe232a-2504-46a4-871e-f55ac978b3d3)
![image](https://github.com/user-attachments/assets/75332cb6-a9b0-4127-9d67-b535324ce35b)

Ahora con ```shouldNot_addBook_WhenItHasSameIsbnButDifferentNameOrAuthor``` que verifica que el método addBook no permita agregar un libro con el mismo ISBN que otro libro ya existente en la biblioteca, pero con un nombre o autor diferente.
Donde nos arroja error en la prueba unitaria.

![image](https://github.com/user-attachments/assets/e11f93ce-e89a-4b3a-b18c-940f63b0b674)

Refactorizamos el método nuevamente. 

![image](https://github.com/user-attachments/assets/714a01ca-9f21-4b10-8d04-1074ad3b2210)

Corremos nuevamente la prueba.

![image](https://github.com/user-attachments/assets/7c93b4b3-0315-4cbf-b41b-af56ed0976bf)

Ahora con ```shouldNot_addBook_WhenItHasEmptyOrNullIsbn``` que verifica que el método addBook no permita agregar un libro si el ISBN es nulo o está vacío. 
Donde nos arroja error en la prueba unitaria.

![image](https://github.com/user-attachments/assets/2f218a16-e6ad-4cd7-9654-63c70aa2cdaf)

Refactorizamos el método nuevamente. 

![image](https://github.com/user-attachments/assets/bf6e33e7-d29a-439f-872c-7cb6040c9741)

Corremos nuevamente la prueba.

![image](https://github.com/user-attachments/assets/fa013866-d171-4e25-920a-4978f10bbf2a)

### Pruebas Unitarias y TDD para loan
Se realizan las pruebas para el método loan,donde primero escribimos las pruebas unitarias antes de desarrollar el método en este caso ```should_loanABook_whenUserAndBookExists``` que verifica que un libro se pueda prestar correctamente cuando tanto el usuario como el libro existen en la biblioteca.

![image](https://github.com/user-attachments/assets/76df572b-7321-4cb7-b144-383d2787509f)

En este punto debería fallar la prueba porque aún no hay nada desarrollado en el método.

![image](https://github.com/user-attachments/assets/80ba905b-e767-45a3-be7a-703d99987dad)

Se realiza el método para que funcionen la prueba unitaria.

![image](https://github.com/user-attachments/assets/b5e2a925-7299-487e-9a05-275c56d2724e)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/9b48bc29-d516-4f4e-9252-771937ff0dd0)

Ahora con ```shouldNot_loanABook_whenUserOrBookIsNull``` que verifica que el sistema no permita prestar un libro cuando el usuario o el libro son null, , ```shouldNot_loanABook_whenBookNotExists``` que verifica que el sistema no permita prestar un libro si este no existe en la biblioteca y ```shouldNot_loanABook_whenUserNotExists``` que verifica que el sistema no permita prestar un libro a un usuario que no está registrado en la biblioteca.

![image](https://github.com/user-attachments/assets/d7e32234-0cb2-4d5c-89a0-30ceea972b4e)
![image](https://github.com/user-attachments/assets/e92f4f07-94aa-4b80-b786-a34bf3f3a913)

Dejamos la misma implementación del método.

![image](https://github.com/user-attachments/assets/b5e2a925-7299-487e-9a05-275c56d2724e)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/9b48bc29-d516-4f4e-9252-771937ff0dd0)

Ahora con ```shouldNot_loanABook_whenItIsUnavailable``` que verifica que el sistema no permita prestar un libro si este ya está prestado.

![image](https://github.com/user-attachments/assets/267252e5-6ef7-4f3a-b9d8-84b1086b12cb)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/3113f176-2243-417a-98dd-561f2dc28c59)

 Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/2f80bdb2-c03c-4009-b837-c10213378591)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/4232c23d-84e8-44b4-b437-2651b9e2f974)

Ahora con ```shouldNot_loanABook_whenTheUserAlreadyHasALoanForTheSameBook``` que verifica que el sistema no permita que un usuario solicite el mismo libro más de una vez

![image](https://github.com/user-attachments/assets/8c788e80-8637-40ef-a145-19d0ee15cc9b)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/64c1849d-5a6d-4712-acce-87615a1e6b6f)

 Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/693e2c58-1e09-44d5-88d3-7389134a4ece)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/51cf8010-6d9d-4ffe-afe6-e27592fee71f)

### Pruebas Unitarias y TDD para returnLoan
Se realizan las pruebas para el método returnLoan,donde primero escribimos las pruebas unitarias antes de desarrollar el método, en este caso ```should_returnALoan_whenTheLoanExists``` que verifica que el sistema devuelva correctamente un préstamo existente cuando se solicita.

![image](https://github.com/user-attachments/assets/2f9955d9-3b25-4de3-981f-29f978d17494)

En este punto debería fallar la prueba porque aún no hay nada desarrollado en el método.

![image](https://github.com/user-attachments/assets/a54216c0-1bc0-42fe-9907-71634301c4ad)

Se realiza el método para que funcionen la prueba unitaria.

![image](https://github.com/user-attachments/assets/89776371-2878-47ae-9463-c66c15f34ef5)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/38b9b59e-a07d-4376-a91d-cacbbfa12de4)

Ahora con ```shouldNot_returnALoan_whenItNotExists``` que verifica que el sistema no permita devolver un préstamo que no existe en la biblioteca.

![image](https://github.com/user-attachments/assets/c06b786b-bd4f-4d79-b651-5cc6722a0a20)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/3a9a303d-602f-4f16-a472-da07d046eeec)

Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/762a7f64-00ca-480c-a9b8-2ff512d2acc2)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/67e31f24-6c24-4c7b-90c9-dab2e4b1e485)

Ahora con ```should_changeStatus_whenReturnALoan``` que verifica que el estado de un préstamo cambie correctamente cuando se devuelve el libro.

![image](https://github.com/user-attachments/assets/adf33a6e-754b-4ca3-b8c3-bc5137921b94)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/c888eb1f-86fe-499e-bc28-cfb072be3cbe)

Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/51addbac-5ae9-44e6-af72-b8ce6d2793d0)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/2b81a05d-32f9-4dce-821c-71233b2c5179)

Ahora con ```should_changeReturnDate_whenReturnALoan``` que verifica que se actualice la fecha de devolución en un préstamo cuando se devuelve el libro.

![image](https://github.com/user-attachments/assets/b5f637af-84f8-4bf9-861e-6029db7577a0)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/05fdbaaa-ec51-408f-81dd-24e182f5f70f)

Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/e427ceca-6dcf-46f0-8591-65f270907fd6)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/81bf450f-33f3-44d2-bd00-2471344e399b)

Ahora con ```should_increaseBooks_whenReturnALoan``` que verifica que la cantidad de libros disponibles en la biblioteca se actualice correctamente cuando se devuelve un libro. 

![image](https://github.com/user-attachments/assets/4def40d1-f904-4c76-bfe3-3931158edfae)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/a2874d3e-ead0-46e8-9250-4a662be4e771)

Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/b2d6e404-623b-46d2-b79c-ec982b3f872c)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/662eda4a-1380-4e86-ba3d-72fa8ced4f0e)

Ahora con ```shouldNot_returnALoan_whenItIsReturned``` que verifica erifica que el sistema no permita devolver un libro que ya ha sido devuelto anteriormente.

![image](https://github.com/user-attachments/assets/ba57543a-ed53-4704-ba45-7f3d01fd1158)

En este punto debería fallar la prueba porque aún no se ha cambiado el método.

![image](https://github.com/user-attachments/assets/4d77379a-cb0f-4a5a-943b-8d3b52989955)

Refactorizamos la implementación del método.

![image](https://github.com/user-attachments/assets/dabc47be-5ebc-4461-94dd-25bf480b8a5b)

Volvemos a ejecutar las pruebas dando como resultado que es correcta.

![image](https://github.com/user-attachments/assets/4a029d29-0d35-4e23-925f-f0e380cf6e8e)

### Cobertura
Se agregó la dependencia de jacoco la cual utilizamos la última versión disponible en maven central y se añadió en el pom.xml.

![image](https://github.com/user-attachments/assets/9b0d0e09-6cad-4fa3-b77f-6d631230185e)

Se creó en target diferentes archivos que permite medir el grado en que el código está cubierto por las pruebas unitarias.

![image](https://github.com/user-attachments/assets/b864f545-68e9-426b-b2f0-6a6e6461935a)

Ingresamos al directorio jacoco y miramos el index.html para ver si las pruebas están cubiertas al menos el 80%.. 

![image](https://github.com/user-attachments/assets/2ca611c0-8774-42cf-8418-48a9955ea0f3)
![image](https://github.com/user-attachments/assets/f4c564c9-cb5e-4562-a522-18efa070a6ed)

Lo cual nos indica que nos falta pruebas de cobertura para los siguientes métodos de las clases:

![image](https://github.com/user-attachments/assets/c9dd8207-0333-458f-96b0-0cbebd4f72ed)
![image](https://github.com/user-attachments/assets/e728e8b1-1790-4e3d-89ea-6f0c5d03871a)
![image](https://github.com/user-attachments/assets/dfe745ae-6911-4839-94cc-8cadfd63e725)

### SonarQube

Primero se instaló Docker para Windows y se configuró en el pc.

![image](https://github.com/user-attachments/assets/252ef881-b76f-45cd-ac88-46ea3ba03ffe)
![image](https://github.com/user-attachments/assets/afb65605-a58e-4c37-84c7-67fb3694cd19)
![image](https://github.com/user-attachments/assets/991ee451-3a3b-47de-8e0c-94fa57444a89)
![image](https://github.com/user-attachments/assets/c43f9e37-b732-4c47-8981-09ded0510251)
![image](https://github.com/user-attachments/assets/4961b719-2b32-4758-8501-82457507e82c)

Luego se realizó con el comando ```docker pull sonarqube``` que se utiliza para descargar una imagen de Docker de SonarQube desde un registro de imágenes al entorno local en el que se ejecuta Docker.

![image](https://github.com/user-attachments/assets/ac782bbe-fee9-4dde-9f5c-47fba6202adc)

Ahora con el comando ```docker run -d``` se arranca el servicio de SonarQube.

![image](https://github.com/user-attachments/assets/db5993bc-b98c-4e55-9c77-2eada4cc0f68)

Seguido del comando ```docker ps -a``` que valida el funcionamiento. 

![image](https://github.com/user-attachments/assets/21364899-3f98-416b-bfe9-df9ed2b3a06e)

Luego se ingresó y cambiamos la contraseña.
```
    usuario: admin
    Passwd: admin
    New passwd: oElaL3bb
```

![image](https://github.com/user-attachments/assets/44599580-b8c1-42cb-acb9-bd73a0dca1ff)

![image](https://github.com/user-attachments/assets/25f9de2c-89c7-4d4e-906e-1e86f13190bd)

Seguimos este proceso ```Account -> settings -> generate token```

![image](https://github.com/user-attachments/assets/61023fbd-41c2-4000-936f-d7de9ed4a38f)
![image](https://github.com/user-attachments/assets/ebc20485-d31d-4d3d-a941-0c21145c065e)
![image](https://github.com/user-attachments/assets/fac5e362-46e0-422d-b6d7-643eb37f4480)

Instalamos sonarLint en el IDE que estamos manejando y añadimos el plugin al pom del proyecto.

![image](https://github.com/user-attachments/assets/db22b038-e7ff-414e-897c-440ea28b1c30)
![image](https://github.com/user-attachments/assets/e8000916-5e53-4b93-bc72-96e322dca685)
```xml
<plugin>
    <groupId>org.sonarsource.scanner.maven</groupId>
    <artifactId>sonar-maven-plugin</artifactId>
    <version>4.0.0.4121</version>
</plugin>
```
Añadimos las propiedades de SonarQube y Jacoco.

![image](https://github.com/user-attachments/assets/d73c9a62-9292-4155-a089-484f982ac859)
![image](https://github.com/user-attachments/assets/f4790e8f-18e2-453f-9918-5f02f7be72e6)

 Se construyó el proyecto de nuevo para que genere el reporte de JACOCO y poder correjir el cubrimiento de las pruebas de unidad.
 ![image](https://github.com/user-attachments/assets/2ebf5602-81e8-4582-8cf0-8e5b714ddef7)
![image](https://github.com/user-attachments/assets/cd149cc3-31ca-4a13-a98e-3e63eedc727d)
 ![image](https://github.com/user-attachments/assets/83c0544a-c754-41a6-b573-6bfb7dbbad31)

Se generó la integración con sonar ```mvn verify sonar:sonar -D sonar.token=[TOKEN_GENERADO]```

![image](https://github.com/user-attachments/assets/9c1124f6-7bf8-472a-8e01-c9f30305763d)
![image](https://github.com/user-attachments/assets/1381de4f-b643-48ba-a611-5737cdabeba0)
![image](https://github.com/user-attachments/assets/349ba329-c156-4dc6-b52d-383ceda17e65)

### Referencias:
- https://github.com/CVDS-ESCUELAING/Laboratory2024/blob/2b1987ba521bf2ce7f4c3f7416b6db536cabf941/LABORATORIOS/LAB03.md
- https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
-https://www.docker.com/products/docker-desktop/
