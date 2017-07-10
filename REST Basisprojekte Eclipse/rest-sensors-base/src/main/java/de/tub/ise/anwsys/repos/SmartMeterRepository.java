package de.tub.ise.anwsys.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import de.tub.ise.anwsys.models.SmartMeter;

public interface SmartMeterRepository extends JpaRepository<SmartMeter, String>{
	Optional<SmartMeter> findById(Long id);

	void delete(Long id);
}
