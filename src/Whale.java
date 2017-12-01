
public class Whale {
	private String id;
	private String sex;
	private String dorsalCondition;
	private String numUpNick;
	private String numMidNick;
	private String numLowNick;
	private String numTotNick;
	private String locLargest;
	private String blkPattern;
	private String whtPattern;
	private String openSaddle;
	private String backMaleCurve;
	
	public Whale() {
		
	}
	
	public Whale(String id,String dorsalCondition, String sex, String numUpNick, String numMidNick, String numLowNick, String numTotNick, String locLargest, String blkPattern, String whtPattern, String openSaddle, String backMaleCurve) {
		this.setId(id);
		this.setDorsalCondition(dorsalCondition);
		this.setSex(sex);
		this.setNumUpNick(numUpNick);
		this.setNumMidNick(numMidNick);
		this.setNumLowNick(numLowNick);
		this.setNumTotNick(numTotNick);
		this.setLocLargest(locLargest);
		this.setBlkPattern(blkPattern);
		this.setWhtPattern(whtPattern);
		this.setOpenSaddle(openSaddle);
		this.setBackMaleCurve(backMaleCurve);
		
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNumUpNick() {
		return numUpNick;
	}

	public void setNumUpNick(String numUpNick) {
		this.numUpNick = numUpNick;
	}

	public String getNumMidNick() {
		return numMidNick;
	}

	public void setNumMidNick(String numMidNick) {
		this.numMidNick = numMidNick;
	}

	public String getNumLowNick() {
		return numLowNick;
	}

	public void setNumLowNick(String numLowNick) {
		this.numLowNick = numLowNick;
	}

	public String getNumTotNick() {
		return numTotNick;
	}

	public void setNumTotNick(String numTotNick) {
		this.numTotNick = numTotNick;
	}

	public String getLocLargest() {
		return locLargest;
	}

	public void setLocLargest(String locLargest) {
		this.locLargest = locLargest;
	}

	public String getBlkPattern() {
		return blkPattern;
	}

	public void setBlkPattern(String blkPattern) {
		this.blkPattern = blkPattern;
	}

	public String getWhtPattern() {
		return whtPattern;
	}

	public void setWhtPattern(String whtPattern) {
		this.whtPattern = whtPattern;
	}

	public String getOpenSaddle() {
		return openSaddle;
	}

	public void setOpenSaddle(String openSaddle) {
		this.openSaddle = openSaddle;
	}
	
	public String getBackMaleCurve() {
		return backMaleCurve;
	}
	
	public void setBackMaleCurve(String backMaleCurve) {
		this.backMaleCurve = backMaleCurve;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDorsalCondition() {
		return dorsalCondition;
	}

	public void setDorsalCondition(String dorsalCondition) {
		this.dorsalCondition = dorsalCondition;
	}
}
