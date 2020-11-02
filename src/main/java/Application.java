import services.*;

import java.util.List;

public class Application {
    public static void main(String[]args) {
        BookServiceImplService bookServiceImplService = new BookServiceImplService();
        BookService bookService = bookServiceImplService.getBookServiceImplPort();

        Book book = new Book();
        book.setName("mk");
        book.setAuthor("sd");
        CreateRequest createRequest = new CreateRequest();
        createRequest.setBook(book);
        CreateResponse createResponse = bookService.create(createRequest);
        System.out.println(createResponse.getResponseInfo().getMessage());

        String name = "Perfume";
        FindByNameRequest findByNameRequest = new FindByNameRequest();
        findByNameRequest.setName(name);
        FindByNameResponse findByNameResponse = bookService.findByName(findByNameRequest);
        System.out.println(findByNameResponse.getResponseInfo().getMessage());
        List<Book> books = findByNameResponse.getBook();
        for(Book bookk : books){
            System.out.println("Name - " + bookk.getName() + ", author - " + bookk.getAuthor());
        }
    }
}