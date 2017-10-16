package com.botany.mint.design.decorator.factory;

import com.botany.mint.design.decorator.filter.StringFilter;
import com.botany.mint.design.decorator.filter.impl.EmptyFilter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * demo class
 *
 * @author wangzh
 * @date 2017/10/16
 */
public class StringFilterFactory {
    private static final Log log = LogFactory.getLog(StringFilterFactory.class);

    private static final StringFilterFactory stringFilterFactory = new StringFilterFactory();

    private Map filterMap = new HashMap();

    private StringFilterFactory() {
        //ConfigureManager是Hompy项目统一读取配置的类，以多例(Multi-Singleton)模式实现
        //filterMap = ConfigureManager.getInstance("filter").getMap();
    }
    public static StringFilterFactory getInstance() {
        return stringFilterFactory;
    }

    /**
     * 通过一个以逗号分割的过滤器引用名串，获取过滤器
     */
    public StringFilter getStringFilterChain(String chain) {
        if (chain == null || chain.length() == 0) {
            return new EmptyFilter();
        }

        if ("all".equalsIgnoreCase(chain)) {
            return getAllStringFilterChain();
        }

        String[] filters = chain.split("\\,");
        return getStringFilterChain(filters);
    }

    public StringFilter getAllStringFilterChain() {
        String[] filters = (String[]) filterMap.values().toArray();
        return getStringFilterChain(filters);
    }

    public StringFilter getStringFilterChain(String[] filters) {
        if (filters == null || filters.length == 0) {
            return new EmptyFilter();
        }

        StringFilter[] stringFilters = new StringFilter[filters.length];
        for (int i = filters.length - 1; i >= 0; i--) {
            stringFilters[i] = getStringFilter(filters[i]);
            if (i != filters.length - 1) {
                stringFilters[i].setNextStringFilter(stringFilters[i + 1]);
            } else {
                stringFilters[i].setNextStringFilter(null);
            }
        }
        return stringFilters[0];
    }

    public StringFilter getStringFilter(String key) {
        if (key != null) {
            try {
                //通过类名反射得到过滤器的实例
                Class clazz = Class.forName((String) filterMap.get(key));
                StringFilter stringFilter = (StringFilter) clazz.newInstance();
                return stringFilter;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                log.warn(e);
            } catch (InstantiationException e) {
                e.printStackTrace();
                log.warn(e);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                log.warn(e);
            }
        }
        return new EmptyFilter();
    }

}
