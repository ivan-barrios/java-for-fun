package prog3.util;

public class TestBalanceo {

	public static void main(String[] args) {
		String myString = "()[()]";
		System.out.println(verificarArmonia(myString));
	}

	public static boolean verificarArmonia(String myString) {
		Pila<Character> pila = new Pila<Character>();
		for (int i = 0; i < myString.length(); i++) {
			char c = myString.charAt(i);
			if (c == '{' || c == '[' || c == '(') {
				pila.apilar(c);
			} else if (c == '}' || c == ']' || c == ')') {
				if (pila.esVacia()) return false;
				char top = pila.desapilar();
				if ((c == '{' && top != '}') || (c == '[' && top != ']') || (c == '(' && top != ')') ) {
					return false;
				}
			}
		}
		return pila.esVacia();
	}

}
