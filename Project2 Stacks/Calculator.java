public class Calculator {
    public String ConvertInfixToPostfix(String infix){
        ResizableArrayStack<Character> operator = new ResizableArrayStack<Character>(infix.length());
        String postFix="";
        Character operant;
        if(infix.length()>0){
            for(int i=0; i<infix.length();i++){
                operant = infix.charAt(i);
                if(operant==' '){
                continue;
                }
                if(Character.isLetterOrDigit(operant)){
                    postFix+= Character.toString(operant);
                } else {
                    if(!operator.isEmpty()){
                        if(operant=='('){
                        operator.push(operant);
                        } else {
                            if(operator.peek()!='(' && operator.peek()!=')')
                                postFix+= Character.toString(operator.peek());
                            operator.pop();
                            operator.push(operant);
                        }
                    } else {
                        operator.push(operant);
                    }
                }

            }
        
        }
        while(!operator.isEmpty()){
            if(operator.peek()!='(' && operator.peek()!=')')
                postFix+= Character.toString(operator.peek());

            operator.pop();
        }
        return postFix;
    }
}
