package Ch11.doyul.Example;

import java.util.*;

public class ExpValidCheck {
	public static void main(String[] args) {
	     if(args.length!=1){
               System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
               System.out.println("Example : java ExpValidCheck \"((2+3)*1)+3\"");		  
			   System.exit(0);			
	     }
		
		Stack st = new Stack();
		String expression = args[0];
		
		System.out.println("expression:"+expression);
		// expression을 for문을 통해 탐색하면서
		// '(' 가 있으면 stack에 push, ')'가 있으면 pop한다.
		// 진행 후 stack이 비어있으면 괄호가 서로 일치, 아니라면 서로 불일치.
		//
		try {
			for(int i=0; i < expression.length();i++){
				char ch = expression.charAt(i); 
				
				if(ch=='('){
					st.push(ch+"");
				} else if(ch==')') {
					st.pop();
				}
			}
			
			if(st.isEmpty()){
				System.out.println("괄호가 일치합니다.");
			} else {
				System.out.println("괄호가 일치하지 않습니다.1");
				// '('가 더 많으면 위 문장 실행
			}
		// ')'가 더 많으면 아래 catch 문에 걸리게 됨
		} catch (EmptyStackException e) {
			System.out.println("괄호가 일치하지 않습니다.2");
		} // try
	}
}
