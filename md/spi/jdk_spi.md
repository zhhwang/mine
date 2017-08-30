1. 定义接口类
    ````
    public interface Search {
        void doSearch();
    }
    ````
2. 定义实现类

    ````
    public Class ASearch implements Search {
        @Override
        public void doSearch() {
            System.out.println("A");
        }
    }
    
    public Class BSearch implements Search {
            @Override
            public void doSearch() {
                System.out.println("B");
            }
        }
     ````
3. 定义配置文件META-INF/services/xxx.Search
     
   ````
   search=xxx.ASearch  
   ````
    或
    ````
    search=xxx.BSearch
    ````
4. 初始化
    ````
    import java.util.Iterator;  
    import java.util.ServiceLoader;  
    
    public class SearchTest {  
    
    public static void main(String[] args) {  
        ServiceLoader<Search> s = ServiceLoader.load(Search.class);  
            Iterator<Search> searchs = s.iterator();  
            if (searchs.hasNext()) {  
                Search curSearch = searchs.next();  
                curSearch.search();  
            }  
        }  
    }
    ````
5. META-INF/services/xxx.Search的services是根据java.util.ServiceLoader确定，dubbo定义了自己的ServiceLoader
6. 缺点：一次性实例化扩展点所有实现，耗费时间和内存资源；扩展点加载失败时无法获取扩展点名称
