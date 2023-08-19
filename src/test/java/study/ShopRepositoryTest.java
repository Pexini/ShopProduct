package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {


    @Test
    public void removeId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        repo.remove(5);

        Product[] expected = new Product[]{
                new Product(1, "Product 1", 1_235),
                new Product(2, "Product 2", 12_155),
                new Product(8, "Product 4", 1_500_000),
                new Product(9, "Product 5", -1)
        };
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void removeNotRealNegativeId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Assertions.assertThrows(NotFoundException.class, () ->
                repo.remove(-15));
    }

    @Test
    public void removeNotRealPositiveId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(45));

    }

    @Test
    public void AddFiveId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Product[] expected = {
                new Product(1, "Product 1", 1_235),
                new Product(2, "Product 2", 12_155),
                new Product(5, "Product 8", 55_999),
                new Product(8, "Product 4", 1_500_000),
                new Product(9, "Product 5", -1)
        };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void AddDoubleId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.add(new Product(8, "Product 4", 1_500_000));
        });

    }
}

