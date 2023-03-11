public class ProductRepository {

    private Product[] products = new Product[0];

    public void add (Product product){
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[products.length] = product;
        products = tmp;
    }

    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
            }
            products = tmp;

        }
    }

    public Product[] findAll(){
        return products;
    }

}
