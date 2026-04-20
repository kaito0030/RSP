package Model;

public enum Hand {
	GU("グー"),
	CHOKI("チョキ"),
	PA("パー");
	
	private final String label;
	
	Hand(String label){
		this.label=label;
	}
	public String getLabel() {
		return label;
	}
}
