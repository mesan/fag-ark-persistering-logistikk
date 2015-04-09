package no.mesan.fagark.persistering.logistikk;

public interface LogistikkRepository {

	Long innlevering(Long fangenummer, String ting);
	
	String utlevering(Long fangenummer);
}