package calcFormaPolaca;

public class Calc {
	private static int res(String [] fp) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		while(i<fp.length) {
			if(fp[i] == "+") {
				int exp2 = stack.top();
				stack.pop();
				int exp1 = stack.top();
				stack.pop();
				stack.push(exp1+exp2);
			}else if(fp[i] == "-") {
				int exp2 = stack.top();
				stack.pop();
				int exp1 = stack.top();
				stack.pop();
				stack.push(exp1-exp2);
			}else if(fp[i] == "*") {
				int exp2 = stack.top();
				stack.pop();
				int exp1 = stack.top();
				stack.pop();
				stack.push(exp1*exp2);
			}else if(fp[i] == "/") {
				int exp2 = stack.top();
				stack.pop();
				int exp1 = stack.top();
				stack.pop();
				if(exp2 == 0)throw new IllegalArgumentException("el denominador no debe ser 0");
				else stack.push(exp1/exp2);
			}else stack.push(Integer.parseInt(fp[i]));
			i++;
		}
		return stack.top();
	}
	public static void main(String[] args) {
		String [] fp = {"3","-2", "6","4","+","+","+","8","/","6","+"};
		System.out.println(Integer.parseInt("-1")+" "+res(fp));
	}
}
