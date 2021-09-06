import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.spring.PropertyPreFilters;
/**
 * 使用FastJson将实体对象转换成Json字符串测试类
 */
public class FastJsonApplication {
     public static void main(String[] args) {
        User user = new User();
        user.setId(1L);
        user.setUsername("张三");
        user.setPassword("");
        user.setMobile(null);
        user.setCountry("中国");
        user.setCity("武汉");
     String jsonUser = null;

        /**
         * 指定排除属性过滤器和包含属性过滤器
         * 指定排除属性过滤器：转换成JSON字符串时，排除哪些属性
         * 指定包含属性过滤器：转换成JSON字符串时，包含哪些属性
         */
        String[] excludeProperties = {"country", "city"};
        String[] includeProperties = {"id", "username", "mobile"};
        PropertyPreFilters filters = new PropertyPreFilters();

        /**
         * 排除过滤器
         */
        PropertyPreFilters.MySimplePropertyPreFilter excludefilter = filters.addFilter();
        excludefilter.addExcludes(excludeProperties);

        /**
         * 包含过滤器
         */
        PropertyPreFilters.MySimplePropertyPreFilter includefilter = filters.addFilter();
        includefilter.addIncludes(includeProperties);


        /**
         * 情况一：默认忽略值为null的属性
         */
        jsonUser = JSONObject.toJSONString(user, SerializerFeature.PrettyFormat);
        System.out.println("情况一:\n" + jsonUser);

        /**
         * 情况二：包含值为null的属性
         */
        jsonUser = JSONObject.toJSONString(user, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        System.out.println("情况二:\n" + jsonUser);

        /**
         * 情况三：默认忽略值为null的属性，但是排除country和city这两个属性
         */
        jsonUser = JSONObject.toJSONString(user, excludefilter, SerializerFeature.PrettyFormat);
        System.out.println("情况三:\n" + jsonUser);

        /**
         * 情况四：包含值为null的属性，但是排除country和city这两个属性
         */
        jsonUser = JSONObject.toJSONString(user, excludefilter, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        System.out.println("情况四:\n" + jsonUser);

        /**
         * 情况五：默认忽略值为null的属性，但是包含id、username和mobile这三个属性
         */
        jsonUser = JSONObject.toJSONString(user, includefilter, SerializerFeature.PrettyFormat);
        System.out.println("情况五:\n" + jsonUser);

        /**
         * 情况六：包含值为null的属性，但是包含id、username和mobile这三个属性
         */
        jsonUser = JSONObject.toJSONString(user, includefilter, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue);
        System.out.println("情况六:\n" + jsonUser);
    }

    /**
     * 用户实体类
     */
    public static class User {  
        private Long id;
        private String username;
        private String password;
        private String mobile;
        private String country;
        private String city;
    //此处省略了相应属性的set、get方法
}