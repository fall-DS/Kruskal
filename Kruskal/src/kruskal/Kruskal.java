package kruskal;
/**
 * Programa que aplica el algoritmo Kruskal para encontrar un arbol de peso minimo a partir de un grafo pesado.
 * @version 1.0
 * @author fall
 */
class Kruskal{
    private int numVertices,vi,vf,min,totalPeso=0;
    private int [] padres;
    private int [][] matrix;    
Kruskal(int vertices){
numVertices=vertices;
matrix = new int [vertices][vertices];
padres = new int [vertices];
vi=0;
vf=0;
    }
boolean hayCiclos(Kruskal a){
while(a.padres[a.vi]!=0){
    a.vi=a.padres[a.vi];
}
while(a.padres[a.vf]!=0){
    a.vf=a.padres[a.vf];
}
if(a.vi!=a.vf){    
    a.padres[a.vi]=a.vf;
    return false;
}
else
    return true;
}
void addyacencia(int vi,int vf,int peso){
matrix[vi-1][vf-1]=peso;
matrix[vf-1][vi-1]=peso;
}
void impr(Kruskal a){
    for(int j=0;j<numVertices;j++){
        System.out.print("\n");
            for(int i=0;i<numVertices;i++){
    System.out.print(a.matrix[j][i]+"\t");
    }
            
    }
    System.out.println("\n");
    }
void min(Kruskal a){
    min=95;
    for(int i=0;i<numVertices;i++){
        for( int j=0;j<numVertices;j++){
        if(a.matrix[i][j]>0 && a.matrix[i][j]<min){
            min=a.matrix[i][j];
         a.vi=i;
         a.vf=j;
       }
    }
    }
}
 public static void main(String[] args) {
     int v=10,k=0;
     Kruskal g = new Kruskal(v);
     Kruskal b = new Kruskal(v);
     Kruskal kruskal = new Kruskal(v);
     Kruskal Arbol = new Kruskal(v);     
        g.addyacencia(2,4,10);
        g.addyacencia(1,9,12);
        g.addyacencia(4,6,13);
        g.addyacencia(1,2,20);
        g.addyacencia(5,3,20);
        g.addyacencia(5,9,20);
        g.addyacencia(5,6,24);
        g.addyacencia(1,3,25);
        g.addyacencia(6,7,35);
        g.addyacencia(9,10,36);
        g.addyacencia(3,4,39);
        g.addyacencia(2,8,50);
        g.addyacencia(1,8,60);
        g.addyacencia(7,8,80);
        g.addyacencia(4,8,90);
        g.addyacencia(10,6,95);
        System.out.println("\n");  
         System.out.println("APM mediante el algoritmo de Kruskal - calcularemos el árbol de peso mínimo de la siguiente matriz: \n");
         g.impr(g);
        b=g;
        while(k<(g.numVertices-1)){
            b.min(b);
            kruskal.vi=b.vi;
            kruskal.vf=b.vf;
            if(b.hayCiclos(b)==false){
                System.out.println("El minimo sin cíclo tiene coordenadas en:  ("+(kruskal.vi+1)+","+(kruskal.vf+1)+") y es: "+b.min);
                b.totalPeso+=b.min;
                kruskal.matrix[kruskal.vi][kruskal.vf]=1;
                kruskal.matrix[kruskal.vf][kruskal.vi]=1;
                Arbol.matrix[kruskal.vi][kruskal.vf]=b.min;
                Arbol.matrix[kruskal.vf][kruskal.vi]=b.min;
                k++;         
                     }
            else{
                b.min(b);
            }            
            b.matrix[b.vi][b.vf]=0;
            b.matrix[b.vf][b.vi]=0;
        }
        System.out.println("\n    MATRIZ DE ADYACENCIA RESULTADO DEL ALGORITMO KRUSKAL    \n");
        kruskal.impr(kruskal);
        System.out.println("    ÁRBOL DE PESO MÍNIMO ENCONTRADO CON EL ALGORITMO KRUSKAL    \n");
        Arbol.impr(Arbol); 
        System.out.println("\n El peso total del árbol es de: "+b.totalPeso);
 }
}

