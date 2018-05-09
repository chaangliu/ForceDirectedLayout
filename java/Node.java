package github.ForceDirectLayout.java;

class Node {
	private double x;
	private double y;
	private String id;

	Node(int id) {
		this.id = id + "";
	}

	void setXPosition(double x) {
		this.x = Utils.getInt(x);
	}

	void setYPosition(double y) {
		this.y = Utils.getInt(y);
	}

	double getX() {
		return x;
	}

	double getY() {
		return y;
	}

	String getKey() {
		return id;
	}
}
