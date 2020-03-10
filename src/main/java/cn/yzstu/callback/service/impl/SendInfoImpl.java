package cn.yzstu.callback.service.impl;

import cn.yzstu.callback.service.SendInfo;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import utils.DateUtil;
import utils.HttpUtils;
import utils.RequestUtils;
import utils.log.LogUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * \* User: Baldwin
 * \* E_Mail: baldwin@chancellorhk.com || DikeyWang@163.com
 * \* Date: 2020/3/10
 * \* Time: 16:10
 * \* Description:
 * \
 */
@Service
public class SendInfoImpl  implements SendInfo {
    @Override
    public String sendInfo(HttpServletRequest request) {

        String url ="";
        JSONObject infoJson = RequestUtils.getRequestJsonFromGET(request);
        String ret = "false";

        LogUtil.write2file(infoJson.toJSONString(),"sendInfoLog"+ DateUtil.getDate());

        String postRet = HttpUtils.sendPost(url,infoJson.toString(),10000);

        LogUtil.write2file(postRet,"sendInfoLog"+ DateUtil.getDate());

        if (ret.equalsIgnoreCase("ok")){
            ret = null;
        }

        return ret;
    }
}