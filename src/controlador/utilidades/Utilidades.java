
package controlador.utilidades;

import java.awt.Toolkit;
import javax.swing.JTextField;
import org.apache.commons.lang.StringUtils;

/**
 * La clase proveer bastantes metodos para la validacion como los metedos
 * heredados de la clase StringUtis
 *
 * @author luis villalta
 * @version:18/08/2018
 */
public class Utilidades extends StringUtils {

    
    /**
     * Este metodo sirve para validar los campos de la cedula
     *
     * @param cedula atributo requerido necesarion para obtencion de la
     * validacion de la cedula
     * @return se encarga de devolver un valor booleano si se cumple con el
     * metodo
     *
     */
    public static boolean validadorDeCedula(String cedula) {
        boolean cedulaCorrecta = false;

        try {

            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
// Coeficientes de validación cédula
// El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = {2, 1, 2, 1, 2, 1, 2, 1, 2};
                    int verificador = Integer.parseInt(cedula.substring(9, 10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1)) * coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }

                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    } else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            System.out.println("Una excepcion ocurrio en el proceso de validadcion");
            cedulaCorrecta = false;
        }

        if (!cedulaCorrecta) {
            System.out.println("La Cédula ingresada es Incorrecta");
        }
        return cedulaCorrecta;

    }//Cierre del metodo 



    
    /**
     * Este metodo sirve redondear datos de tipo Double
     *
     * @param valorInicial Valor de tipo Double que se desea redondear
     * @param numeroDecimales Valor de los decimales que se desea que tenga el numero inicial
     * @return se encarga de devolver un valor booleano si se cumple con el
     * metodo
     *
     */
    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, numeroDecimales);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, numeroDecimales))+parteEntera;
        return resultado;
    }//Cierre del metodo
    
} //Cierre de la clase
