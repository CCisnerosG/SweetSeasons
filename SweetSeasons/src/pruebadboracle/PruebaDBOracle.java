package pruebadboracle;

public class PruebaDBOracle {

    public static void main(String[] args) {
        //Para que inicie el programa
        Inicio();
    }
    
    public static void Inicio() {
        frmLogin inicio = new frmLogin();
        inicio.setLocationRelativeTo(null); // Esto centra el form en la pantalla al ejecutarse.
        inicio.setVisible(true); // Esto hace visible el form.
    }
    
    
}
