import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {
    public static void main(String[] args) {

        //Task 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("example text", String::toUpperCase);
        poemBeautifier.beautify("example text", text -> text.replace(" ", "_"));
        poemBeautifier.beautify("example text", text -> text.replaceAll("example text", "ExampleText"));

        System.out.println(" ");

        //Task 7.3
        Forum forum = new Forum();
        LocalDate today = LocalDate.now();
        Map<Integer, ForumUser> usersMap = forum.getUserList().stream()
                .filter(user -> user.getSex() == 'M')
                .filter(user -> today.getYear() - user.getDateOfBirth().getYear() >= 20)
                .filter(user -> user.getPostQuantity() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserId, user -> user));

        usersMap.entrySet().stream()
                .map(eachEntry -> eachEntry.getKey() + ": " + eachEntry.getValue())
                .forEach(System.out::println);
        System.out.println(" ");

        // Collectors.toList()
        //BookDirectory theBookDirectory = new BookDirectory();
        //List<Book> theResultListOfBooks = theBookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .collect(Collectors.toList());

        //System.out.println("# elements: " + theResultListOfBooks.size());
        //theResultListOfBooks.stream()
        //        .forEach(System.out::println);

        // Collectors.toMap()
        //Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .collect(Collectors.toMap(Book::getSignature, book -> book));

        //System.out.println("\n# elements: " + theResultMapOfBooks.size());
        //theResultMapOfBooks.entrySet().stream()
        //        .map(entry -> entry.getKey() + ": " + entry.getValue())
        //        .forEach(System.out::println);
        //System.out.println(" ");

        // Collectors.joining()
        //String theResultStringOfBooks = theBookDirectory.getList().stream()
        //        .filter(book -> book.getYearOfPublication() > 2005)
        //        .map(Book::toString)
        //        .collect(Collectors.joining(",\n","<<",">>"));

        //System.out.println(theResultStringOfBooks);
    }
}
