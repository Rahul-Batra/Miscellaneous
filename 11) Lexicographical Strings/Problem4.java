public class Problem4 {

	 public static int solution(String s) {
		 int counter = s.split("/").length;
		 int i,loc=0,flag=0,len=0;
		 String[] result = new String[counter];
		 result = s.split("/");
		 for (i=0; i<counter;i++)
		 {
			 if (result[i].contains("jpeg") || result[i].contains("gif") || result[i].contains("png")){
				 		loc=i;flag=1;break;		 
			 }
			 if(flag==1) break;
		 }
		  		 for (i=0; i<loc+1; i++)
		 {
			 len += result[i].length();
		 }
		 return len;
		 
	 }
	 public static void main(String args[]){
		 String s = "/dir1/dir2/dir3/Picture.jpeg/dir5";
		 System.out.println(solution(s));
	 }
}
