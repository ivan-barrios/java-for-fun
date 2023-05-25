package ejercicio3;

public class TestTablet {

	public static void main(String[] args) {
		Tablet[] tabletArr = new Tablet[3];
		tabletArr[0] = new Tablet("samsung", "windows", "modelito", 390, 18);
		tabletArr[1] = new Tablet("apple", "ios", "modelito", 390, 18);
		tabletArr[2] = new Tablet("glg", "glgOS", "modelito", 390, 18);
	
		for (int i = 0; i < tabletArr.length; i++) {
			String datos = tabletArr[i].devolverDatos();
			System.out.println(datos);
		}
	
	}

}
