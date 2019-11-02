import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tpe{
    public static void main(String[]args){
        int deltaT;
        int H=0; // altura columna de agua
        int caudalEntrada=0; // caudal entrada E
        int caudalSalida=0; // caudal salida S
        int areaTanque=0; // area transversal del tanque A
        int alturaTanque=0; // altura del tanque
        int volumenTotalTanque=0; //
        int volumenAguaTanque=0;
        int alturaDeAgua=0; // h(t)

        // System.out.println("hola");
        try{
            BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));

            System.out.println("introduzca un tiempo");
            deltaT= new Integer (entrada.readLine());
            System.out.println("su numero es el "+deltaT);
            
            System.out.println("introduzca un valor para el area del tanque");
            areaTanque= new Integer (entrada.readLine());

            System.out.println("introduzca un valor para la altura del tanque");
            alturaTanque= new Integer (entrada.readLine());

            System.out.println("introduzca un caudal de entrada");
            caudalEntrada= new Integer (entrada.readLine());

            System.out.println("introduzca un caudal de salida");
            caudalSalida= new Integer (entrada.readLine());

            volumenTotalTanque = areaTanque * alturaTanque ;
            
            volumenAguaTanque= areaTanque * alturaDeAgua;

        }
        catch(Exception exc){
            System.out.println("hola");
        }
    }

}