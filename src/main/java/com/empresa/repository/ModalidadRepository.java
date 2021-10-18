package com.empresa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.empresa.entity.FiltroModalidad;
import com.empresa.entity.Modalidad;

public interface ModalidadRepository extends JpaRepository<Modalidad, Integer>  {

	@Query("select d from Modalidad d where "
			+ "( :#{#fil.nombre} is '' or d.nombre like :#{#fil.nombre} ) and "
			+ "( :#{#fil.sede} is '' or d.sede like :#{#fil.sede} ) and "
			+ "( :#{#fil.idDeporte} is 0  or d.deporte.idDeporte = :#{#fil.idDeporte} ) ")
	public abstract List<Modalidad> listaPorFiltro(@Param("fil")FiltroModalidad filtro);
	
	
}
