/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsp;

import static bsp.Segmento.ATRAS;
import static bsp.Segmento.FRENTE;
import java.awt.Polygon;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSPTree {
   
    BSPTree frente,atras;
    Poligono raiz;
    
    public BSPTree(ArrayList<Poligono> poligono){
        ArrayList<Poligono> polFrente,polAtras;
        polFrente = new ArrayList<>();
        polAtras = new ArrayList<>();
       
        raiz = poligono.get(0);
        if(poligono.isEmpty()){
            return;
        }
       
        for(int i =0;i < poligono.size();i++){
            Poligono temp = poligono.get(i);
            if(temp.equals(raiz))poligono.remove(i);
            
            if(raiz.retaSuperior.checarInterseccao(raiz.retaSuperior, temp.retaSuperior) != null){
                ArrayList<Poligono> quebraPoligono =  raiz.retaSuperior.checarInterseccao(raiz.retaSuperior, temp.retaSuperior);
                poligono.remove(i);
                poligono.add(quebraPoligono.get(0));
                poligono.add(quebraPoligono.get(1));
            }
            if(raiz.retaSuperior.posicaoSegmento(temp.retaSuperior) == FRENTE ){
                polFrente.add(temp); 
            }else if(raiz.retaSuperior.posicaoSegmento(temp.retaSuperior) == ATRAS){
                polAtras.add(temp);
            }
        }
        
        //if(!polFrente.isEmpty()){
        //    frente = new BSPTree(polFrente);
        //}else frente = null;
        //if(!polAtras.isEmpty()){
         //   atras = new BSPTree(polAtras);
        //}else atras = null; 
    }
    
    public void montaArvoreRecursivamente(ArrayList<Poligono> lista){
        if(lista.isEmpty()){
            return;
            }
        Random r = new Random();
        int a = r.nextInt(lista.size());
        //Pega o conteudo da posicao r do array
        if(this.raiz == null){
            
            lista.remove(a);
        }
        else{
            //Verifica se esta a frente ou atras
            if(){
                this.frente = lista.get(a);
                lista.remove(a);
            }
            else if(){
                this.tras = new Poligono(lista.get(a));
                lista.remove(a);
            }
        }
        montaArvoreRecursivamente(lista);
    }
    
    public int retornaBranchLivre(){
        //Retorna 0 se não há branchs livres
        //Retorna 1 se o branch de tras esta livre
        //Retorna 2 se o branch da direita esta livre
        //Retorna 3 se os dois estao livres
        // Tem que fazer a traversal
        if(this.atras.raiz == null && this.frente.raiz == null){
            return 3;
        }
        if(this.atras.raiz == null){
            return 1;
        }
        else if(this.frente.raiz == null){
            return 2;
        }
        else{
            return 0;
        }
    }
}
