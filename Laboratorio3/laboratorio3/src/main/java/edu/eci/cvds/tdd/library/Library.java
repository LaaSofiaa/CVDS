package edu.eci.cvds.tdd.library;

import edu.eci.cvds.tdd.library.book.Book;
import edu.eci.cvds.tdd.library.loan.Loan;
import edu.eci.cvds.tdd.library.loan.LoanStatus;
import edu.eci.cvds.tdd.library.user.User;

import java.time.LocalDateTime;
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
     * get the hashmap with the information about available books.
     * @return hashmap of books
     */
    public Map<Book, Integer> getBooks(){
        return this.books;
    }
    /**
     * get the list of users
     * @return a user list
     */
    public List<User> getUsers(){
        return users;
    }
    /**
     * get the list of loans
     * @return a loan list
     */
    public List<Loan> getLoans(){
        return loans;
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

            if(book == null) return false;
            if(book.getIsbn() == null || book.getIsbn().isEmpty() ) return false;
            if(!books.containsKey(book)){
                for(Book bk : books.keySet()){
                    if(bk.getIsbn()==book.getIsbn()){
                        return false;
                    }
                }
                books.put(book, 1 );
                return true;
            }
            else {
                books.replace(book, books.get(book)+1);
                return true;
            }

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
        Book book = books.keySet().stream().filter(bk->bk.getIsbn().equals(isbn)).findFirst().orElseThrow(() -> new IllegalArgumentException("Book does not exist"));
        if(books.get(book)==0) throw new IllegalArgumentException("There are not available books");
        User user = users.stream().filter(usr -> usr.getId().equals(userId)).findFirst().orElseThrow(() -> new IllegalArgumentException("User does not exist"));
        boolean existLoan = loans.stream().anyMatch(ln -> ln.getUser().getId().equals(userId) && ln.getBook().getIsbn().equals(isbn));
        if(existLoan) throw new IllegalArgumentException("The user already has a loan for that book");
        Loan loan = new Loan();
        loan.setBook(book);
        loan.setUser(user);
        loan.setLoanDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.ACTIVE);
        books.replace(book, books.get(book)-1);
        loans.add(loan);
        return loan;
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
        if(loan.getStatus()==LoanStatus.RETURNED) throw new IllegalArgumentException("The loan already has been returned");
        boolean existsLoan = this.loans.stream().anyMatch(ln->ln==loan);
        if(!existsLoan) throw new IllegalArgumentException("The loan does not exist");
        loan.setStatus(LoanStatus.RETURNED);
        loan.setReturnDate(LocalDateTime.now());
        Book book = books.keySet().stream().filter(bk->bk==loan.getBook()).findFirst().orElse(null);
        books.replace(book,books.get(book)+1);
        return loan;
    }

    public boolean addUser(User user) {
        return users.add(user);

    }

    }