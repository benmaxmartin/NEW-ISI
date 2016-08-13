package com.client;

public class Encrypt {
    static String str1=""; 
    public static String generate(String simple_text,String key){
     char[] text = simple_text.toCharArray();
		char[] e_key = key.toCharArray();
                int [] temp = new int [simple_text.length()];
		int [] i_text = new int[simple_text.length()];
		int [] i_key = new int[key.length()];
		int [] s , t;
		s=new int[256];
		t=new int[256];
		for(int i=0;i<simple_text.length();i++){
			i_text[i] = (int)text[i];
		}
		for(int i=0;i<key.length();i++){
			i_key[i] = (int)e_key[i];
		}
		for(int i=0;i<256;i++){
			s[i]=i;
			t[i]=i_key[i%key.length()];
		}
		int j=0;
		for(int i=0;i<256;i++){
			j=(j+s[i]+t[i]) % 256;
			s[i]=s[i]+s[j];
			s[j]=s[i]-s[j];
			s[i]=s[i]-s[j];
		}
		int i,l;
		i=l=j=0;
		while(l!=simple_text.length()){
			i = (i+1)%256;
			j=(j+s[i])%256;
			s[i]=s[i]+s[j];
			s[j]=s[i]-s[j];
			s[i]=s[i]-s[j];
			temp[l]=i_text[l]^s[(s[i]+s[j])%256];
			l++;
		}
                str1="";
		for(i=0;i<temp.length;i++){
			int val=temp[i];
			while(val!=0){
				int d = val%10;
				d=d+48;
				char ch = (char)d;
				str1 +=ch;
				val/=10;
			}
			str1 += '/';
		}   return str1;
 }    
}
