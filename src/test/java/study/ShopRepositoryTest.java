package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void firstAddAndFind() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));
        int expected = 5;
        int actual = repo.findAll().length;

        Assertions.assertEquals(actual,expected);
    }
}