package study;

public class ShopRepository {
    private Product[] products = new Product[0];

    /**
     * Вспомогательный метод для имитации добавления элемента в массив
     *
     * @param current — массив, в который мы хотим добавить элемент
     * @param product — элемент, который мы хотим добавить
     * @return — возвращает новый массив, который выглядит, как тот, что мы передали,
     * но с добавлением нового элемента в конец
     */
    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    /**
     * Метод добавления товара в репозиторий
     *
     * @param product — добавляемый товар
     */
    public void add(Product product) {
        int productId = product.getId();
        for (Product prod : products) {
            if (prod.getId() == product.getId()) {
                throw new NotFoundException(

                        "Element with id: " + product.getId() + " already exist"
                );

            }
        }
        products = addToArray(products, product);
    }


    public Product[] findAll() {
        return products;
    }

    public Product findById(int id) {

        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        throw new NotFoundException("Element with id: " + id + " not found");
    }


    public void remove(int id) {
        if (id < 0) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found"
            );
        }
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

}
