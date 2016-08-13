
package com.client;

import java.util.Random;
    public class CaptchaGenerate {
                private int random(int val){
			int rand=0;
			Random obj = new Random();
			for(int i=0;i<obj.nextInt(5000);i++){
				for(int j=0;j<obj.nextInt(i+1);j++){
					for(int k=0;k<obj.nextInt(j+i);k++){
							rand=obj.nextInt(val);
					}
					
				}
			}
			return rand;
		}
		protected String captcha(){
		char[] alpha={'a','A','b','B','c','C','d','D','e','E','f','F','g','G','h','H','i','I','j','J','k','K',
					'l','L','m','M','n','N','o','O','p','P','q','Q','r','R','s','S','t','T','u','U','v','V','w','W','x','X','y','Y','z','Z'};
		int[] num={0,1,2,3,4,5,6,7,8,9};
		int choice=0,index=0,len=6;
		String str = new String();
		while(len!=0){
			choice=random(2);
		if (choice==0){
			index=random(52);
			str+=alpha[index];
		}
		if (choice==1){
			index=random(10);
			str+=num[index];
		}
		--len;
		}
		return str;
	}
	
}    


