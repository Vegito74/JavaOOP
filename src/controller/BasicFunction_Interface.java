/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.ArrayList;

/**
 *
 * @author baruk
 */
public interface BasicFunction_Interface<T> {
    public int add(T t);
    public int update(T t);
    public int delete(T t);
    public ArrayList<T> selectAll();
}
