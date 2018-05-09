package github.ForceDirectLayout.java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import github.ForceDirectLayout.java.data.DataSet1;

class Utils {
	//四舍五入把double转化int整型，0.5进一，小于0.5不进一
	static int getInt(double number) {
		BigDecimal bd = new BigDecimal(number).setScale(0, BigDecimal.ROUND_HALF_UP);
		return Integer.parseInt(bd.toString());
	}

	static List<Edge> getEdges() {
		String dataSet = getDataSet();
		if (dataSet == null) {
			return null;
		}
		String notRaw[] = dataSet.split(";");
		List<Edge> edgeList = new ArrayList<>();
		for (String str : notRaw) {
			String[] pair = str.split(" ");
			edgeList.add(new Edge(Integer.parseInt(pair[0]), Integer.parseInt(pair[1])));
		}
		return edgeList;
	}

	private static String getDataSet() {
		return DataSet1.dataSet;
	}
}