package net.jeeshop.biz.global;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import net.jeeshop.core.DataGetter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

/**
 * @author dylan
 * @date 16/3/22 21:31
 * Email: dinguangx@163.com
 */
@Component
public class GlobalDataManager {
    private static Map<String, DataGetter> map = Maps.newHashMap();

    @PostConstruct
    public void init() {
        initProductDataGetter();
        initCmsDataGetter();
        initAccountCenterDataGetter();
    }

    public static DataGetter getData(String key) {
        return map.get(key);
    }

    public static Map<String, DataGetter> getAllData() {
        return map;
    }

    protected void addDataGetter(DataGetter dataGetter) {
        map.put(dataGetter.getName(), dataGetter);
    }

    public void initProductDataGetter() {
        //product category
        addDataGetter(new DataGetter<List>("product.categoryList", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //hot product list
        addDataGetter(new DataGetter<List>("product.hotProducts", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //sale product list
        addDataGetter(new DataGetter<List>("product.saleProducts", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //new product list
        addDataGetter(new DataGetter<List>("product.newProducts", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
    }

    public void initCmsDataGetter() {
        //cms data getter
        //friend link list
        addDataGetter(new DataGetter<List>("cms.friendLinkList", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //notice list
        addDataGetter(new DataGetter<List>("cms.noticeList", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //help list
        addDataGetter(new DataGetter<List>("cms.helpList", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //index image list
        addDataGetter(new DataGetter<List>("cms.indexImages", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });
        //hot query list
        addDataGetter(new DataGetter<List>("cms.hotQueryList", DataGetter.DataType.LIST) {
            @Override
            public List getData() {
                return Lists.newArrayList();
            }
        });

    }

    public void initAccountCenterDataGetter() {

        //shopping cart
        addDataGetter(new DataGetter<Object>("account.shoppingCart", DataGetter.DataType.OBJECT) {
            @Override
            public Object getData() {
                return null;
            }
        });
    }
}
