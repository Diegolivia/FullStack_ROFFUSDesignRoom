
package com.myorg.model.repository;

import com.myorg.model.entity.Paquete;
import java.util.List;

public interface PaqueteRepository extends JPARepository<Paquete>{
    public List<Paquete> listbyUser(Paquete t) throws Exception;
}
