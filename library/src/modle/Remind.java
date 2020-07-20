package modle;

public class Remind {
	private Integer id;
	private Integer uid;
	private Integer bid;
	
	public Remind() {}
	public Remind(int id, int uid, int bid) {
		this.id = id;
		this.uid = uid;
		this.bid = bid;
	}
	
	public Remind(int bid) {
		this.bid = bid;
	}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public int getUid() {return uid;}
	public void setUid(int uid) {this.uid = uid;}
	
	public int getBid() {return bid;}
	public void setBid(int bid) {this.bid = bid;}
}
