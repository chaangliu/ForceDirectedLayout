package github.ForceDirectLayout.java;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static List<Node> sNodeArrayList = new ArrayList<>();
	private static List<Edge> sEdgeArrayList;

	public static void main(String[] args) {
		getData();
//		getRandomData();
		//随机生成坐标. Generate coordinates randomly.
		double initialX, initialY, initialSize = 40.0;
		for (Node node : sNodeArrayList) {
			initialX = 0 + CollisionGenerator.CANVAS_WIDTH * .5;
			initialY = 0 + CollisionGenerator.CANVAS_HEIGHT * .5;
			node.setXPosition(initialX + initialSize * (Math.random() - .5));
			node.setYPosition(initialY + initialSize * (Math.random() - .5));
		}

		CollisionGenerator collisionGenerator = new CollisionGenerator(sNodeArrayList, sEdgeArrayList);
		//迭代200次. Iterate 200 times.
		for (int i = 0; i < 200; i++) {
			collisionGenerator.collide();
		}
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.nodes = collisionGenerator.getNodeList();
		resultEntity.links = sEdgeArrayList;
		String res = new Gson().toJson(resultEntity);
		System.out.println(res);
	}

	static class ResultEntity {
		List<Node> nodes;
		List<Edge> links;
	}

	/**
	 * Manually constructed data. For reference only.
	 */
	private static void getData() {
		sEdgeArrayList = Utils.getEdges();
		for (int i = 0; i < 100; i++) {
			sNodeArrayList.add(new Node(i));
		}
	}

	/**
	 * 随机构造一些node和的edge。For reference only.
	 */
	private static void getRandomData() {
		sEdgeArrayList = new ArrayList<>();
		for (int i = 0; i < 20; i++) {
			Node node = new Node(i);
			sNodeArrayList.add(node);
		}
		for (int i = 0; i < 20; i++) {
			int edgeCount = (int) (Math.random() * 8);
			System.out.println(edgeCount);
			for (int j = 0; j < edgeCount; j++) {
				int targetId = (int) (Math.random() * 20);
				Edge edge = new Edge(i, targetId);
				sEdgeArrayList.add(edge);
			}
		}
	}
}
