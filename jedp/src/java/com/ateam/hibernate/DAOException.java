/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;

/**
 *
 * @author Andrew
 */
public class DAOException extends Exception {
    private Exception exception;
    public DAOException(String message){
        super(message);
    }
    public DAOException(Exception e){
        exception = e;
    }
        public DAOException(Exception e, String message){
            this(message);
            exception = e;
        }
     public Exception getNestedException(){
         return exception;
     }
}
