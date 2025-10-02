package com.javaLoja.Loja_projeto.exceptions;

public class ResourceNoFoundException extends RuntimeException{

    public ResourceNoFoundException(String message){super(message);}
    public  ResourceNoFoundException(Long id){super("Recurso nao encontrado com ID"+id);}
}
