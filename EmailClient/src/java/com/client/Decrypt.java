package com.client;

public class Decrypt {
    static String decipher="";
 public static String generate(String temp,String key){
     char[] ch = temp.toCharArray();
		int count =0;
		for(int i=0;i<ch.length;i++){
			if(ch[i]=='/'){count++;}
		}
		System.out.println(count);
		int [] str2=new int[count];
		count=0;
		int i=0;
		while(count<ch.length){
			char c = ch[count];
			int f=1;
			int num=0;
			while(c!='/'){
				num=num+f*((int)c-48);
				f*=10;
				count++;
				c=ch[count];
			}
			str2[i]=num;
			i++;
			count++;
		}
		char[] e_key = key.toCharArray();
		int [] i_key = new int[key.length()];
		int [] s , t;
		s=new int[256];
		t=new int[256];
		for(i=0;i<key.length();i++){
			i_key[i] = (int)e_key[i];
		}
		for(i=0;i<256;i++){
			s[i]=i;
			t[i]=i_key[i%key.length()];
		}
		int j=0;
		for(i=0;i<256;i++){
			j=(j+s[i]+t[i]) % 256;
			s[i]=s[i]+s[j];
			s[j]=s[i]-s[j];
			s[i]=s[i]-s[j];
		}
		int l;
		i=l=j=0;
                decipher="";
		while(l!=str2.length){
			i = (i+1)%256;
			j=(j+s[i])%256;
			s[i]=s[i]+s[j];
			s[j]=s[i]-s[j];
			s[i]=s[i]-s[j];
			decipher+=(char)(str2[l]^s[(s[i]+s[j])%256]);
			l++;
		}
		return decipher;
 }    
}
