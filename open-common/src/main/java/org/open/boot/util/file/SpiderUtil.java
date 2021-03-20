package org.open.boot.util.file;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author barnak
 */
public class SpiderUtil {

    public static void main(String[] args) throws Exception {
        baiduPicture();
    }


    public static List<String> baiduPicture() {
        // 查询关键词
        String queryWords = "微信头像";
        // 页码
        int pageNo = 0;
        // 每页大小
        int pageSize = 30;

        int jgpNum = 1;
        for (int i = 0; i < 2 ; i++ ) {
            // 爬取图片地址，百度图片
            String s = HttpUtil.get("https://image.baidu.com/search/acjson?" +
                    "tn=resultjson_com&" + "logid=8764851649584188828&" + "ipn=rj&" + "ct=201326592&" + "is=&" +
                    "fp=result&" +
                    "queryWord="+ queryWords +"&" +
                    "cl=2&" + "lm=-1&" + "ie=utf-8&" + "oe=utf-8&" + "adpicid=&" + "st=-1&" + "z=&" + "ic=0&" +
                    "hd=&" + "latest=&" + "copyright=&" +
                    "word="+ queryWords +"&" +
                    "s=&" + "se=&" + "tab=&" + "width=&" + "height=&" + "face=0&" + "istype=2&" + "qc=&" + "nc=1&" +
                    "fr=&" + "expermode=&" + "force=&" +
                    "pn="+ pageNo +"&" +
                    "rn="+ pageSize +"&" +
                    "gsm=1e&" + "1616225318011=");
            JSONObject jsonObject = JSON.parseObject(s);
            String data = jsonObject.getString("data");
            List<JSONObject> jsonObjects = JSON.parseArray(data, JSONObject.class);

            for (JSONObject object : jsonObjects) {
                String thumbURL = object.getString("thumbURL");
            }
            pageNo = pageNo + pageSize;
        }
        return null;
    }
}
