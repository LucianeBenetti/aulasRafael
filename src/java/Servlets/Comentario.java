package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Date;

/**
 *
 * @author Aluno
 */
public class Comentario {
    private String login;
    private String data;
    private String titulo;
    private String comentario;
    private Date dt;

    
    
    public Comentario(String login, String data, String titulo, String comentario){
        this.login=login;
        this.titulo=titulo;
        this.data=data;
        this.comentario=comentario;
        //12/03/2019 19:17
        String[] parts= data.split(" ");
        String dataTxt=parts[0];
        String timeTxt=parts[1];      
        System.out.println(dataTxt);
        String[] dataParts= dataTxt.split("/");
        String[] timeParts= timeTxt.split(":");
        int year= Integer.parseInt(dataParts[2]);
        int month= Integer.parseInt(dataParts[1]);
        int day= Integer.parseInt(dataParts[0]);
        int hour= Integer.parseInt(timeParts[0]);
        int minute= Integer.parseInt(timeParts[1]);
        dt= new Date(year, month, day, hour, minute);              
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    
    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }
    
    
    
}
