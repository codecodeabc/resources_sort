package knowledge.javaapi.unicode;

import cn.hutool.json.JSONObject;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * unicode转换，可使用hutool工具里的UnicodeUtil代替
 */
public class UnicodeToZh  implements Serializable {
    public static void main(String[] args) {
        String content = "\\u5f53\\u5730\\u65f6\\u95f42019\\u5e747\\u670813\\u65e5\\uff0c\\u82f1\\u56fd\\u8d1d\\u5fb7\\u798f\\u7279\\u90e1\\u74e6\\u827e\\u6ce2\\u65af\\u987f\\uff0c\\u82f1\\u56fd\\u9996\\u76f8\\u70ed\\u95e8\\u5019\\u9009\\u4eba\\u3001\\u73b0\\u4efb\\u5916\\u4ea4\\u5927\\u81e3\\u6770\\u91cc\\u7c73-\\u4ea8\\u7279\\u51fa\\u5e2d\\u4fdd\\u5b88\\u515a\\u9886\\u8896\\u7ade\\u9009\\u6d3b\\u52a8\\u3002\\u4ea8\\u7279\\u4e0e\\u4f0a\\u6717\\u5916\\u957f\\u624e\\u91cc\\u592b\\u8fdb\\u884c\\u4e86\\u901a\\u8bdd\\uff0c\\u5c31\\u82f1\\u56fd\\u6263\\u62bc\\u4f0a\\u6717\\u6cb9\\u8f6e\\u4e8b\\u4ef6\\u4e3e\\u884c\\u4e86\\u201c\\u5efa\\u8bbe\\u6027\\u201d\\u4f1a\\u8c08\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u201c\\uff08\\u6211\\uff09\\u521a\\u521a\\u4e0e\\u4f0a\\u6717\\u5916\\u957f\\u624e\\u91cc\\u592b\\u901a\\u4e86\\u8bdd\\u3002\\u8fdb\\u884c\\u4e86\\u5efa\\u8bbe\\u6027\\u7684\\u4f1a\\u8c08\\u3002\\u6211\\u5411\\u4ed6\\u4fdd\\u8bc1\\uff0c\\u82f1\\u56fd\\u5173\\u6ce8\\u7684\\u662f\\u2018\\u683c\\u857e\\u4e1d\\u4e00\\u53f7\\u2019\\u6cb9\\u8f6e\\u4e0a\\u539f\\u6cb9\\u7684\\u76ee\\u7684\\u5730\\uff0c\\u800c\\u4e0d\\u662f\\u5176\\u6765\\u6e90\\u5730\\u3002\\u5982\\u679c\\u6211\\u4eec\\u5728\\u76f4\\u5e03\\u7f57\\u9640\\u6cd5\\u5ead\\u6309\\u7167\\u6b63\\u5f53\\u7a0b\\u5e8f\\u5f97\\u5230\\u4e86\\u8fd9\\u4e9b\\u539f\\u6cb9\\u4e0d\\u4f1a\\u88ab\\u8fd0\\u5f80\\u53d9\\u5229\\u4e9a\\u7684\\u4fdd\\u8bc1\\uff0c\\u82f1\\u56fd\\u613f\\u4e3a\\u91ca\\u653e\\uff08\\u88ab\\u6263\\u6cb9\\u8f6e\\uff09\\u63d0\\u4f9b\\u4fbf\\u5229\\u3002\\u201d\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u4ea8\\u7279\\u8fd8\\u5728\\u63a8\\u7279\\u4e0a\\u8bf4\\uff1a\\u201c\\u624e\\u91cc\\u592b\\u66fe\\u5411\\u6211\\u8868\\u793a\\uff0c\\u4f0a\\u6717\\u5e0c\\u671b\\u89e3\\u51b3\\u95ee\\u9898\\uff0c\\u4e0d\\u5bfb\\u6c42\\uff08\\u51b2\\u7a81\\uff09\\u5347\\u7ea7\\u3002\\u6211\\u8fd8\\u4e0e\\u6cd5\\u6bd4\\u5b89-\\u76ae\\u5361\\u5c14\\u591a\\uff08\\u76f4\\u5e03\\u7f57\\u9640\\u9996\\u5e2d\\u90e8\\u957f\\uff09\\u8fdb\\u884c\\u4e86\\u8c08\\u8bdd\\uff0c\\u4ed6\\u5728\\u534f\\u8c03\\u95ee\\u9898\\u4e0a\\u505a\\u5f97\\u5f88\\u597d\\uff0c\\u8fd8\\u5411\\u6211\\u5206\\u4eab\\u4e86\\u82f1\\u56fd\\u5bf9\\u672a\\u6765\\u7684\\u5c55\\u671b\\u3002\\u201d\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09RT\\u8868\\u793a\\uff0c\\u4f0a\\u6717\\u6b64\\u524d\\u4e00\\u518d\\u58f0\\u660e\\uff0c\\u201c\\u683c\\u857e\\u4e1d\\u4e00\\u53f7\\u201d\\u6cb9\\u8f6e\\u4ece\\u672a\\u6253\\u7b97\\u9a76\\u5f80\\u53d9\\u5229\\u4e9a\\uff0c\\u4f46\\u8fd9\\u4e9b\\u58f0\\u660e\\u663e\\u7136\\u4e0d\\u8db3\\u4ee5\\u8ba9\\u82f1\\u56fd\\u53ca\\u5176\\u6d77\\u5916\\u9886\\u5730\\u76f4\\u5e03\\u7f57\\u9640\\u4fe1\\u670d\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u636e\\u4fc4\\u7f57\\u65af\\u536b\\u661f\\u7f5113\\u65e5\\u62a5\\u9053\\uff0c\\u76f4\\u5e03\\u7f57\\u9640\\u8b66\\u65b9\\u5728\\u63a8\\u7279\\u4e0a\\u53d1\\u8868\\u58f0\\u660e\\u79f0\\uff0c\\u88ab\\u6263\\u62bc\\u76844\\u540d\\u4f0a\\u6717\\u8239\\u5458\\u5df2\\u88ab\\u201c\\u6709\\u6761\\u4ef6\\u201d\\u91ca\\u653e\\u3002\\u4f46\\u6cb9\\u8f6e\\u4ecd\\u5904\\u4e8e\\u6263\\u62bc\\u72b6\\u6001\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u672c\\u67084\\u53f7\\uff0c\\u76f4\\u5e03\\u7f57\\u9640\\u5728\\u82f1\\u56fd\\u6d77\\u519b\\u534f\\u52a9\\u4e0b\\uff0c\\u6263\\u62bc\\u4e86\\u8fd0\\u8f93\\u4f0a\\u6717\\u539f\\u6cb9\\u7684\\u201c\\u683c\\u857e\\u4e1d\\u4e00\\u53f7\\u201d\\u6cb9\\u8f6e\\uff0c\\u79f0\\u8fd9\\u8258\\u6cb9\\u8f6e\\u8fdd\\u53cd\\u6b27\\u76df\\u5236\\u88c1\\u6cd5\\u4ee4\\uff0c\\u5411\\u53d9\\u5229\\u4e9a\\u8fd0\\u9001\\u539f\\u6cb9\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u4e8b\\u4ef6\\u53d1\\u751f\\u540e\\uff0c\\u4f0a\\u6717\\u591a\\u6b21\\u5411\\u82f1\\u65b9\\u8868\\u793a\\u6297\\u8bae\\uff0c\\u8981\\u6c42\\u82f1\\u56fd\\u5c3d\\u5feb\\u91ca\\u653e\\u906d\\u6263\\u62bc\\u7684\\u88c5\\u8f7d\\u4f0a\\u6717\\u539f\\u6cb9\\u7684\\u6cb9\\u8f6e\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\\u4f0a\\u6717\\u591a\\u540d\\u9ad8\\u7ea7\\u5b98\\u5458\\u4e5f\\u8c34\\u8d23\\u82f1\\u56fd\\u7684\\u6263\\u62bc\\u884c\\u5f84\\u5f62\\u540c\\u201c\\u5f3a\\u76d7\\u884c\\u4e3a\\u201d\\u3002\\uff08\\u56fe\\u7247\\u7f72\\u540d\\uff1a IC photo\\uff09\n";
        JSONObject jsonObject = new JSONObject();
        jsonObject.putOpt("code",1)
                .putOnce("msg",content);
        System.out.println(UnicodeToCN(jsonObject.toJSONString(0)));
    }
    public static String UnicodeToCN(String unicodeStr) {
        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(unicodeStr);
        char ch;
        while (matcher.find()) {
            //group
            String group = matcher.group(2);
            //ch:'李四'
            ch = (char) Integer.parseInt(group, 16);
            //group1
            String group1 = matcher.group(1);
            unicodeStr = unicodeStr.replace(group1, ch + "");
        }

        return unicodeStr.replace("\\", "").trim();
    }

    public static String CNToUnicode(String CN) {

        try {
            StringBuffer out = new StringBuffer("");
            //直接获取字符串的unicode二进制
            byte[] bytes = CN.getBytes("unicode");
            //然后将其byte转换成对应的16进制表示即可
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
