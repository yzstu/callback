package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UniqueStringUtils {
	static Object xlock = new Object();
	static String mlastKey = "";
	static Integer mOrderIndex = 100;
	static String signSt="mz";
	static String serverId = Configration.getInstance("config").getValue("serverId");
	public static String getOrderId() {
		return "mz"+serverId+getUniqueString();
	}
	/**
	 * 以s开头,长度不确定
	 * @return
	 */
	public static String getUniqTransParams() {
		return getUniqTransParams(8);
	}
	/**
	 * 自定义长度，最终以s开头，建议不低于8位。如果实际需要8位或<8位，需要注意！！！！！可能重复
	 * @param length
	 * @return
	 */
	public static String getUniqTransParams(int length){
		synchronized (xlock) {
			String key = getUniqueString();
			if (key.length() > length) {
				key = key.substring(key.length()-length-2, key.length());
			}
			key = "s"+serverId+key;
			return key;
		}
	}
	
	/**
     * 自定义长度，最终以s开头，建议不低于8位。如果实际需要8位或<8位，需要注意！！！！！可能重复
     * ps:最多支持30位,当length<16时，请填（想要的位数后-2）的数值
     * @param length
     * @return
     */
    public static String getUniTransParam(int length){
        synchronized (xlock) {
            String key = getUniqueString(length);
            if (key.length() > length) {
                key = key.substring(key.length()-length-2, key.length());
            }
            key = "s"+serverId+key;
            return key;
        }
    }
	
    /**
     *  获取相应长度的唯一字符串
     * */
	private static String getUniqueString(int length) {
	    String uniTransParam = "";
	    String key1 = getUniqueString(); //获取唯一字符串1
	    
	    if (length < 14){
	        uniTransParam = key1.substring(key1.length()-length, key1.length());
	    } else {
	        String key2 = getUniqueString(); //获取唯一字符串2
	        int lengthTemp = 0;
	        if(length<16){
	            lengthTemp = 16 - length;
	        }else{
	            lengthTemp = length - 16;
	        }
	        uniTransParam = key1 + key2.substring(key2.length()-lengthTemp, key2.length());
	    }
	    
        return uniTransParam;
    }
	
    private static String getUniqueString(){
		SimpleDateFormat format = new SimpleDateFormat("YYMMddHHmmss");
		Date date = new Date();
		format.format(date);
		String key = System.currentTimeMillis()+"";
		
		if (!mlastKey.equals(key)) {
			mlastKey = key;
			mOrderIndex = 0;
		}
		mOrderIndex++;
		key += mOrderIndex;
		return key;
	}
	
	public static void main(String[] args) {
		
		String str = getUniTransParam(13);
		System.out.println(str.length());
		System.out.println(str);
	}
}
