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

        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void findIdFive() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));


        Product expected = repo.findById(5);

        Product actual = expected;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotfindId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));


        try {
            Product expected = repo.findById(3);
        } catch (NotFoundException e) {
            Assertions.assertEquals("Element with id: 3 not found", e.getMessage());
        }

    }

    @Test
    public void findId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));


        try {
            Product e = repo.findById(1);
        } catch (NotFoundException e) {
            Assertions.assertEquals("Element with id: 3 not found", e.getMessage());
        }
    }

    @Test
    public void notFindId77() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.findById(77);
        });
    }

    @Test
    public void FindId5() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));


        Product expected = new Product(5, "Product 8", 55_999);
        Product actual = repo.findById(5);
        Assertions.assertEquals(actual, expected);

    }

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
    public void removeNotRealId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.remove(-15);
        });
    }

    @Test
    public void AddId() {
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

        assertThrows(NotFoundException.class, () -> {
            repo.add(new Product(8, "Product 4", 1_500_000));
        });

    }

    @Test
    public void notAddDoubleId() {
        ShopRepository repo = new ShopRepository();
        repo.add(new Product(1, "Product 1", 1_235));
        repo.add(new Product(2, "Product 2", 12_155));
        repo.add(new Product(5, "Product 8", 55_999));
        repo.add(new Product(8, "Product 4", 1_500_000));
        repo.add(new Product(9, "Product 5", -1));

        try {
            repo.add(new Product(8, "Product 4", 1_500_000));
        } catch (NotFoundException s) {
            assertEquals("Element with id: 8 already exist", s.getMessage());
        }
        ;
    }
}