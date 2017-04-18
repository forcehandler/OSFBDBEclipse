package superCsv;

public class Mall_Event {

	private String mallId;
	private String eventId;
	
	public Mall_Event() {
		super();
	}

	public String getMallId() {
		return mallId;
	}

	public void setMallId(String mallId) {
		this.mallId = mallId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(mallId);
		sb.append(',');
		sb.append(eventId);
		return sb.toString();
	}
}
