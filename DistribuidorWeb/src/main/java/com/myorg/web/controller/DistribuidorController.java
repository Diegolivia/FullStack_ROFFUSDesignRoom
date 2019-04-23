package com.myorg.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import com.myorg.business.DistribuidorBusiness;
import com.myorg.model.entity.Distribuidor;
import com.myorg.util.Message;



@Named
@ViewScoped
public class DistribuidorController implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private DistribuidorBusiness distribuidorBusiness;

	private Distribuidor distribuidor;
	private Distribuidor distribuidorSelec;
	private List<Distribuidor> distribuidores;


	@PostConstruct
	public void init() {
		distribuidor = new Distribuidor();
		distribuidorSelec = new Distribuidor();
		loadDistribuidores();
	}

	public void loadDistribuidores() {
		try {
			this.distribuidores = distribuidorBusiness.list();
		} catch (Exception e) {
			Message.messageError("Error Distribuidor 2 :" + e.getMessage());
		}
	}

	public void saveDistribuidor() {
		try {
			if (distribuidor.getCodDistribuidor()!= null) {

				Message.messageInfo("Registro actualizado exitosamente");
				distribuidorBusiness.update(distribuidor);
			} else {
				distribuidorBusiness.insert(distribuidor);
				Message.messageInfo("Registro guardado exitosamente");

			}
			loadDistribuidores();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Distribuidor :" + e.getStackTrace());
		}
	}

	public void editDistribuidor() {
		try {
			if (this.distribuidorSelec!=null) {
				this.distribuidor = distribuidorSelec;
			} else {
				Message.messageInfo("Debe seleccionar un Distribuidor");
			}
		} catch (Exception e) {
			Message.messageError("Error Distribuidor :" + e.getMessage());
		}

	}
	
	public void deleteDistribuidor() {
		try {
			if (this.distribuidorSelec != null) {
				distribuidorBusiness.delete(distribuidorSelec);
				loadDistribuidores();
				clearForm();

			} else {

			}
		} catch (Exception e) {

		}
	}

	public void selectDistribuidor(SelectEvent e) {
		this.distribuidorSelec = (Distribuidor) e.getObject();
	}
	
	public void clearForm() {
		this.distribuidor = new Distribuidor();
		this.distribuidorSelec=null;
	}

	public Distribuidor getDistribuidor() {
		return distribuidor;
	}

	public void setDistribuidor(Distribuidor distribuidor) {
		this.distribuidor = distribuidor;
	}

	public Distribuidor getDistribuidorSelec() {
		return distribuidorSelec;
	}

	public void setDistribuidorSelec(Distribuidor distribuidorSelec) {
		this.distribuidorSelec = distribuidorSelec;
	}

	public List<Distribuidor> getDistribuidores() {
		return distribuidores;
	}

	public void setDistribuidores(List<Distribuidor> distribuidores) {
		this.distribuidores = distribuidores;
	}

}
