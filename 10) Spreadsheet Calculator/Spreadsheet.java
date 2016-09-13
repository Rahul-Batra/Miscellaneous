import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Spreadsheet {
	
    private static final String fileName = "spreadsheet.txt";
    private static final String ADD = "+"; 
    private static final String SUB = "-";
    private static final String MUL = "*";
    private static final String DIV = "/";
    private static final String INC = "++";
    private static final String DEC = "--";
    private static HashMap<Character,Integer> map = new HashMap<Character,Integer>();    
    private static double compute(String input) {
        Stack<Double> stack = new Stack<>();
        String[] inputs = input.split(" ");
        return evaluation(stack, inputs);
    }
    
    private static double evaluation(Stack<Double> stack, String[] inputs) {
    	double operand1, operand2;
        for(int i = 0; i < inputs.length; i++) {
            if( inputs[i].equals(ADD) || inputs[i].equals(SUB) || inputs[i].equals(MUL) || inputs[i].equals(DIV)) {
                operand2 = stack.pop();
                operand1 = stack.pop();
                switch(inputs[i]) {
                    case ADD: {
                    	double local = operand1 + operand2;
                        stack.push(local);
                        break;
                    }
                    case SUB: {
                    	double local = operand1 - operand2;
                        stack.push(local);
                        break;
                    }
                    case MUL: {
                    	double local = operand1 * operand2;
                        stack.push(local);
                        break;
                    }
                    case DIV: {
                    	double local = operand1 / operand2;
                        stack.push(local);
                        break;
                    }                    
                }
            } else if(inputs[i].equals(INC) || inputs[i].equals(DEC)) {
            	operand1 = stack.pop();
                switch(inputs[i]) {
		            case INC: {
		            	double local = operand1 + 1;
		                stack.push(local);
		                break;
		            }
		            case DEC: {
		            	double local = operand1 - 1;
		                stack.push(local);
		                break;
		            }
               }
            } else {
                stack.push(Double.parseDouble(inputs[i]));
            }
        }
        return stack.pop();
    }

    
	public static void main(String[] args) {
		int p=0;
		for(char ch = 'A' ; ch <= 'Z'; ++ch) {
		    	map.put(ch,p); ++p;
		}
		FileReader fileReader = null;
		BufferedReader br = null;
		StringBuilder sb = null;
        try {
	    if (args!=null && args.length>0)
            fileReader = new FileReader(args[0]);
	    else 
	    fileReader = new FileReader(fileName);
            br = new BufferedReader(fileReader);
            int n = Character.getNumericValue(br.read());
            br.read();
            int m = Character.getNumericValue(br.read());
            br.read();
            System.out.println(n+" "+m);
            String[][] array = new String[m][n];
            for(int i=0; i<m; i++) {
            	for(int j=0; j<n; j++) {
            		array[i][j]= br.readLine();
            	}
            }
            for(int i=0; i<m; i++) {
            	for(int j=0; j<n; j++) {
            		sb = new StringBuilder();
            		String[] inputs = array[i][j].split(" ");
            		for(int k = 0; k < inputs.length; k++) {
            			if(map.get(inputs[k].charAt(0))!=null) {
            				sb.append(array[map.get(inputs[k].charAt(0))][Character.getNumericValue(inputs[k].charAt(1))-1]);
            			} else {
            				sb.append(inputs[k]);
            			}
            			if(k!=inputs.length-1)
            				sb.append(" ");
            		}
            		array[i][j]=sb.toString();
            		System.out.println(String.format("%.5f",compute(array[i][j])));
            	}
            }
            br.close();
        } catch (Exception e) {
        	e.printStackTrace();
        	System.out.println("Incorrect input");
        } 
		
	}
}
