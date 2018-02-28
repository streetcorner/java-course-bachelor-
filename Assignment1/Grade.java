public class Grade{
	public static void main(String args[]){
		int[] g = {95,72,88,64,65};
		int len = g.length;
		char grade;
		int i = 0;
		while(i < len)
		{
			if(g[i] > 89){
				grade = 'A';
			}	
			else if(g[i] > 79){
				grade = 'B';
			}
			else if(g[i] > 69){
				grade = 'C';
			}
			else if(g[i] > 59){
				grade = 'D';
			}
			else{
				grade = 'E';
			}
			System.out.println("score: " +g[i] +"    grade: " +grade);
			i++;
		}
	}
}