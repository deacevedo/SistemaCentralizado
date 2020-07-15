/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.managebean;
import com.tienda.entidades.Cargo;
import com.tienda.session.CargoFacadeLocal;
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
@Named(value = "cargoManageBean")
@ViewScoped
public class CargoManageBean implements Serializable, ManageBeanInterface<Cargo> {

    @EJB
    private CargoFacadeLocal cargoFacadeLocal;

    //CONTRUCCTOR 
    public CargoManageBean() {
    }
    private List<Cargo> listaCargos;
    
    //Crear objeto tipo cargo
    private Cargo cargo;
   
    
    @PostConstruct
    public void init() {
        //Listar con este los cargos que estan en la BDD    
        listaCargos=cargoFacadeLocal.findAll();
    }

        
    @Override
    public void nuevo() {
        cargo = new Cargo();
    } 

    @Override
    public void grabar() {
        try {
            if (cargo.getCodigo()==null){
                cargoFacadeLocal.create(cargo);
            }else /*if(cargo.getCodigo()!= null && cargo == null){*/{
                cargoFacadeLocal.edit(cargo);
            }
            cargo = null;
            listaCargos=cargoFacadeLocal.findAll();
            mostrarMensajeTry("INFORMACION OK", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void seleccionar(Cargo c) {
        cargo = c;
    }

    @Override
    public void eliminar(Cargo c) {
        try {
            cargoFacadeLocal.remove(c);
            listaCargos = cargoFacadeLocal.findAll();
            mostrarMensajeTry("ELEMINADO EXITOSAMENTE", FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            mostrarMensajeTry("OCURRIO UN ERROR", FacesMessage.SEVERITY_ERROR);
        }
    }

    @Override
    public void cancelar() {
       listaCargos = cargoFacadeLocal.findAll();
        cargo = null;
        
    }
    
    public List<Cargo> getListaCargos() {
        return listaCargos;
    }

    public void setListaCargos(List<Cargo> listaCargos) {
        this.listaCargos = listaCargos;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
