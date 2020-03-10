package utils;

import java.text.DecimalFormat;

public class DecimalFormatUtil {


    /**
     * 两个整数相除转换成百分比格式显示:(num1/num2)%
     * */
    public static String signFormat(int num1,int num2) {
         
         String str = "0.00";
         
         if(num1 != 0 && num2 != 0){
             
             DecimalFormat df = new DecimalFormat("0.00");//格式化小数，不足的补0
             
             float res = (float)num1/num2*100;
             
             str = df.format(res); 
             
         }
         
         str += "%";
         
         return str;
    }
    

    /**
     * 将分转换为元
     * */
    public static Integer fenToYuanStr(Integer num) {
        
        String str = "0";
        
        if(null != num && num != 0){
            
        DecimalFormat df = new DecimalFormat("0");//格式化小数，不足的补0 
        
        float res = ((float)num)/100;
        
        str = df.format(res);
        
        }
        
        return Integer.valueOf(str);
        
    }
    
    /**
     * 根据转发数，成功数，计算扣量比例
     * 100-转发/成功
     * @param sucNum 
     * @param transNum 
     * @return
     */
    public static String deductionRate(Integer transNum, Integer sucNum) {
        
        String str = "0";
        if(0 != transNum && 0!= sucNum){
            float f1 = Float.valueOf(transNum);
            float f2 = Float.valueOf(sucNum);
            DecimalFormat df = new DecimalFormat("0.00");//格式化小数，不足的补0 
            float res = 100 - f1/f2*100;
            str = df.format(res); 
        }
        str = Float.valueOf(str)+"%";
        
        return str;
    }

	/**
	 * num1/num2,取两位小数
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static Float divFormat(int num1,int num2) {
	 String str = "0";
	 if(num2 != 0){
		 DecimalFormat df = new DecimalFormat("0.00");//格式化小数，不足的补0 
		 float res = (float)num1/num2;
		 str = df.format(res); 
	 }
	 
	 return Float.valueOf(str);
	}
	
}
