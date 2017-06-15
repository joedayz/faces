package pe.joedayz.ejemplos;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

public class PhaseTracker implements PhaseListener {

	public void afterPhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext().log("AFTER "+event.getPhaseId());
		}

	public void beforePhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext().log("BEFORE "+event.getPhaseId());
		}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
