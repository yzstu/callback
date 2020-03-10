/** 
* <p>Title: HMACSHA1.java</p>  
* <p>Description: </p>  
* <p>Company: http://www.indoallpay.com</p>  
* @author Baldwin
* @email baldwin@chancellorhk.com||DikeyWang@163.com  
* @date 2019年9月12日  下午3:17:57
*/ 
package utils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**  
* <p>Title: HMACSHA1</p>  
* <p>Description: HMACSHA1加密算法</p>  
* @author Baldwin  
* @date 2019年9月12日  
*/
public final class HMACSHA1 {

	private static final String MAC_NAME = "HmacSHA1";  
    private static final String ENCODING = "UTF-8";  
    
	/*
	 * 展示了一个生成指定算法密钥的过程 初始化HMAC密钥 
	 * @return 
	 * @throws Exception
	 * 
	  public static String initMacKey() throws Exception {
	  //得到一个 指定算法密钥的密钥生成器
	  KeyGenerator KeyGenerator keyGenerator =KeyGenerator.getInstance(MAC_NAME); 
	  //生成一个密钥
	  SecretKey secretKey =keyGenerator.generateKey();
	  return null;
	  }
	 */
    
    /** 
     * 使用 HMAC-SHA1 签名方法对对encryptText进行签名 
     * @param encryptText 被签名的字符串 
     * @param encryptKey  密钥 
     * @return 
     * @throws Exception 
     */  
    public static String HmacSHA1Encrypt(String encryptText, String encryptKey) throws Exception {         
    	byte[] data=encryptKey.getBytes(ENCODING);
    	//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称
        SecretKey secretKey = new SecretKeySpec(data, MAC_NAME); 
        //生成一个指定 Mac 算法 的 Mac 对象
        Mac mac = Mac.getInstance(MAC_NAME); 
        //用给定密钥初始化 Mac 对象
        mac.init(secretKey);  
        
        byte[] text = encryptText.getBytes(ENCODING);  
        //完成 Mac 操作 
        byte[] bs = mac.doFinal(text);  
        
        StringBuffer sb = new StringBuffer();
        
        for(byte b:bs) {
        	sb.append(byteToHexString(b));
        }
        
        return sb.toString();
    }
    
    private static String byteToHexString(byte ib){  
        char[] Digit={  
          '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'  
        };  
        char[] ob=new char[2];  
        ob[0]=Digit[(ib>>>4)& 0X0f];  
        ob[1]=Digit[ib & 0X0F];  
        String s=new String(ob);  
        return s;           
       }       
}

