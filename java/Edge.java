package github.ForceDirectLayout.java;

class Edge {
	private String source;
	private String target;

	Edge(int source, int target) {
		this.source = source + "";
		this.target = target + "";
	}

	String getSource() {
		return source;
	}

	String getTarget() {
		return target;
	}
}
