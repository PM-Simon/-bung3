package de.tub.ise.anwsys.repos;

import java.util.List;

import de.tub.ise.anwsys.models.Messdaten;

public interface MessdatenRepository {

	void delete(Long id);

	Messdaten findOne(Long id);

	Messdaten save(Messdaten m);

	List<Messdaten> findAll();

}
