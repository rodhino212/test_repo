package io.github.rodhino212.essaie;

import java.io.Serializable;

public class Operation implements Serializable {

    private int op_id ;
    private String op_description ;
    private String op_date ;
    private Float op_montant ;
    private String pointee ;
    private String frequence ;
    private String type ;
    private String categorie ;
    private int user_id_op ;

    public int getOp_id() {
        return this.op_id;
    }

    public void setOp_id(int op_id) {
        this.op_id = op_id;
    }

    public String getOp_description() {
        return this.op_description;
    }

    public void setOp_description(String op_description) {
        this.op_description = op_description;
    }

    public String getOp_date() {
        return this.op_date;
    }

    public void setOp_date(String op_date) {
        this.op_date = op_date;
    }

    public Float getOp_montant() {
        return this.op_montant;
    }

    public void setOp_montant(Float op_montant) {
        this.op_montant = op_montant;
    }

    public String getPointee() {
        return this.pointee;
    }

    public void setPointee(String pointee) {
        this.pointee = pointee;
    }

    public String getFrequence() {
        return this.frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategorie() {
        return this.categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getUser_id_op() {
        return this.user_id_op;
    }

    public void setUser_id_op(int user_id_op) {
        this.user_id_op = user_id_op;
    }

    public Operation(int op_id,String op_description, String op_date, Float op_montant, String type, int user_id_op) {
        this.op_id=op_id;
        this.op_description=op_description;
        this.op_date = op_date;
        this.op_montant=op_montant;
        this.type=type;
        this.user_id_op=user_id_op;
    }



    public Operation(int op_id,String op_description, String op_date, Float op_montant, String type,String pointee, int user_id_op) {
        this.op_id=op_id;
        this.op_description=op_description;
        this.op_date = op_date;
        this.op_montant=op_montant;
        this.type=type;
        this.pointee = pointee;
        this.user_id_op=user_id_op;
    }

    //?Contructeur pour l'ajout d'operation
    public Operation(String op_description, String op_date, Float op_montant, String pointee, String frequence, String type, String categorie, int user_id_op) {
        this.op_description = op_description;
        this.op_date = op_date;
        this.op_montant = op_montant;
        this.pointee = pointee;
        this.frequence = frequence;
        this.type = type;
        this.categorie = categorie;
        this.user_id_op = user_id_op;
    }



}
