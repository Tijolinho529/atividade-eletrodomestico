/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package modelo;

/**
 *
 * @author aluno.den
 */
public class Eletrodomestico {
    private int id;
    private String nome;
    private String marca;
    private String voltagem;
    private double preco;
    
    public Eletrodomestico() {
        
    }

    // Getters e Setters
    public Eletrodomestico(int id, String nome, String marca, String voltagem, double preco){
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.voltagem = voltagem;
        this.preco = preco;
   
    }    
        
    public int getId(){
    return id;
}
    
    public String getNome(){
        return nome;
    }
    
    public String getMarca(){
        return marca;
    }
    
    public String getVoltagem(){
        return voltagem;
    }
    
    public double getPreco(){
        return preco;
    }
    
     public void setId(int id){
        this.id = id;
    }
     
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public void setMarca(String marca){
        this.marca = marca;
    }
    
    public void setVoltagem(String voltagem){
        this.voltagem = voltagem;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
}
