import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tpe{
    public static void main(String[]args){
        int tiempoInicial=0;
        int deltaT=0; // maximo 100.000.000
        int caudalEntrada=0; // caudal entrada E
        int caudalSalida=0; // caudal salida S
        int areaTanque=0; // area transversal del tanque A
        int alturaTanque=0; // altura del tanque
        int alturaAguaTanque=0; // altura del agua en el tanque
        int volumenTotalTanque=0; // 
        int volumenAguaTanque=0; // V(t)
        // int alturaDeAgua=0; // h(t)
        int alturaDeAguaInicial=0; // h(ti)

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

            System.out.println("introduzca con que altura de agua comienza el tanque");
            alturaDeAguaInicial= new Integer (entrada.readLine());

            System.out.println("introduzca un caudal de entrada");
            caudalEntrada= new Integer (entrada.readLine());

            System.out.println("introduzca un caudal de salida");
            caudalSalida= new Integer (entrada.readLine());

            volumenTotalTanque = areaTanque * alturaTanque ;

            volumenAguaTanque= areaTanque * alturaAguaTanque;

            while((alturaAguaTanque<alturaTanque)&&(tiempoInicial<deltaT)){
                alturaAguaTanque = alturaDeAguaInicial +(caudalEntrada-caudalSalida)*tiempoInicial/areaTanque;
                tiempoInicial++;
                alturaDeAguaInicial=alturaAguaTanque;
            }
            System.out.println("el tanque se lleno a los "+ tiempoInicial+" segundos");
            // reseteo tiempo
            tiempoInicial=0;
            while(alturaAguaTanque>0){
                alturaAguaTanque = alturaDeAguaInicial +(0-caudalSalida)*tiempoInicial/areaTanque;
                tiempoInicial++;
                alturaDeAguaInicial=alturaAguaTanque;
            }
            System.out.println("el tanque se vació a los "+ tiempoInicial+" segundos");

        }
        catch(Exception exc){
            System.out.println("hubo un error");
        }
    }

}