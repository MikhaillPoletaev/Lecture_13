import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {

    @Test

    public void addProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");
        Book book2 = new Book(3, "Азазель", 250, "Борис Акунин");
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] expected = {book1, book2, phone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void searchProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");
        Book book2 = new Book(3, "Азазель", 250, "Борис Акунин");
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] expected = {book1};
        Product[] actual = manager.searchBy("Турецкий");

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void removeProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");
        Book book2 = new Book(3, "Азазель", 250, "Борис Акунин");
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);
        repo.removeById(2);

        Product[] expected = {book1, book2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test

    public void searchProduct2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");
        Book book2 = new Book(3, "Турецкий Гамбит 2", 250, "Борис Акунин");
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Product[] expected = {book1, book2};
        Product[] actual = manager.searchBy("Турецкий");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test

    public void getPrice() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(phone1);

        int actual = 15000;
        int expected = phone1.getPrice();

        Assertions.assertEquals(actual, expected);


    }

    @Test

    public void getAuthor() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");

        manager.add(book1);

        String actual = "Борис Акунин";
        String expected = book1.getAuthor();

        Assertions.assertEquals(actual, expected);


    }

    @Test

    public void getManufacturer() {

        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(phone1);

        String actual = "Samsung Inc.";
        String expected = phone1.getManufacturer();

        Assertions.assertEquals(actual, expected);


    }

    @Test

    public void removeProduct2() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);
        Book book1 = new Book(1, "Турецкий гамбит", 250, "Борис Акунин");
        Book book2 = new Book(3, "Азазель", 250, "Борис Акунин");
        Smartphone phone1 = new Smartphone(2, "Samsung", 15000, "Samsung Inc.");

        manager.add(book1);
        manager.add(book2);
        manager.add(phone1);

        Assertions.assertThrows(NonFoundException.class, () -> {
            repo.removeById(6);
        });
    }
}

