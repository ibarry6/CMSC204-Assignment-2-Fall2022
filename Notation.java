import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Notation {

	public static int Operators(char object) {
		switch(object) {
		case '+':
		case '-':
			return 1;
			
		case '*':
		case '/':
			return 2;
			
		case '^':
			return 3;
		}
		return -1;
	}
	
	public static String convertInfixToPostfix(String complexInfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		MyStack<Character> stack = new MyStack<>(100);
		MyQueue<Character>queue=new MyQueue<>(100);
		int NumofCl=0;//closing parenthesis
		int NumofOp=0;//opening parenthesis
		
		char[] InfixIntoChars=complexInfix.toCharArray();
		
		for(int i=0; i<InfixIntoChars.length; i++) {
			if(Character.isLetterOrDigit(InfixIntoChars[i])) {
				try {
					queue.enqueue(InfixIntoChars[i]);
				} catch (QueueOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(InfixIntoChars[i]=='(') {
				try {
					stack.push(InfixIntoChars[i]);
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			NumofOp++;
			}
			else if(InfixIntoChars[i]=='+'||InfixIntoChars[i]=='-'||InfixIntoChars[i]=='*'||InfixIntoChars[i]=='/') {
				if(InfixIntoChars[i]=='-' || InfixIntoChars[i]=='+'){
					try {
						while(!stack.isEmpty()&&( stack.top()=='-'||stack.top()=='+'||stack.top()=='*'||stack.top()=='/')) {
							queue.enqueue(stack.pop());
						}
						stack.push(InfixIntoChars[i]);
					} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				else {
					try {
						while(!stack.isEmpty()&&(stack.top()=='*'||stack.top()=='/')){
							queue.enqueue(stack.pop());
						}
						stack.push(InfixIntoChars[i]);
					} catch (StackUnderflowException | QueueOverflowException | StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
			else if(InfixIntoChars[i]==')') {
				NumofCl++;
				try {
					while(stack.top()!='(' ) {
						queue.enqueue(stack.pop());
					}
					stack.pop();

				} catch (StackUnderflowException | QueueOverflowException    e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if (!Character.isLetterOrDigit(InfixIntoChars[i])&& InfixIntoChars[i]!='('&&InfixIntoChars[i]!=')'){
				throw new InvalidNotationFormatException();
			}
		}
		
		if(NumofCl!=NumofOp)
			throw new InvalidNotationFormatException();
		
		
		while(!stack.isEmpty()) {
			try {
				if(stack.top()=='('||stack.top()==')') {
					stack.pop();
				}
				
				else {
					try {
						queue.enqueue(stack.pop());
					} catch (QueueOverflowException | StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return queue.toString();
	}

	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack= new MyStack<>();

        char[] postfixIntoChars = postfix.toCharArray();

        for (int i = 0; i < postfixIntoChars.length; i++) {

            //operand
            if (Character.isLetterOrDigit(postfixIntoChars[i])) {
                try {
					stack.push(""+postfixIntoChars[i]);
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }

            //operator
            else if (postfixIntoChars[i]=='+'||postfixIntoChars[i]=='-'||postfixIntoChars[i]=='*'||postfixIntoChars[i]=='/') {

                //throw an error because we should have at 2 operands if we have 1 operator
                if (stack.size() < 2) {
                    throw new InvalidNotationFormatException();
                }
                else {
					try {
						 String pop1,pop2;
						 pop1 = stack.pop();
						 pop2 = stack.pop();
		                 stack.push("(" + pop2 + postfixIntoChars[i] + pop1 + ")");
					} catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            }
      }
        return stack.toString();

	}

	public static double evaluatePostfixExpression(String postfix) throws InvalidNotationFormatException {
		// TODO Auto-generated method stub
		MyStack <String> evaluatePostfix= new MyStack<String>();

	       
		for(int i=0; i<postfix.length(); i++){

	           
			if(postfix.charAt(i)==' '){
				continue;
			}
	            
	        if(Operators(postfix.charAt(i))!=-1){
	
                if(evaluatePostfix.size()<2){
                    throw new InvalidNotationFormatException();
                }              
                else{
                	
					try {
						
						String first;
						first = evaluatePostfix.pop();
		                String second= evaluatePostfix.pop();
	
	                   int value1= Integer.parseInt(first);
	                   int value2= Integer.parseInt(second);

	                    if (postfix.charAt(i) == '+') {
	                        int result= value1 + value2;
	                        evaluatePostfix.push(""+result);
	                    }

	                    if (postfix.charAt(i) == '-') {
	                        int result= value2 - value1;
	                        evaluatePostfix.push(""+result);
	                    }

	                    if (postfix.charAt(i) == '*') {
		                    int result= value1 * value2;
		                    evaluatePostfix.push(""+result);
	                    }

	                    if (postfix.charAt(i) == '/') {
	                        int result= value2 / value1;
	                        evaluatePostfix.push(""+result);
	                    } 
	                    
					}catch (StackUnderflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					
		            } catch (StackOverflowException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
             

        	}
	            
            else {
                try {
					evaluatePostfix.push(""+postfix.charAt(i));
				} catch (StackOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
	        
        }

        if(evaluatePostfix.size()==1){
            return Double.parseDouble(evaluatePostfix.toString());
        }
        else{
            throw new InvalidNotationFormatException();
        }
	   
	}

}