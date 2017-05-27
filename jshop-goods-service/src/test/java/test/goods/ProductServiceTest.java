package test.goods;

/**
 * Created by tommy on 17/5/27.
 */

import net.jeeshop.services.front.product.ProductService;
import net.jeeshop.services.front.product.bean.Product;
import net.jeeshop.services.front.product.impl.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductServiceTest extends BaseTest{
    private ProductService productService;

    @Before
    public void init(){
        getBean(ProductServiceImpl.class);
         productService=getBean(ProductService.class);
    }
    @Test
    public  void getProduct(){
        Product product = productService.selectById("10001");
        Assert.assertNotNull(product);
    }

}
