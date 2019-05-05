package com.myorg.business;

import com.myorg.model.entity.Paquete;
import java.util.List;

public interface PaqueteBusiness extends CrudBusiness<Paquete> {
     public List<Paquete> listbyUser(Paquete t) throws Exception;
}
