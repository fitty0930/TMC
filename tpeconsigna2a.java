import java.io.BufferedReader;
import java.io.InputStreamReader;

public class tpeconsigna2a{
    public static void main(String[]args){
        double tiempoInicial=0;
        double intervaloTiempo=0;
        double maxTiempo=100000000; // maximo 100.000.000
        double caudalEntrada=0; // caudal entrada E
        // double caudalSalida=0; // caudal salida S
        double areaTanque=0; // area transversal del tanque A
        double alturaTanque=0; // altura del tanque
        double alturaAguaTanque=0; // altura del agua en el tanque
        double volumenTotalTanque=0; // 
        double volumenAguaTanque=0; // V(t)
        // int alturaDeAgua=0; // h(t)
        double alturaDeAguaInicial=0; // h(ti)
        boolean pasaMitad=false;
        double modifCaudal=0;
        

        try{
            BufferedReader entrada= new BufferedReader(new InputStreamReader(System.in));

            do{
                System.out.println("introduzca un valor para el intervalo de tiempo");
                intervaloTiempo= new Double (entrada.readLine());
            }while(intervaloTiempo<=0);
                
            do{
                System.out.println("introduzca un valor para el area del tanque");
                areaTanque= new Double (entrada.readLine());
            }while(areaTanque<=0);
    
            do{
                System.out.println("introduzca un valor para la altura del tanque");
                alturaTanque= new Double (entrada.readLine());
            }while(alturaTanque<=0);
    
            do{
                System.out.println("introduzca con que altura de agua comienza el tanque");
                alturaDeAguaInicial= new Double (entrada.readLine());
            }while((alturaDeAguaInicial<0)||(alturaDeAguaInicial>alturaTanque));

            do{
            System.out.println("introduzca un caudal de entrada");
            caudalEntrada= new Double (entrada.readLine());
            }while(caudalEntrada<0);

            do{
            System.out.println("introduzca un modif de caudal de salida");
            System.out.println("el caudal de salida final sera modif*t");
            modifCaudal= new Double (entrada.readLine());
            }while(modifCaudal<0);

            volumenTotalTanque = areaTanque * alturaTanque ;
            System.out.println("su tanque tiene un volumen total de: "+volumenTotalTanque);

            volumenAguaTanque= areaTanque * alturaAguaTanque;

            //llenado
            while((alturaAguaTanque<alturaTanque)&&(tiempoInicial<(intervaloTiempo*maxTiempo))){
                alturaAguaTanque = alturaDeAguaInicial +(caudalEntrada-(modifCaudal*tiempoInicial))*intervaloTiempo/areaTanque;
                tiempoInicial+=intervaloTiempo;
                alturaDeAguaInicial=alturaAguaTanque;
                // System.out.println(tiempoInicial); 
                
                // informador c/2
                        if (alturaAguaTanque >= (alturaTanque/2) && pasaMitad==false){
                            System.out.println("se supero la mitad del tanque");
                            System.out.println("altura "+alturaDeAguaInicial +"mts");
                            System.out.println("a los "+tiempoInicial+" segundos");
                            pasaMitad=true;
                        }
                // para ajustar correctamente el llenado
                        if (alturaAguaTanque >= alturaTanque){
                            // tanque lleno
                            alturaAguaTanque = alturaTanque;
                            alturaDeAguaInicial=alturaAguaTanque; 
                        };

                        if (alturaAguaTanque < 0){
                            // tanque vacio
                            alturaAguaTanque = 0;
                            alturaDeAguaInicial=0; 
                        };
            }
            
                if(alturaAguaTanque == alturaTanque){
                    System.out.println("el tanque se lleno a los "+ tiempoInicial+" segundos");
                    // reseteo tiempo
                    tiempoInicial=0;
                    // vaciado
                    
                    while(alturaAguaTanque>0 &&(tiempoInicial<(intervaloTiempo*maxTiempo))){
                        alturaAguaTanque = alturaDeAguaInicial +(0-(modifCaudal*tiempoInicial))*intervaloTiempo/areaTanque;
                        tiempoInicial+=intervaloTiempo;
                        alturaDeAguaInicial=alturaAguaTanque;
                    }
                    if(alturaAguaTanque<=0){
                    System.out.println("el tanque se vació a los "+ tiempoInicial+" segundos");}
                    else{System.out.println("se alcanzó la simulación máxima y su tanque no se vació por completo");}
                }
                else if (alturaAguaTanque<alturaTanque){
                    // System.out.println(alturaDeAguaInicial);
                    volumenAguaTanque= areaTanque * alturaAguaTanque;
                    System.out.println("su tanque no se lleno, solo alcanzó los "+volumenAguaTanque+" m3");
                    tiempoInicial=0;
                    // vaciado
                    
                    if(alturaAguaTanque>0 ){
                        while(alturaAguaTanque>0 &&(tiempoInicial<(intervaloTiempo*maxTiempo))){
                            alturaAguaTanque = alturaDeAguaInicial +(0-(modifCaudal*tiempoInicial))*intervaloTiempo/areaTanque;
                            tiempoInicial+=intervaloTiempo;
                            alturaDeAguaInicial=alturaAguaTanque;
                        }
                        if(alturaAguaTanque<=0){
                        System.out.println("el tanque se vació a los "+ tiempoInicial+" segundos");}
                        else{System.out.println("se alcanzó la simulación máxima y su tanque no se vació por completo");}
                    }

                }
            
            

        }
        catch(Exception exc){
            System.out.println("hubo un error al ingresar valores");
        }
    }


}