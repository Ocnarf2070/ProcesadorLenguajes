package prCalculadora;

import java.util.Arrays;
import java.util.Stack;

public class BinaryExpressionTree {
	private static class Tree<E>{
		E expr;
		Tree<E> left;
		Tree<E> right;
		public Tree(E expr) {
			this.expr=expr;
			left=null;
			right=null;
		}
		public Tree(E expr, Tree<E> left, Tree<E> right) {
			this.expr=expr;
			this.left=left;
			this.right=right;
		}
		
		public StringBuilder toString(StringBuilder prefix, boolean isTail, StringBuilder sb) {
		    if(right!=null) {
		        right.toString(new StringBuilder().append(prefix).append(isTail ? "|    " : "     "), false, sb);
		    }
		    sb.append(prefix).append(isTail ? "|--- " : "|--- ").append(expr.toString()).append("\n");
		    if(left!=null) {
		        left.toString(new StringBuilder().append(prefix).append(isTail ? "     " : "|    "), true, sb);
		    }
		    return sb;
		}

		@Override
		public String toString() {
		    return this.toString(new StringBuilder(), true, new StringBuilder()).toString();
		}
	}

	private Tree <String> root;	
	private String [] fp;
	private int pos,ind;
	private Stack<Tree<String>> st;
	private int pa,pc;
	
	public BinaryExpressionTree()  {
		root=null;
		fp=new String [10];
		pos=0;
		ind=0;
		st=new Stack<Tree<String>>();
		pa=0;
		pc=0;
	}

	private boolean isEmpty() {
		return root == null;
	}
	
	private static boolean signoValido(String elem) {
		// TODO Auto-generated method stub
		return elem.equals("+") || elem.equals("-") || elem.equals("/")|| elem.equals("*");
	}
	
	private void vaciarPila() {
		// TODO Auto-generated method stub
		while(!st.isEmpty()) {
			Tree<String> aux=st.pop();
			if(isEmpty())root=aux;
			else if(signoValido(aux.expr)&&aux.right==null) {
				aux.right=root;
				root=aux;
			}else {
				root.left=aux;
			}
		}
	}
	
	
	private Tree<String> binExpTree(String [] ops){
		boolean MulDiv=false;
		while(ops[ind]!=null) {
			String elem=ops[ind];
			if(elem.equals("(")) {
				pa++;
				st.push(new Tree<String>(elem));
				ind++;
				root=binExpTree(ops);
			}
			if(MulDiv) {
				Tree<String> op = st.pop();
				Tree<String> exp1=st.pop();
				Tree<String> exp2;
				if(isEmpty())exp2=new Tree<String>(elem);
				else {
					exp2=root;
					root=null;
				}
				op.left=exp1;op.right=exp2;
				st.push(op);
				MulDiv=false;
			}else if(elem.equals(")")) {
				pc++;
				Tree<String> aux=st.pop();
				while(!aux.expr.equals("(")){
					if(isEmpty())root=aux;
					else if(signoValido(aux.expr)&&aux.right==null) {
						aux.right=root;
						root=aux;
					}else {
						root.left=aux;
					}
					aux=st.pop();
				}
				break;
			}else {
				if(!isEmpty()) {
					st.push(root);
					root=null;
				}else {
				st.push(new Tree<String>(elem));
				if(elem.equals("*")||elem.equals("/"))MulDiv=true;
				}
			}
			ind++;
		}
		if(ops[ind]==null)vaciarPila();
		return root;
	}

	

	public String [] formaPolaca (String [] ops) {
		try{
			return formaPolacaRec(binExpTree(ops));
		}catch(NullPointerException ee) {
			ee.printStackTrace();
			throw new IllegalArgumentException();
		}
	}
	private String [] formaPolacaRec(Tree<String> tree) {
		if(tree != null) {
			formaPolacaRec(tree.left);
			formaPolacaRec(tree.right);
			if(pos==fp.length)fp=Arrays.copyOf(fp, pos * 2);			
			fp[pos] = tree.expr;
			pos++;
		}

		return fp;
	}
	
	
}