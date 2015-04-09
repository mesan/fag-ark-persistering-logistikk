package no.mesan.fagark.persistering.logistikk;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class LogistikkRepositoryImpl implements LogistikkRepository {

	public Long innlevering(Long fangenummer, String ting) {
		return 2L;
	}
	
	public String utlevering(Long fangenummer) {
		return "HALLO";
	}
}