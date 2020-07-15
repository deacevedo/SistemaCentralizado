/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managebean;

import com.tienda.entidades.Empleado;
import com.tienda.session.EmpleadoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.view.ViewScoped;

/**
 *
 * @author danny
 */
@Named(value = "empleadoManageBean")
@ViewScoped
public class EmpleadoManageBean implements Serializable, ManageBeanInterface<Empleado> {

    @EJB
    private EmpleadoFacadeLocal empleadoFacadeLocal;

    public EmpleadoManageBean() {
    }
    //Variable para la lista de empleados.
    private List<Empleado> listaEmpleados;
    //Creo un objeto de tipo empleado
    private Empleado empleado;

    @PostConstruct
    public void init() {
        //Listar con este los empleados que estan en la BDD
        listaEmpleados = empleadoFacadeLocal.findAll();
       
    }

    @Override
    public void nuevo() {
        empleado = new Empleado();
    }

    @Override
    public void grabar() {
        try {
            if (empleado.getCodigo() == null) {
                empleadoFacadeLocal.create(empleado);
            } else {
                empleadoFacadeLocal.edit(empleado);
            }
            empleado = null;
            listaEmpleados = empleadoFacadeLocal.findAll();
            mostrarMensajeTry("INFORMACION OK", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void seleccionar(Empleado t) {
        empleado = t;
    }

    @Override
    public void eliminar(Empleado t) {
        try {
            empleadoFacadeLocal.remove(t);
            listaEmpleados = empleadoFacadeLocal.findAll();
            mostrarMensajeTry("ELEMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
        listaEmpleados = empleadoFacadeLocal.findAll();
        empleado = null;
    }
    

    public List<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Empleado> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
