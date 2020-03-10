package utils;

import com.alibaba.fastjson.JSONObject;
/*import org.apache.commons.lang.StringUtils;
import payment.common.Constants;
import payment.server.bean.sys.User;*/

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class RequestUtils /*implements Constants*/ {

    public static JSONObject getRequestJson(HttpServletRequest request) throws Exception {
        String reqStr = "";
        JSONObject json = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
        String tempStr = "";
        while ((tempStr = reader.readLine()) != null) {
            reqStr += tempStr;
        }
        json = JSONObject.parseObject(reqStr);
        return json;
    }


/*    public static String getRequestIp(HttpServletRequest request) {
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP  
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

    public static User getSessionLoginUser(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (null == session) {
            return null;
        }
        User user = (User) session.getAttribute(SESSION_LOGIN_USER);
        return user;
    }*/

    /**
     * 判断是否为AJAX请求
     *
     * @param request
     * @return
     */
    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))
                || request.getParameter("ajax") != null;
    }

    /**
     * 取String 类型的参数，如果为null，返回友好值""
     *
     * @param request
     * @param paraName
     * @return
     */
    public static String getString(HttpServletRequest request, String paraName) {
        String ret = "";
        String tempStr = request.getParameter(paraName);
        if (null != tempStr) {
            ret = tempStr;
        }
        return ret;
    }

    /**
     * 取Integer类型参数,如果为null，返回null
     *
     * @param request
     * @param paraName
     * @return
     */
    public static Integer getInteger(HttpServletRequest request, String paraName) {
        Integer ret = null;
        String tempStr = request.getParameter(paraName);
        if (!tempStr.isEmpty()) {
            ret = Integer.valueOf(tempStr);
        }
        return ret;
    }

    /**
     * 取参数的Integer值列
     *
     * @param request
     * @param paraName
     * @return
     *//*
    public static List<Integer> getIntegers(HttpServletRequest request, String paraName) {
        String tempStrArray[] = request.getParameterValues(paraName);
        List<Integer> valueArray = new ArrayList<Integer>();
        if (null != tempStrArray) {
            for (String tempStr : tempStrArray) {
                if (StringUtils.isNotBlank(tempStr) && StringUtils.isNumeric(tempStr)) {
                    valueArray.add(Integer.parseInt(tempStr.trim()));
                }
            }
        }
        return valueArray;
    }
*/

    /**
     * <p>Title: getRequestJsonFromGET</p>
     * <p>Description: 获取reqest-get请求中的所有参数，并写入到一个JSON中</p>
     *
     * @param request
     * @return
     */
    public static JSONObject getRequestJsonFromGET(HttpServletRequest request) {

        JSONObject retJson = new JSONObject();
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = (String) enu.nextElement();
            retJson.put(paraName, request.getParameter(paraName).equals("null") ? "" : request.getParameter(paraName));
        }
        return retJson;
    }

}